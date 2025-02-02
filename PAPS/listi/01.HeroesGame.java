package listi;

/*
Во една игра со карти се користат специјални карти, т.ш. за секоја карта се важни податоците за: id на херојот на картата (int id), моќта на херојот (int power), 
како и бројот на напади кои тој може да ги направи (int numAttacks).
Така, за секоја една карта може да се пресмета колку таа карта е значајна, според тоа колку штета може да нанесе херојот на картата, 
односно како производ на моќта на херојот и бројот на напади кои може да ги направи.
Двајца пријатели решаваат да ја играат оваа игра, т.ш. во две еднострано поврзани листи се чуваат податоците за картите кои им се доделени. 
Во првата листа се чуваат картите доделени на првиот пријател, а додека пак во втората се чуваат податоците за картите доделени на вториот пријател.
И двајцата играчи на почеток имаат точно 6 карти.
На самиот почетокот на играта, правилата налагаат првиот играч (првиот пријател) да ја предаде својата најдобра карта на другиот играч, 
т.ш. кога вториот играч ќе ја земе картата истата треба да ја постави во средина на своите карти. 
Тоа значи дека потребно е од листата која ги чува картите на првиот пријател да се отстрани (избрише) најдобрата карта 
и таа карта да се додаде на средина на листата каде што се чуваат картите на вториот пријател.
Влез: Во секој еден ред се дадени податоци за една карта, одделени со празно место, во формат id power numAttacks. 
Притоа, прво се дадени картите на првиот пријател, по што следуваат податоците за картите на вториот пријател.
Излез: Во првиот ред id на сите карти на првиот пријател. Во вториот ред id на сите карти на вториот пријател.
Внимавајте:
1. Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Heroes.java, со целосно имплементиран input и output. 
Потребно е да се менува само во рамки на void startHeroesGame(SLL<Card> firstFriendCards, SLL<Card> secondFriendCards) функцијата.
2. Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол. Промените (бришење/додавање елемент) не треба 
Да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.
3. Не смее да менувате во main функцијата !

Input
84 44 87
79 9 67
26 2 81
57 91 59
45 92 8
55 97 80
10 99 4
13 84 28
64 6 90
93 57 23
14 49 36
50 65 12

Result
84 79 26 57 45
10 13 64 55 93 14 50
 */

import java.util.*;

class Card{
    int id;
    int power;
    int numAttacks;

    public Card(int id, int power, int numAttacks) {
        this.id = id;
        this.power = power;
        this.numAttacks = numAttacks;
    }

    public int znacajnost(){
        return power * numAttacks;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_HeroesGame {
    private static void startHeroesGame(SLL<Card> player1, SLL<Card> player2) {
        SLLNode<Card> curr = player1.getFirst();
        SLLNode<Card> max = player1.getFirst();
        while(curr != null){
            if (curr.element.znacajnost() > max.element.znacajnost()){
                max = curr;
            }
            curr = curr.succ;
        }

        SLLNode<Card> curr2 = player2.getFirst();
        for (int i=0; i<3; i++){
            curr2 = curr2.succ;
        }
        player2.insertBefore(max.element, curr2);

        player1.delete(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SLL<Card> player1 = new SLL<>();
        SLL<Card> player2 = new SLL<>();

        for (int i=0; i<6; i++){
            int id = sc.nextInt();
            int power = sc.nextInt();
            int numAttacks = sc.nextInt();
            Card card = new Card(id, power, numAttacks);

            player1.insertLast(card);
        }

        for (int i=0; i<6; i++){
            int id = sc.nextInt();
            int power = sc.nextInt();
            int numAttacks = sc.nextInt();
            Card card = new Card(id, power, numAttacks);

            player2.insertLast(card);
        }

        startHeroesGame(player1, player2);
        System.out.println(player1);
        System.out.println(player2);
    }
}
