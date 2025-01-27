package listi;

import java.util.Scanner;

public class CoursesListi12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        System.out.print(list);
        int k = sc.nextInt();
        DLLNode<Integer> curr = list.getFirst();
        for (int i = 0; i < k; i++) {
            list.insertLast(curr.element);
            list.delete(curr);
            curr = curr.succ;
        }
        System.out.println(list);
    }
}
