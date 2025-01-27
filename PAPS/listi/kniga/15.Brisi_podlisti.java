package listi;

/*
22
1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
3
4 5 6
 */

import java.util.Scanner;

public class KnigaListi_str70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();
        DLL<Integer> list2 = new DLL<>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }

        DLLNode<Integer> curr = list.getFirst();
        DLLNode<Integer> curr2 = list2.getFirst();

        while (curr != null) {
            if (curr.element == curr2.element){
                while (curr2 != null) {
                    if (curr.element != curr2.element){
                        break;
                    }
                    else{
                        curr = curr.succ;
                        curr2 = curr2.succ;
                    }
                }
                if (curr2 == null){
                    int temp = m;
                    while (temp > 0){
                        curr = curr.pred;
                        list.delete(curr);
                        temp--;
                    }
                }
            }
            curr2 = list2.getFirst();
            curr = curr.succ;
        }

        System.out.println(list);
    }
}
