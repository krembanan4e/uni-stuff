import java.util.*;

//strana 241 vo knigata

/*
6
Aleksandra,Marko
Beti,Marko
Marko,Filip
Darko,Elena
Elena,Filip
Filip,Filip

Излез:
Elena: 1
Filip: 5 -----------------> greska e, trebit da e Filip: 2
Marko: 2
 */

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
        return key + ": " + value;
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
            //temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + "\n";
                curr = curr.succ;
            }
            //temp += "\n";
        }
        return temp;
    }
}

public class Kompanija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, List<String>> table = new CBHT<>(2*n-1); //key e menadzerot, value e lista od vraboteni
        CBHT<String, Integer> table2 = new CBHT<>(2*n-1); //key e menadzerot, value e kolku vraboteni imat toj menadzer
        List<String> menadzeri = new ArrayList<>(); //za da se sortiret nakraj spored imeto

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(",");
            String vraboten = parts[0];
            String menadzer = parts[1];

            if (menadzer.equals(vraboten)){
                continue;
            }

            SLLNode<MapEntry<String, List<String>>> curr = table.search(menadzer);
            if (curr == null) {
                List<String> list = new ArrayList<>();
                list.add(vraboten);
                table.insert(menadzer, list);
                table2.insert(menadzer, list.size());
            }
            else{
                List<String> list2 = curr.element.value;
                list2.add(vraboten);
                table.insert(menadzer, list2);
                table2.insert(menadzer, list2.size());
            }

            if (!menadzeri.contains(menadzer)){
                menadzeri.add(menadzer);
            }

        }

        //System.out.println(table2);
        Collections.sort(menadzeri);
      
        for (String menadzer : menadzeri){
            SLLNode<MapEntry<String, Integer>> curr = table2.search(menadzer);
            System.out.println(menadzer + ": " + curr.element.value);
        }
        
    }
}
