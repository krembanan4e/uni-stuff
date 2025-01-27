package listi;

import java.util.Scanner;

public class CoursesListi7_DLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.print(list);

        int k = sc.nextInt();
        DLLNode<Integer> currLast = list.getLast();
        for (int i = 0; i < k; i++) {
            list.insertFirst(currLast.element);
            list.delete(currLast);
            currLast = currLast.pred;
        }

        System.out.println(list);
    }
}
