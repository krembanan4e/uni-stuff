package listi;

import java.util.Scanner;

public class KnigaListi_str61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLL<Integer> parni = new DLL<>();
        DLL<Integer> neparni = new DLL<>();

        DLLNode<Integer> currLevo = list.getFirst();
        DLLNode<Integer> currDesno = list.getLast();

        for (int i = 0; i < n/2; i++) {
            if (currLevo.element % 2 == 0){
                parni.insertLast(currLevo.element);
                currLevo = currLevo.succ;
            }
            else {
                neparni.insertLast(currLevo.element);
                currLevo = currLevo.succ;
            }

            if (currDesno.element % 2 == 0){
                parni.insertLast(currDesno.element);
                currDesno = currDesno.pred;
            }
            else{
                neparni.insertLast(currDesno.element);
                currDesno = currDesno.pred;
            }
        }

        if (currLevo == currDesno){
            if (currLevo.element % 2 == 0){
                parni.insertLast(currLevo.element);
            }
            else {
                neparni.insertLast(currLevo.element);
            }
        }


        System.out.println(parni);
        System.out.println(neparni);
    }
}
