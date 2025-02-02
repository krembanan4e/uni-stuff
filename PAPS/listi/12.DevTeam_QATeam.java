package listi;

/*
Податоци за вработените во компанијата IOSolutions се чуваат во две еднострано поврзани листи.
Во првата листа се чуваат податоците за вработените кои се дел од тимот Dev, а додека пак во втората се чуваат податоците за вработените кои се дел од тимот Qa.
И кај двете листи, во секој од јазлите се чуваат број за идентификација (id) и возраста на вработениот за кој се однесува тој јазел.
Со зголемување на обемот на работа, потребно е да се зголеми бројот на членови во Dev тимот.
За таа цел, главниот менаџер решил да го отстрани најмладиот член од Qа тимот и да го додаде кон Dev тимот.
Тоа значи дека потребно е од листата каде се чуваат членовите на Qа тимот да се отстрани (избрише) најмладиот член (доколку има повеќе, последниот таков член),
и истиот да се додаде на средина на листата каде што се чуваат членовите на Dev тимот.
Влез:
Во првиот ред е даден бројот на вработени кои се дел од Dev тимот. Во вториот ред е даден бројот на вработени кои се дел од Qа тимот.
Во следните редови се дадени паровите податоци за секој вработен, одделени со празно место, во формат ід возраст.
Излез:
Во првиот ред id на сите вработени кои се дел од Dev тимот. Во вториот ред id на сите вработени кои се дел од Qa
тимот.
Забелешка:
Даден е целосниот код на структурата која што треба да се користи.
Потребно е да направат дополнувања во main функцијата и да се имплементирана void alterTeams(SLL devTeam, SLL qaTeam) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазел, а додавањето како додавање на цел јазел.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.

2
3
16100 20
17200 30
19898 20
14203 35
18100 19
--------------
16100 18100 17200
19898 14203


3
3
16100 20
17200 30
18112 45
14102 19
19203 35
18900 20
----------------
16100 17200 14102 18112
19203 18900
 */

import java.util.Scanner;

class Vraboten{
    int id;
    int age;

    public Vraboten(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_DevTeam_QATeam {
    private static void alterTeams(SLL<Vraboten> devTeam, SLL<Vraboten> qaTeam) {
        SLLNode<Vraboten> curr = qaTeam.getFirst();
        SLLNode<Vraboten> najmlad = qaTeam.getFirst();
        while (curr != null) {
            if (curr.element.age <= najmlad.element.age) {
                najmlad = curr;
            }
            curr = curr.succ;
        }

        int size = devTeam.size();
        int n;
        if (size % 2 == 0){
            n = size / 2;
        }
        else{
            n = size / 2 + 1;
        }

        curr = devTeam.getFirst();
        for (int i = 0; i < n; i++) {
            curr = curr.succ;
        }

        devTeam.insertBefore(najmlad.element, curr);
        qaTeam.delete(najmlad);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Vraboten> devTeam = new SLL<>();
        SLL<Vraboten> qaTeam = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int age = sc.nextInt();
            Vraboten d = new Vraboten(id, age);
            devTeam.insertLast(d);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int age = sc.nextInt();
            Vraboten d = new Vraboten(id, age);
            qaTeam.insertLast(d);
        }

        alterTeams(devTeam, qaTeam);
        System.out.println(devTeam);
        System.out.println(qaTeam);
    }
}
