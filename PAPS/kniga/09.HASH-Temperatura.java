/*
strana 199

input
4
Ohrid,Macedonia 10:00 12:00 23.1
Skopje,Macedonia 09:00 10:30 24
Ohrid,Macedonia 12:00 13:00 25
Skopje,Macedonia 10:00 11:00 26.2
Ohrid,Macedonia

output
Ohrid,Macedonia: 12:00 - 13:00 25.0
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

class MapEntry<K, E> {
    // Each MapEntry object is a pair consisting of a key
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

class CBHT<K, E> {
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
    String grad;
    String pocetok;
    String kraj;
    float temperatura;

    public Merenje(String grad, String pocetok, String kraj, float temperatura) {
        this.grad = grad;
        this.pocetok = pocetok;
        this.kraj = kraj;
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return grad + ": " + pocetok + " - " + kraj + " " + String.format("%.1f", temperatura);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Merenje> table = new CBHT<>(2*n-1);
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String grad = parts[0];
            String pocetok = parts[1];
            String kraj = parts[2];
            float temperatura = Float.parseFloat(parts[3]);

            SLLNode<MapEntry<String, Merenje>> curr = table.search(grad);
            if (curr != null) {
                float prev_temp = curr.element.value.temperatura;
                if (temperatura > prev_temp){ //noviot dodaj go
                    table.insert(grad, new Merenje(grad, pocetok, kraj, temperatura));
                }
                else{ //stariot dodaj go
                    table.insert(grad, new Merenje(curr.element.value.grad, curr.element.value.pocetok, curr.element.value.kraj, curr.element.value.temperatura));
                }
            }
            else {
                table.insert(grad, new Merenje(grad, pocetok, kraj, temperatura));
            }
        }

        String grad = sc.nextLine();
        SLLNode<MapEntry<String, Merenje>> curr = table.search(grad);
        if (curr != null) {
            System.out.println(curr.element.value.toString());
        }
        else{
            System.out.println("Nema zapis za toj grad");
        }
    }
}

