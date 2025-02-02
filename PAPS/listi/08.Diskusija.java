package listi;

/*
Во рамки на еден форум постојат повеќе отворени дискусии, т.ш. за секоја дискусија се чува податок за: 
id на дискусијата (int id), популарност (int popularity), како и број на корисници кои се активни (int users).
Популарноста на дискусијата е вредност во ранг [1, 100], каде што популарност 100 означува највисока популарност.
Во рамки на форумот има повеќе отворени дискусии, кои можат да се поделат во две еднострано поврзани листи.
Во првата листа се чуваат податоците за дискусиите на тема Health, а додека во втората листа се чуваат податоците за дискусиите на тема Finance.
За секоја дискусија може да се пресмета нејзината важност како производ на нејзината популарност и бројот на активни корисници.
importance = popularity * users
Ваша задача е од дискусиите на тема Finance да се отстрани дискусијата со најмала важност.
Потоа, во дискусиите на тема Finance да се додаде нова дискусија со идентични податоци како најважната дискусија од темата Нealth.
Додавањето на дискусијата се прави на крај на листата која ги чува податоците за дискусиите на таа тема.
Влез:
Во првиот ред е даден бројот на дискусии од Health темата.
Во вториот ред е даден бројот на дискусии од Finance темата.
Во секој следен ред се дадени податоци за една дискусија, одделени со празно место, во формат id popularity users.
Притоа, прво се дадени податоците за дискусиите од Health листата, по што следуваат податоците за дискусиите од Finance листата.
Излез:
Во првиот ред ід на сите дискусии од Health листата.
Во вториот ред id на сите дискусии од Finance листата.
Забелешка:
Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Forum.java, со целосно имплементиран input и output.
Потребно е да се менува само во рамки на void forum(SLL<Discussion> health, SLL <Discussion> finance) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.
Не смее да менувате во main функцијата !

2
2
111 80 12
222 70 11
333 50 10
444 90 77
--------------
111 222
444 111


3
3
234 58 100
663 59 3
825 18 50
256 48 55
202 80 44
242 93 74
--------------
234 663 825
202 242 234


1
1
100 11 21
791 2 18
--------------
100
100


5
6
336 13 9
498 24 100
174 46 18
107 33 39
320 75 22
730 57 36
518 64 59
603 7 62
555 74 8
480 69 24
441 7 16
----------------
336 498 174 107 320
730 518 603 555 480 498
 */

import java.util.*;

class Diskusija{
    int id;
    int popularity;
    int users;

    public Diskusija(int id, int popularity, int users) {
        this.id = id;
        this.popularity = popularity;
        this.users = users;
    }

    public int vazhnost(){
        return popularity * users;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_Diskusii {
    private static void forum(SLL<Diskusija> health, SLL<Diskusija> finance) {
        SLLNode<Diskusija> curr = finance.getFirst();
        SLLNode<Diskusija> najNevazhna = finance.getFirst();
        while (curr != null){
            if (curr.element.vazhnost() <= najNevazhna.element.vazhnost()){
                najNevazhna = curr;
            }
            curr = curr.succ;
        }

        finance.delete(najNevazhna);

        SLLNode<Diskusija> najvazhna = health.getFirst();
        curr = health.getFirst();
        while (curr != null){
            if (curr.element.vazhnost() >= najvazhna.element.vazhnost()){
                najvazhna = curr;
            }
            curr = curr.succ;
        }

        finance.insertLast(najvazhna.element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Diskusija> health = new SLL<>();
        SLL<Diskusija> finance = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int popularity = sc.nextInt();
            int users = sc.nextInt();
            Diskusija d = new Diskusija(id, popularity, users);
            health.insertLast(d);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int popularity = sc.nextInt();
            int users = sc.nextInt();
            Diskusija d = new Diskusija(id, popularity, users);
            finance.insertLast(d);
        }

        forum(health, finance);
        System.out.println(health);
        System.out.println(finance);
    }
}
