/*
Во Заводот на статистика се прави ново истражување каде што се открива бројот на луѓе родени во секој месец. 
Ваша задача е за даден месец да прикажете колку луѓе се родени во тој месец. 
Влез: Во првиот ред од влезот е даден бројот на луѓе N, а во секој нареден ред е даден датумот на раѓање. 
Во последниот ред е даден месецот за кој треба да се прикаже бројот на луѓе родени во тој месец.
Излез: Број на луѓе кои се родени во тој месец. Доколку нема луѓе родени во тој месец да се испечати „Empty”.

Пример
Влез:
4
20.7.1976
16.7.1988
18.7.1966
5.6.1988
7

Излез:
3
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

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Integer, Integer> table = new CBHT<>(2*n-1); //key e mesecot, value e brojac
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split("\\.");
            int month = Integer.parseInt(parts[1]);
            SLLNode<MapEntry<Integer, Integer>> curr = table.search(month);
            if (curr == null) {
                table.insert(month, 1);
            }
            else{
                int prev_counter = curr.element.value;
                table.insert(month, prev_counter + 1);
            }
        }

        int m = sc.nextInt();
        SLLNode<MapEntry<Integer, Integer>> curr = table.search(m);
        if (curr == null) {
            System.out.println("Empty");
        }
        else{
            System.out.println(curr.element.value);
        }
    }
}
