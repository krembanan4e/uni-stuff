package listi;

import java.util.Scanner;

public class CoursesListi13 {
    public static float prosekPred (DLL<Integer> list, DLLNode<Integer> curr){
        float suma = 0;
        float counter = 0;

        while (curr != null){
            counter++;
            suma += curr.element;
            curr = curr.pred;
        }
        return suma / counter;
    }
    public static float prosekPosle (DLL<Integer> list, DLLNode<Integer> curr){
        float suma = 0;
        float counter = 0;

        while (curr != null){
            counter++;
            suma += curr.element;
            curr = curr.succ;
        }
        return suma / counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int result = 0;
        DLLNode<Integer> curr = list.getFirst().succ; //vtoriot od pocetok
        while (curr.succ != null){ //do pretposledniot
            float prPred = prosekPred(list, curr.pred);
            float prPosle = prosekPosle(list, curr.succ);
            if (prPred > prPosle){
                result++;
            }
            curr = curr.succ;
        }

        System.out.println(result);
    }
}
