/*
smeneta e hash funkcijata vo CBHT, daena vo zadacata 
strana 191

input:
5
ACEROLA 0 100 1000
ACIKLOVIR 1 1650 87
HYDROCYKLIN 0 55 10
GENTAMICIN 1 152 90
HYDROCYKLIN20 0 113 20
hydroCyklinn
2
hydroCyklin20
2
END

output:
No such drug
HYDROCYKLIN20 NEG 113 20
Order made
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

    //smeneta e hash funkcijata 
    //raspredelbata na lekovite po koficki ke bide spored prvite 3 bukvi od imeto na lekot
    //znaci vo edna koficka moze da ima povekje lekovi kaj koj prvite 3 bukvi se isti
    private int hash(K key) {
        // Translate key to an index of the array buckets.
        String keyString = (String)key;
        return ((100*(100*(100*0+keyString.charAt(0)) + keyString.charAt(1)) + keyString.charAt(2))%656565) % buckets.length;
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


class Lek{
    String ime;
    int poz_neg;
    int cena;
    int zaliha;

    public Lek(String ime, int poz_neg, int cena, int zaliha) {
        this.ime = ime;
        this.poz_neg = poz_neg;
        this.cena = cena;
        this.zaliha = zaliha;
    }

    @Override
    public String toString() {
        String p_n;
        if (poz_neg == 0){
            p_n = "NEG";
        }
        else{
            p_n = "POZ";
        }
        return ime + " " + poz_neg + " " + cena + " " + zaliha;
    }
}

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       sc.nextLine();
       CBHT<String, Lek> table = new CBHT<>(2*n-1);

       for (int i = 0; i < n; i++) {
           String []parts = sc.nextLine().split(" ");
           String ime = parts[0];
           int poz_neg = Integer.parseInt(parts[1]);
           int cena = Integer.parseInt(parts[2]);
           int zaliha = Integer.parseInt(parts[3]);
           table.insert(ime.toUpperCase(), new Lek(ime, poz_neg, cena, zaliha));
       }

       while (true){
           String imeLek = sc.nextLine();
           if (imeLek.equalsIgnoreCase("END")){
               break;
           }

           int brParcinja = sc.nextInt();
           sc.nextLine();

           SLLNode<MapEntry<String, Lek>> curr = table.search(imeLek.toUpperCase());
           if (curr != null){
               if (brParcinja <= curr.element.value.zaliha){
                   System.out.println(curr.element.value);
                   System.out.println("Order made");
                   curr.element.value.zaliha -= brParcinja;
               }
               else{ //ako brojot na parcinja sho se barat e pogolem od zalihata
                   System.out.println("No drugs available");
               }
           }
           else{
               System.out.println("No such drug");
           }
       }
    }
}

