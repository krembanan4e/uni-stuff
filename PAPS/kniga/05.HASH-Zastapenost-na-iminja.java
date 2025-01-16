package zastapenostNaIminja;
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

    public SLLNode<MapEntry<K,E>> getFirst (K targetKey){  //-----------> za toj hesh, spored dvete bukvi, vrati ja cela sodrzina na kofickata (mojt da imat pojke elementi vo edna koficka)
        int b = hash(targetKey);
        return buckets[b];
    }
}

class Ime implements Comparable<Ime>{
    String ime;

    public Ime(String ime) {
        this.ime = ime.toUpperCase();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ime ime1 = (Ime) o;
        return Objects.equals(ime, ime1.ime);
    }

    @Override
    public int hashCode() {
        //return Objects.hashCode(ime);
        return (100 * ime.charAt(0) + ime.charAt(1)) % 9091;
    }

    @Override
    public String toString() {
        return ime;
    }


    @Override
    public int compareTo(Ime o) {
        return ime.compareTo(o.ime);
    }
}

public class ZastapenostNaIminja {  //----------------------------> Dodaj getFirst() metod vo klasata CBHT
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Ime, Integer> zenski = new CBHT<>(9091);
        CBHT<Ime, Integer> maski = new CBHT<>(9091);

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            Ime ime = new Ime(parts[0]);
            String pol = parts[1];

            if (pol.equals("F")){
                SLLNode<MapEntry<Ime, Integer>> curr = zenski.search(ime);
                if (curr == null){
                    zenski.insert(ime, 1);
                }
                else{
                    zenski.insert(ime, curr.element.value + 1);
                }
            }
            else if (pol.equals("M")){
                SLLNode<MapEntry<Ime , Integer>> curr = maski.search(ime);
                if (curr == null){
                    maski.insert(ime, 1);
                }
                else{
                    maski.insert(ime, curr.element.value + 1);
                }
            }
        }

        //System.out.println(zenski);

        String pol = sc.nextLine();

        while (true){
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("end")){
                break;
            }

            Ime ime = new Ime(str);
            //definiraj getFirst metod vo klasata CBHT

            if (pol.equals("F")){
                SLLNode<MapEntry<Ime, Integer>> curr = zenski.getFirst(ime); //ako imat pojke iminja vo kofickata, zemi go prvoto (ko lista)
                if (curr == null){
                    System.out.println("No such name");
                    continue;
                }
                else{
                    while (curr != null){
                        System.out.println(curr.element.key.toString());
                        curr = curr.succ;
                    }
                }

                SLLNode<MapEntry<Ime, Integer>> baraj = zenski.search(ime); //ako e samo edno ime vo kofickata da ispecatit podatoci za nego
                if (baraj == null){
                    System.out.println("No such name");
                }
                else {
                    System.out.println(pol + " " + baraj.element.key.toString() + " " + baraj.element.value);
                }
            }
            
            else if (pol.equals("M")){
                SLLNode<MapEntry<Ime, Integer>> curr = maski.getFirst(ime); //ako imat pojke iminja vo kofickata, zemi go prvoto (ko lista)
                if (curr == null){
                    System.out.println("No such name");
                    continue;
                }
                else{
                    while (curr != null){
                        System.out.println(curr.element.key.toString());
                        curr = curr.succ;
                    }
                }

                SLLNode<MapEntry<Ime, Integer>> baraj = maski.search(ime); //ako e samo edno ime vo kofickata da ispecatit podatoci za nego
                if (baraj == null){
                    System.out.println("No such name");
                }
                else {
                    System.out.println(pol + " " + baraj.element.key.toString() + " " + baraj.element.value);
                }
            }
        }
    }
}
