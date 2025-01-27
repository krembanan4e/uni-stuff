package listi;

import java.util.Scanner;

public class CoursesListi7_SLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.print(list);

        int k = sc.nextInt();

        SLL<Integer> pomoshna = new SLL<>();
        SLLNode<Integer> curr = list.getFirst();

        for (int i = 0; i < n-k; i++) {
            curr = curr.succ;
        }
        for (int i = 0; i < k; i++) {
            pomoshna.insertLast(curr.element);
            curr = curr.succ;
        }

        curr = list.getFirst();
        for (int i = 0; i < n-k; i++) {
            pomoshna.insertLast(curr.element);
            curr = curr.succ;
        }
        System.out.println(pomoshna);

    }
}
