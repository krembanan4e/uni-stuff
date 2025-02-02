package hash;

/*
Во магацинот на една фармацевтска компанија се чуваат најразлични видови лекови. 
За секој лек потребно е да се чуваат податоци за името на лекот, цената во денари и намената на лекот. 
За поефикасен пристап до податоците за лековите, фармацевтската компанија одлучила податоците да ги чува во хеш табела (СВНТ) каде се сместуваат соодветните податоци.
Хеш табелата е достапна до крајните клиенти и истите може да пребаруваат низ внесените податоци. 
Бидејќи на пазарот постојат повеќе лекови кои таргетираат иста болест, најчесто клиентите го бараат оној лек кој има најниска цена. 
Па вашата задача е со користење на хеш табелата, за дадена намена (болест), да го испечатите лекот кој има најниска цена на пазарот. 
Доколку за бараната намена во магацинот нема лек се печати "Nema lek za baranata namena vo magacin.".
Влез:
Најпрво е даден бројот на лекови - N, а потоа секој лек е даден во нов ред во форматот:
"Име на лек" "Намена" "Цена во денари"
На крај е дадена намената за која треба да се пронајде лекот со најниска цена.
Излез:
Името на лекот со најмала цена.

Влез:
5
Analgin Glavobolka 80
Daleron Glavobolka 90
Lineks Bolki_vo_stomak 150
Spazmeks Bolki_vo_stomak 150
Loratadin Alergija 150
Glavobolka

Излез:
Analgin
 */

import java.util.*;

class Lek{
    String ime;
    int cena;

    public Lek(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return ime;
    }
}

public class Ispitna_Farmacija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        CBHT<String, Lek> table = new CBHT<String, Lek>(2*n-1);
        for (int i = 0; i < n; i++) {
            String ime = sc.next();
            String namena = sc.next();
            int cena = sc.nextInt();
            sc.nextLine();
            Lek lek = new Lek(ime, cena);

            SLLNode<MapEntry<String, Lek>> curr = table.search(namena);
            if (curr == null){
                table.insert(namena, lek);
            }
            else{
                Lek prev_lek = curr.element.value;
                if (prev_lek.cena < cena){
                    table.insert(namena, prev_lek);
                }
                else {
                    table.insert(namena, lek);
                }
            }
        }

        String namena = sc.nextLine();
        SLLNode<MapEntry<String, Lek>> curr = table.search(namena);
        if (curr == null){
            System.out.println("Nema lek za baranata namena vo magacin.");
        }
        else{
            System.out.println(curr.element.value);
        }
    }
}
