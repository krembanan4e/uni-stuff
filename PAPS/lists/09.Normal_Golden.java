package listi;

/*
Во рамки на една банка се користи систем кој ги чува податоците за клиентите на банката.
Во тој систем податоците за еден клиент се дадени во формат: id на корисник (int id), години на лојалност (int loyalty), број на активни трансакциски сметки (int accounts).
Имајќи предвид дека банката постои 50 години, ниту еден корисник не може да има лојалност поголема од 50.
Во рамки на системот, корисниците се чуваат во две еднострано поврзани листи.
Во првата листа се чуваат податоците за обичните корисници (Normal), додека пак во втората листа се чуваат податоците за корисниците со посебни привилегии (Golden).
За секој клиент може да се пресмета неговата важност за банката според формулата:
importance = loyalty * 10 + accounts * 20
Банката решила дека сака да направи измена, односно да го отстрани најмалку важниот клиент од Golden листата и да го стави на крај на Normal листата.
Потоа, да го отстрани најмногу важниот клиент од Normal листата и да го стави на крај на Golden листата.
Внимавајте: Ако има повеќе клиенти со иста важност, се отстранува првиот.
Влез:
Во првиот ред е даден бројот на клиенти од Normal листата.
Во вториот ред е даден бројот на дискусии од Golden листата.
Во секој следен ред се дадени податоци за еден клиент, одделени со празно место, во формат id loyalty accounts.
Притоа, прво се дадени податоците за клиентите од Normal листата, по што следуваат податоците за клиентите од Golden листата.
Излез:
Во првиот ред id на сите клиенти од Normal листата.
Во вториот ред id на сите клиенти од Golden листата.
Забелешка:
Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Bank.java, со целосно имплементиран input и output.
Потребно е да се менува само во рамки на void bank(SLL<Client> normal, SLL<Client> golden) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол.
Промените (бришење/ додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.

3
2
56 20 3
24 10 2
55 20 3
12 20 4
13 20 4
------------
56 24 55
12 13


3
2
80 35 2
90 40 1
60 50 20
15 10 2
14 25 4
------------
80 90 15
14 60
 */

import java.util.*;

class Klient{
    int id;
    int loyalty;
    int accounts;

    public Klient(int id, int loyalty, int accounts) {
        this.id = id;
        this.loyalty = loyalty;
        this.accounts = accounts;
    }

    public int vazhnost(){
        return loyalty * 10 + accounts * 20;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_Banka {
    private static void bank(SLL<Klient> normal, SLL<Klient> golden) {
        SLLNode<Klient> curr = golden.getFirst();
        SLLNode<Klient> najNevazhen = golden.getFirst();
        while (curr != null) {
            if (curr.element.vazhnost() <= najNevazhen.element.vazhnost()) {
                najNevazhen = curr;
            }
            curr = curr.succ;
        }

        normal.insertLast(najNevazhen.element);
        golden.delete(najNevazhen);

        SLLNode<Klient> najvazhen = normal.getFirst();
        curr = normal.getFirst();
        while (curr != null) {
            if (curr.element.vazhnost() >= najvazhen.element.vazhnost()) {
                najvazhen = curr;
            }
            curr = curr.succ;
        }

        golden.insertLast(najvazhen.element);
        normal.delete(najvazhen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Klient> normal = new SLL<>();
        SLL<Klient> golden = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int loyalty = sc.nextInt();
            int accounts = sc.nextInt();
            Klient k = new Klient(id, loyalty, accounts);
            normal.insertLast(k);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int loyalty = sc.nextInt();
            int accounts = sc.nextInt();
            Klient k = new Klient(id, loyalty, accounts);
            golden.insertLast(k);
        }

        bank(normal, golden);
        System.out.println(normal);
        System.out.println(golden);
    }
}
