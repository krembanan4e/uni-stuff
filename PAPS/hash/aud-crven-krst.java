/*
Во рамки на една хуманитарна организација, потребно е да се направи статистика за крвните групи кои се на располагање за донација, и од кои донатори. 
Подгрупите А1+, А2+ припаѓаат на крвна група А+, додека А1- , А2- припаѓаат на група А-.
Влез: Во првиот ред од влезот е даден бројот на парови N, а во секој нареден ред се дадени паровите (донатор, крвна група).
Излез: Да се испечати по колку донатори има од секоја крвна група согласно внесените податоци.

Пример
Влез:
5
Alek A1+
Dejan B-
Sandra A+
Trajce 0+
Rebeka A1-

Излез:
A+ = 2
B- = 1
0+ = 1
A- = 1
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
        return key + " = " + value;
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
        for (int i = buckets.length-1; i >= 0; i--) {
            //temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
                temp += "\n";
            }
            //temp += "\n";
        }
        return temp;
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> table = new CBHT<>(n); //key e krvnata grupa, value e brojac
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            char bukva = parts[1].charAt(0);
            char znak = parts[1].charAt(parts[1].length()-1);
            String krvna_grupa = bukva + "" + znak;

            SLLNode<MapEntry<String, Integer>> curr = table.search(krvna_grupa);
            if (curr == null) {
                table.insert(krvna_grupa, 1);
            }
            else{
                int prev_counter = curr.element.value;
                table.insert(krvna_grupa, prev_counter + 1);
            }
        }

        System.out.println(table);

    }
}
