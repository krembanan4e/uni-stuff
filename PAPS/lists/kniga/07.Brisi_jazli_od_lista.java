package listi;
/*
9
4 6 8 3 1 3 5 7 2
 */

import java.util.Scanner;

public class KnigaListi_str49_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        SLLNode<Integer> curr = list.getFirst();

        SLL<Integer> result = new SLL<>();
        int counter = 1;
        int temp = 0;

        while (curr != null && curr.succ != null){

            while (temp < counter){
                temp++;
                result.insertLast(curr.element);
                curr = curr.succ;
            }

            temp = 0;
            counter++;
            curr = curr.succ;
        }

        System.out.println(result);
    }
}
