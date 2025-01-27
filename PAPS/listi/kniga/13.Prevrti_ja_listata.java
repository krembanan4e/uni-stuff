package listi;

import java.util.Scanner;

public class KnigaListi_str66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLL<Integer> result = new DLL<>();

        DLLNode<Integer> curr = list.getLast();

        while (curr != null){
            while (curr.element % 2 != 0){
                curr = curr.pred;
                if (curr == null){
                    break;
                }
            }
            if (curr != null){
                result.insertLast(curr.element);
                curr = curr.pred;
            }
            if (curr == null){
                break;
            }
        }

        curr = list.getLast();
        while (curr != null){
            while (curr.element % 2 == 0){
                curr = curr.pred;
                if (curr == null){
                    break;
                }
            }
            if (curr != null){
                result.insertLast(curr.element);
                curr = curr.pred;
            }
            if (curr == null){
                break;
            }
        }

        System.out.println(result);
    }
}
