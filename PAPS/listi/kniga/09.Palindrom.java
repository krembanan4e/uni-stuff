package listi;

import java.util.Scanner;

public class KnigaListi_str59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        boolean flag = true;

        for (int i = 0; i < n/2; i++) {
            if (first.element != last.element) {
                flag = false;
                break;
            }
            first = first.succ;
            last = last.pred;
        }

        if (flag){
            System.out.println(1);
        }
        else{
            System.out.println(-1);
        }
    }
}
