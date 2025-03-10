package listi;

/*
Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број.
Да се трансформира листата така што секој пар од парни вредности во последователни јазли ќе се собере,
а секој пар од непарни вредности во последоватени јазли ќе се одземе (јазелот лево јазелот десно во листата).
Паровите не мора да бидат соседни јазли. Притоа вредноста на новиот јазел треба да биде на позицијата каде бил првиот јазел од парот.
Ако некој број нема свој пар тогаш тој си останува на соодветното место каде бил во листата.
Влез: Во првиот ред од влезот е даден бројот на елементи во листата, а потоа самите елементи на листата, секој во нов ред.
Излез: На излез се печати изменетата листа, секој елемент во посебен ред.

8
1
2
3
4
55
6
71
8
---------
2 6 16 14


9
1
3
5
6
9
11
13
15
19
----------
2 4 6 2 4
 */

import java.util.*;

public class Listi_PosledovatelniParniNeparni {
    private static void transformm(SLL<Integer> list) {
        //so eden pokazuvac stojme na eden element, so drug pokazuvac shetame dur ne najt soodvetno paren/neparen za da soberit/odzemit

        SLLNode<Integer> curr = list.getFirst();
        while (curr != null){
            SLLNode<Integer> tmp = curr.succ;
            while (tmp != null){
                if (curr.element % 2 == 0 && tmp.element % 2 == 0){
                    curr.element = curr.element + tmp.element;
                    list.delete(tmp);
                    break;
                }
                else if (curr.element % 2 != 0 && tmp.element % 2 != 0){
                    curr.element = Math.abs(curr.element - tmp.element);
                    list.delete(tmp);
                    break;
                }
                tmp = tmp.succ;
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

        transformm(list);
        System.out.println(list);
    }
}
