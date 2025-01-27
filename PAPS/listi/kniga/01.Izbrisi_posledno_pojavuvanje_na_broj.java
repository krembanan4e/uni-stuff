package listi;

import java.util.Scanner;

public class KnigaListi_str40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int m = sc.nextInt();

        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> currLast = null;

        while (curr != null){
            if (curr.element == m){
                currLast = curr;
            }
            curr = curr.succ;
        }

        list.delete(currLast);
        System.out.println(list);
    }
}
