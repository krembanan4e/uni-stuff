/*
strana 182

input:
6
Centar Stojanoski negative
Centar Trajkovski positive
Centar Petkovski positive
Karpos Stojanoski positive
Karpos Trajkovski negative
Centar Trajkovski positive
Centar

output:
0.75
*/

import java.util.Objects;
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


public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       sc.nextLine();
       CBHT<String, Integer> table_pozitivni = new CBHT<>(2*n-1); //key e opstinata, value e brojac na pozitivni
       CBHT<String, Integer> table_negativni = new CBHT<>(2*n-1); //key e opstinata, value e brojac na negativni
       for (int i = 0; i < n; i++) {
           String []parts = sc.nextLine().split(" ");
           String opstina  = parts[0];
           String prezime  = parts[1];
           String pozNeg  = parts[2];

           if (Objects.equals(pozNeg, "positive")){ //baraj vo tabelata so pozitivni
               SLLNode<MapEntry<String, Integer>> curr = table_pozitivni.search(opstina);
               if (curr != null){
                   int prev_counter = curr.element.value;
                   table_pozitivni.insert(opstina, prev_counter+1);
               }
               else{
                   table_pozitivni.insert(opstina,1);
               }
           }
           
           else if (Objects.equals(pozNeg, "negative")){ //baraj vo tabelata so negativni
               SLLNode<MapEntry<String, Integer>> curr = table_negativni.search(opstina);
               if (curr != null){
                   int prev_counter = curr.element.value;
                   table_negativni.insert(opstina, prev_counter+1);
               }
               else{
                   table_negativni.insert(opstina,1);
               }
           }
       }

       String opstina = sc.nextLine();

       int pozitivni=0;
       int negativni=0;

       SLLNode<MapEntry<String, Integer>> currP = table_pozitivni.search(opstina);
       if (currP != null){
           pozitivni = currP.element.value;
       }

       SLLNode<MapEntry<String, Integer>> currN = table_negativni.search(opstina);
        if (currN != null){
            negativni = currN.element.value;
        }

        float rizikFaktor = (float) pozitivni / (pozitivni+negativni);
        System.out.println(rizikFaktor);
    }
}
