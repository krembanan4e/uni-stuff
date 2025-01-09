/*
За различни градови дадени се мерењата на температурата (степени Целзиусови) во одредени временски интервали. Ваша задача е за даден град да се наjде наjтоплиот период од денот.
Влез: Во првиот ред од влезот е даден броjот на мерења 𝑁 (𝑁<= 10000), а во секоj нареден ред е даден прво градот, 
потоа почеток на интервал, краj на интервал и температурата разделени со празно место. 
Во последниот ред е даден градот за коj треба да наjдете наjтопол период од денот и истиот период да се испечати. Сложеноста на оваа операциjа треба да биде O(1). 
Излез: Наjтоплиот период од денот за даден град. 
Да се испечати во следниов формат: G: HH:MM – XX:YY Z, каде што G е градот, HH:MM e почетокот на интервалот, XX:YY е краjот на интервалот, а Z e температурата во степени Целзиусови. 

Пример
Влез:
4
Ohrid,Macedonia 10:00 12:00 23.1 
Skopje,Macedonia 09:00 10:30 24 
Ohrid,Macedonia 12:00 13:00 25 
Skopje,Macedonia 10:00 11:00 26.2
Ohrid,Macedonia

Излез:
Ohrid,Macedonia: 12:00 - 13:00 25.0
*/

import java.util.*;

class MapEntry<K extends Comparable<K>, E> {
    // Each MapEntry object is a pair consisting of a key (a Comparable object)
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
    }
}

class Merenje{
    String city;
    String time_from;
    String time_to;
    float temperature;

    public Merenje(String city, String time_from, String time_to, float temperature) {
        this.city = city;
        this.time_from = time_from;
        this.time_to = time_to;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return city + ": " + time_from + " - " + time_to + " " + String.format("%.1f", temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Merenje> table = new CBHT<String, Merenje>(2*n-1);
        for (int i = 0; i < n; i++) {
            String city = sc.next();
            String time_from = sc.next();
            String time_to = sc.next();
            float temperature = sc.nextFloat();

            Merenje merenje = new Merenje(city, time_from, time_to, temperature);
            SLLNode<MapEntry<String, Merenje>> curr = table.search(city);

            if (curr == null) {
                table.insert(city, merenje);
            }
            else {
                float prev_temp = curr.element.value.temperature;
                Merenje prev_merenje = curr.element.value;

                if (prev_temp >= temperature){
                    table.insert(city, prev_merenje);
                }
                else{
                    table.insert(city, merenje);
                }
            }
        }

        String city = sc.next();
        SLLNode<MapEntry<String, Merenje>> curr = table.search(city);
        if (curr == null) {
            System.out.println("Empty");
        }
        else{
            System.out.println(curr.element.value);
        }
    }
}

