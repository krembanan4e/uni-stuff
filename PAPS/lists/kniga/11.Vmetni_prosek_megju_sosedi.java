package listi;

import java.util.Scanner;

public class KnigaListi_str63 {
    public static int prosek(int a, int b){
        double prosek =  Math.ceil((double) (a+b)/2);
        return (int) prosek;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLLNode<Integer> curr = list.getFirst();
        DLLNode<Integer> currPred = null;

        while(curr != null){
            if (currPred != null){
                int prosek = prosek(currPred.element, curr.element);
                list.insertAfter(prosek, currPred);
            }
            currPred = curr;
            curr = curr.succ;
        }

        System.out.println(list);
    }
}
