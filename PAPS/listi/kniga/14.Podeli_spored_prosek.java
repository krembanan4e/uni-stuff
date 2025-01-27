package listi;

import java.util.Scanner;

public class KnigaListi_str69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLLNode<Integer> curr = list.getFirst();
        float sum = 0;

        while (curr != null){
            sum += curr.element;
            curr = curr.succ;
        }

        float prosek = sum / n;

        curr = list.getLast();
        DLL<Integer> pomaliEdnakviOdProsekot = new DLL<>();
        DLL<Integer> pogolemiOdProsekot = new DLL<>();

        while(curr != null){
            if (curr.element <= prosek){
                pomaliEdnakviOdProsekot.insertLast(curr.element);
            }
            else {
                pogolemiOdProsekot.insertLast(curr.element);
            }
            curr = curr.pred;
        }

        System.out.println(pomaliEdnakviOdProsekot);
        System.out.println(pogolemiOdProsekot);

    }
}
