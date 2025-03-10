package hash;

/*
Дадена е листа на дати на раѓање на сите вработени во една организација.
Ваша задача е за даден датум да испечатите кои вработени на организацијата ќе слават роденден тој ден и колку години ќе полнат (сортирани според името на вработениот).
Доколку за дадениот датум нема родендени да се испечати Nema.
Влез: Во првиот ред од влезот е даден бројот на вработени, а во секој нареден ред е прво дадено името и презимето на вработениот и датата на раѓање (формат dd/mm/yyуу).
Во последниот ред е даден датумот за кој треба да испечатите кои луѓе слават роденден на тој датум.
Излез: Името на вработениот и колку години полни, сортирани според името на вработениот.
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест-примери.
Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл. На располагање од структурите имате само хеш структура.
Единствено за сортирање на резултатите може да користите помошна структура. Име на класа (Јава): Rodendeni

Sample input
3
Magdalena Kostoska 15/05/1982
Hristina Mihajloska 30/05/1984
Ilinka Ivanoska 15/05/1986
15/05/2016

Sample output
Ilinka Ivanoska 30
Magdalena Kostoska 34
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Personn{
    String name;
    String date;
    int year;

    public Personn(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Ispitna_Rodendeni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, List<Personn>> table = new CBHT<>(2*n-1);
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String name = parts[0] + " " + parts[1];
            String date = parts[2];
            Personn p = new Personn(name, date);
            
            String key = date.substring(0, 5);
            int year = Integer.parseInt(date.substring(6, 10));
            p.setYear(year);

            SLLNode<MapEntry<String, List<Personn>>> curr = table.search(key);
            if (curr == null){
                List<Personn> list = new ArrayList<>();
                list.add(p);
                table.insert(key, list);
            }
            else{
                List<Personn> prev_list = curr.element.value;
                prev_list.add(p);
                table.insert(key, prev_list);
            }
        }

        String date = sc.next();
        String key = date.substring(0, 5);
        int year = Integer.parseInt(date.substring(6, 10));

        SLLNode<MapEntry<String, List<Personn>>> curr = table.search(key);
        if (curr == null){
            System.out.println("Nema");
        }
        else{
            List<Personn> list = curr.element.value;
            list.sort((p1, p2) -> p1.name.compareTo(p2.name));
            for (Personn p : list){
                System.out.println(p.name + " " + (year - p.year));
            }
        }

       // System.out.println(table);
    }
}
