package listi;
/*

Влез:
3
5 7 9
8
1 1 4 5 6 8 9 4

Излез:
5->7->1->1->9->4->5->6->8->9->4
 */

import java.util.Scanner;

public class KnigaListi_str50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        SLL<Integer> list1 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();
        SLL<Integer> list2 = new SLL<>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }

        SLL<Integer> result = new SLL<>();

        SLLNode<Integer> curr1 = list1.getFirst();
        SLLNode<Integer> curr2 = list2.getFirst();

        while (curr1 != null && curr2 != null){
            result.insertLast(curr1.element);
            curr1 = curr1.succ;
            if (curr1 != null){
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
                if (curr2 != null){
                    result.insertLast(curr2.element);
                    curr2 = curr2.succ;
                }
            }
        }

        if (curr1 != null){
            while (curr1 != null){
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            }
        }

        if (curr2 != null){
            while (curr2 != null){
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
        }

        System.out.println(result);

    }
}
