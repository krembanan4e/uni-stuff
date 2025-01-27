package listi;

import java.util.Scanner;

public class KnigaListi_str41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        SLLNode<Integer> curr = list.getFirst();

        while (curr != null && curr.succ != null) {
            Integer temp = curr.element;
            curr.element = curr.succ.element;
            curr.succ.element = temp;

            curr = curr.succ.succ;
        }

        System.out.println(list);
    }
}
