package listi;

/*
Подели листа Problem 1 (0/0)
За дадена единечно поврзана листа и цел број X, променете ја листата така што
сите јазли што имаат вредност помала од X, ќе се преместат пред јазлите кои имаат вредност поголема или еднаква од Х.
Треба да се зачува оригиналниот релативен редослед на јазлите на двата дела од листата (помали и поголеми од х)
Во првиот ред од влезот е даден бројот N (N<=100) на јазли во листата,
во вториот ред се дадени броевите (секогаш цели броеви) од кои е составена листата, потоа во третиот ред е даден бројот Х.
Пример:
Влез:
x = 3
1->4->3->2->5->2
Излез: 1->2->2->4->3->5
Забелешка: При реализација на задачата треба да се користи листа, не е дозволено менување на вредностите на јазлите.
Промената на местата на јазлите да се изврши исклучиво преку промена на врските меѓу јазлите.

6
1 4 3 2 5 2
3
------------
1->2->2->4->3->5
 */

import java.util.*;

public class Listi_PodeliLista {
    private static void podeli_lista(SLL<Integer> list, int x) {
        SLLNode<Integer> curr = list.getFirst();
        for (int i=0; i<list.size(); i++){
            if (curr.element >= x){
                list.insertLast(curr.element);
                list.delete(curr);
            }
            curr = curr.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int x = sc.nextInt();

        podeli_lista(list, x);
        System.out.println(list);
    }
}
