package hesh;
import java.util.*;
//strana 224 vo knigata

/*
Input:
5
SK1234AA Anita Angelovska
OH1212BE Aleksandar Antov
ST0989OO Ognen Spirovski
ST0000AB Sara Spasovska
SK8888KD Dino Ackov
50
SK8888KD 48 14:00:00 ST0000AB 55 12:00:02 ST0989OO 60 08:10:00 SK1234AA 65 20:00:10 OH1212BE 50 22:00:21

Output:
Ognen Spirovski
Sara Spasovska
Anita Angelovska
*/

class Covek implements Comparable<Covek>{
    String imePrezime;
    String registracija;
    int brzina;
    String vreme;

    public Covek(String imePrezime, String registracija) {
        this.imePrezime = imePrezime;
        this.registracija = registracija;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public int compareTo(Covek o) {
        if (this.vreme.compareTo(o.vreme) > 0) {
            return 1;
        }
        if (this.vreme.compareTo(o.vreme) < 0) {
            return -1;
        }
        return 0;
    }
}

public class Semafori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Covek> table = new CBHT<>(2*n-1); //key e registracijata, value e coekot

        for (int i=0; i<n; i++){
            String []parts = sc.nextLine().split(" ");
            String registracija= parts[0];
            String imePrezime = parts[1] + " " + parts[2];

            Covek covek = new Covek(imePrezime, registracija);
            table.insert(registracija, covek);
        }

        ArrayList<Covek> lugje= new ArrayList<>();

        int max_brzina = sc.nextInt();
        sc.nextLine();
        String []parts = sc.nextLine().split(" ");

        for (int i=0; i<parts.length; i+=3){
            String registracija = parts[i];
            int brzina = Integer.parseInt(parts[i+1]);
            String vreme = parts[i+2];

            SLLNode<MapEntry<String, Covek>> curr = table.search(registracija);

            if (brzina > max_brzina){
                if (curr != null){
                    curr.element.value.setVreme(vreme);
                    lugje.add(curr.element.value);
                }
            }
        }

        Collections.sort(lugje);
        for (Covek covek : lugje){
            System.out.println(covek);
        }
    }
}
