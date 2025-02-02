package listi;

/*
За да се изведе едно предвидување со тарот карти, гатачка користи еден шпил на карти,
од кој зема точно 12 карти и ги дели на две половини, кои се чуваат во две еднострано поврзани листи.
Така, во првата листа се чуваат податоците за картите од првиот дел, а додека пак во втората се чуваат податоците за картите од вториот дел.
За секоја карта се важни податоците за: Id на картата (int id) и ранг на картата (int rank).
Пред да започне со предвидувањето со картите, гатачката прави мешање на картите кое се изведува во 3 чекори, секогаш во ово редослед:
1. Од првиот дел ја зема првата карта и ја става како последна карта во вториот дел.
2. Потоа, од вториот дел ја зема првата карта и ја става како последна карта во првиот дел.
3. За крај, Ја зема претпоследната карта од првиот дел и ја става на средина на вториот дел.
Ваша задача е да симулирате вакво мешање на тарот картите, во точно кажаниот редослед.
Влез: Во секој ред се дадени податоци за една тарот карта, одделени со празно место, во формат id rank.
Притоа, прво се дадени картите од првиот дел, по што следуваат податоците за картите од вториот дел.
Излез: Во првиот ред id на сите карти од првиот дел. Во вториот ред id на сите карти од вториот дел.
Внимавајте:
1. Секое едно земање на карта од еден и префрлање на истата во друг дел, значи бришење на картата од едната листа и вметнување во другата листа, на одреденото место.
2. Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Tarot.Java, со целосно имплементиран input
и output. Потребно е да се менува само во рамки на vold tarotCards(SLL <Card> firstPart, SLL <Card» secondpart) функцијата.
3. Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу Јазлите.
4. Не смее да менувате во main функцијата

For example:
33 51
18 52
40 50
6 24
4 18
88 13
45 34
98 3
87 16
32 19
28 22
82 5
---------------
18 40 6 4 45
98 87 32 88 28 82 33
 */

import java.util.*;

class Karta{
    int id;
    int rank;

    public Karta(int id, int rank) {
        this.id = id;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_TarotKarti {
    private static void tarotCards(SLL<Karta> firstPart, SLL<Karta> secondPart) {
        SLLNode<Karta> curr = firstPart.getFirst();
        secondPart.insertLast(curr.element);
        firstPart.delete(curr);

        curr = secondPart.getFirst();
        firstPart.insertLast(curr.element);
        secondPart.delete(curr);

        curr = firstPart.getFirst();
        while (curr.succ.succ != null){
            curr = curr.succ;
        }

        SLLNode<Karta> curr2 = secondPart.getFirst();
        for (int i=0; i<3; i++){
            curr2 = curr2.succ;
        }

        secondPart.insertBefore(curr.element, curr2);
        firstPart.delete(curr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Karta> firstPart = new SLL<>();
        SLL<Karta> secondPart = new SLL<>();

        for (int i = 0; i < 6; i++) {
            int id = sc.nextInt();
            int rank = sc.nextInt();
            Karta k = new Karta(id, rank);
            firstPart.insertLast(k);
        }

        for (int i = 0; i < 6; i++) {
            int id = sc.nextInt();
            int rank = sc.nextInt();
            Karta k = new Karta(id, rank);
            secondPart.insertLast(k);
        }

        tarotCards(firstPart, secondPart);
        System.out.println(firstPart);
        System.out.println(secondPart);
    }
}
