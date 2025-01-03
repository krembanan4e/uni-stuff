/*
Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик. Потоа даден ви е текст којшто е напишан на кумановски дијалект. 
Потребно е да ги замените сите појавувања на зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?). 
Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на македонски јазик исто така треба да се отпечати со прва голема буква.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable 
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }
    
    public int compareTo (K that) {
    // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
		MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
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
	private SLLNode<MapEntry<K,E>>[] buckets;

	@SuppressWarnings("unchecked")
	public CBHT(int m) {
		// Construct an empty CBHT with m buckets.
		buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
	}

	private int hash(K key) {
		// Napishete ja vie HASH FUNKCIJATA
		return Math.abs(key.hashCode()) % buckets.length;
	}

	public SLLNode<MapEntry<K,E>> search(K targetKey) {
		// Find which if any node of this CBHT contains an entry whose key is
		// equal
		// to targetKey. Return a link to that node (or null if there is none).
		int b = hash(targetKey);
		for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
				return curr;
		}
		return null;
	}

	public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
		MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
		int b = hash(key);
		for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (key.equals(((MapEntry<K, E>) curr.element).key)) {
				// Make newEntry replace the existing entry ...
				curr.element = newEntry;
				return;
			}
		}
		// Insert newEntry at the front of the 1WLL in bucket b ...
		buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
	}

	public void delete(K key) {
		// Delete the entry (if any) whose key is equal to key from this CBHT.
		int b = hash(key);
		for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
			if (key.equals(((MapEntry<K,E>) curr.element).key)) {
				if (pred == null)
					buckets[b] = curr.succ;
				else
					pred.succ = curr.succ;
				return;
			}
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < buckets.length; i++) {
			temp += i + ":";
			for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
				temp += curr.element.toString() + " ";
			}
			temp += "\n";
		}
		return temp;
	}

}

public class KumanovskiDijalekt {
	public static void main (String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		int N = Integer.parseInt(br.readLine());
		
		String rechnik[]=new String[N];
		for(int i=0;i<N;i++){ 
			rechnik[i]=br.readLine();
		}
        
		String tekst=br.readLine();
		
        //Vasiot kod tuka
        
        if (N == 0){
            System.out.println(tekst);
            return;
        }

        CBHT<String, String> table = new CBHT<>(5*N-1); //key e kumanovski, value e makedonski

        for (int i=0;i<N;i++){
            String []parts = rechnik[i].split(" ");
            String kumanovski = parts[0];
            String makedonski = parts[1];
            table.insert(kumanovski,makedonski);
        }

        String []parts = tekst.split(" ");
        for (int i=0;i<parts.length;i++){
            if (parts[i].charAt(parts[i].length()-1)=='.' ||
                    parts[i].charAt(parts[i].length()-1)==',' ||
                    parts[i].charAt(parts[i].length()-1)=='!' ||
                    parts[i].charAt(parts[i].length()-1)=='?'){
                parts[i] = parts[i].substring(0,parts[i].length()-1); //da se trgnat znacite od nakraj za da se prebaruvat spored zborot bez znak
            }
        }

        String []zborchinja = tekst.split(" "); //ovde se zborojte so si znakot nakraj

        for (int i=0;i<parts.length;i++){
            SLLNode<MapEntry<String, String>> curr = table.search(parts[i].toLowerCase());
            if (curr == null){
                System.out.print(zborchinja[i] + " ");
            }
            else{
                if (zborchinja[i].charAt(zborchinja[i].length()-1)=='.' ||
                        zborchinja[i].charAt(zborchinja[i].length()-1)==',' ||
                        zborchinja[i].charAt(zborchinja[i].length()-1)=='!' ||
                        zborchinja[i].charAt(zborchinja[i].length()-1)=='?') {

                    if (Character.isUpperCase(zborchinja[i].charAt(0))) {
                        System.out.print(Character.toUpperCase(curr.element.value.charAt(0)) + curr.element.value.substring(1) + zborchinja[i].charAt(zborchinja[i].length()-1) + " ");
                    } else {
                        System.out.print(curr.element.value + zborchinja[i].charAt(zborchinja[i].length()-1) + " ");
                    }
                }
                else{
                    if (Character.isUpperCase(zborchinja[i].charAt(0))) {
                        System.out.print(Character.toUpperCase(curr.element.value.charAt(0)) + curr.element.value.substring(1) + " ");
                    } else {
                        System.out.print(curr.element.value + " ");
                    }
                }
            }
        }
		
	}
}
