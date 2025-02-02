package listi;

/*
Податоците за атлетичарите кои учествувале на трките на 100m се чуваат во две еднострано поврзани листи.
Во првата листа се чуваат податоците за атлетичарите кои победиле на трките во изминатите години (не вклучувајќи ја тековната година),
а во втората листа се чуваат податоците за атлетичарите кои се натпреварувале во тековната година.
И кај двете листи, во секој од јазлите се чуваат број за идентификација (id) и време (во секунди како децимален број) за кое атлетичарот ја завршил трката.
Потребно е да се изберат атлетичари, за тековната година, кои ќе продолжат на следната Олимпијада.
За таа цел, потребно е од листата на атлетичари за тековната година да се отстранат (избришат) сите атлетичари кои имаат поголемо/ полошо време
од максималното (најлошото) време кое го остварил некој од победниците во изминатите години.
Влез:
Во првиот ред е даден бројот на победници од изминатите години.
Во вториот ред е даден бројот на атлетичари од тековната година.
Во следните редови се дадени паровите податоци за секој атлетичар, одделени со празно место, во формат id време.
Излез:
Во еден ред і на сите атлетичари кои ќе продолжат на Олимпијадата.
Забелешка: Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Race.java, со целосно имплементиран input и output.
Потребно е да се менува само во рамки на vold competition(SLL<Athlete> prevWinners, SLL<Athlete> currYearRunners) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазел!

Влез:
2
3
884 13.30
824 17.36
665 12.40
529 29.59
628 25.21

Излез:
665
 */

import java.util.*;

class Atleticar{
    int id;
    float vreme;

    public Atleticar(int id, float vreme) {
        this.id = id;
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_Atleticari {
    private static void competition(SLL<Atleticar> prevWinners, SLL<Atleticar> currYearRunners) {
        SLLNode<Atleticar> curr = prevWinners.getFirst();
        SLLNode<Atleticar> max = prevWinners.getFirst();
        while (curr != null) {
            if (curr.element.vreme >= max.element.vreme) {
                max = curr;
            }
            curr = curr.succ;
        }

        curr = currYearRunners.getFirst();
        while (curr != null) {
            if (curr.element.vreme > max.element.vreme) {
                currYearRunners.delete(curr);
            }
            curr = curr.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Atleticar> prevWinners = new SLL<>();
        SLL<Atleticar> currYearRunners = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            float vreme = sc.nextFloat();
            Atleticar a = new Atleticar(id, vreme);
            prevWinners.insertLast(a);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            float vreme = sc.nextFloat();
            Atleticar a = new Atleticar(id, vreme);
            currYearRunners.insertLast(a);
        }

        competition(prevWinners, currYearRunners);
        System.out.println(currYearRunners);
    }
}
