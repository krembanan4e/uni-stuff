package listi;

/*
Дадени се две сортирани двојно поврзани листи, при што, првата листа е сортирана во растечки редослед, а втората е сортирана во опаѓачки редослед.
Да се конструира нова двојно поврзана листа којашто ќе ги содржи сите елементи од двете листи и тоа во опаѓачки редослед.
При решавањето на задачата не смее да се користи сортирање на листи.
Влез: Во првиот ред дадени се два броја: Ми N, коишто ги означуваат должините на листите, соодветно.
Во вториот ред се дадени М броеви - елементите на првата листа. Во третиот ред дадени се N броеви елементите на втората листа.
Излез: Броевите од финалната листа. Во првиот ред се печатат по редослед од прв до последен, а во вториот обратно, од последен до прв.
Забелешка: Даден е основниот код од задачата со имплементиран влез и излез како и структурата која треба да се користи.
Дадена е и main функцијата, во која на точно означеното место ќе треба да се имплементират бараните услови.
Вашиот код треба да биде напишан само таму, без измени во останатиот дел од кодот.
For example:
Test Input
5 5
1 3 4 6 7
9 8 5 2 1
Result
9<->8<->7<->6<->5<->4<->3<->2<->1<->1<->
1<->1<->2<->3<->4<->5<->6<->7<->8<->9<->
 */

import java.util.*;

public class Listi_IspitnaDLL {
    private static void podredi_opagjacki(DLL<Integer> result, DLL<Integer> list2) {

        DLLNode<Integer> curr = list2.getFirst();
        for (int i=0; i<list2.getSize(); i++){
            result.insertLast(curr.element);
            curr = curr.succ;
        }

        int size = result.getSize();
        for (int i=0; i<result.getSize(); i++){
            DLLNode<Integer> max = result.getFirst();
            curr = result.getFirst();
            for (int j=0; j<size; j++){
                if (curr.element >= max.element){
                    max = curr;
                }
                curr = curr.succ;
            }
            result.insertLast(max.element);
            result.delete(max);
            size--;
        }

        curr = result.getFirst();
        while(curr != null){
            System.out.print(curr.element + "<->");
            curr = curr.succ;
        }
        System.out.println();
      
        curr = result.getLast();
        while(curr != null){
            System.out.print(curr.element + "<->");
            curr = curr.pred;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DLL<Integer> list1 = new DLL<>();
        DLL<Integer> list2 = new DLL<>();

        for(int i = 0; i < n; i++) {
            list1.insertLast(sc.nextInt());
        }
        for(int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }

        podredi_opagjacki(list1, list2);
    }
}
