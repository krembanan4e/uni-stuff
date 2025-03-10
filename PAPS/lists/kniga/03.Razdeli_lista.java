package listi;

import java.util.Scanner;

public class KnigaListi_str42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        SLL<Integer> parni = new SLL<>();
        SLL<Integer> neparni = new SLL<>();

        SLLNode<Integer> currP = list.getFirst();
        SLLNode<Integer> currN = list.getFirst();
        SLLNode<Integer> parniPrethodnik = null;
        SLLNode<Integer> neparniPrethodnik = null;

        while (currP != null){
            if (currP.element % 2 == 0){
                parniPrethodnik = currP;

            }
            else{
                if (parniPrethodnik != null && parniPrethodnik.element % 2 == 0){
                    parni.insertLast(parniPrethodnik.element);
                    parniPrethodnik = currP;
                }
            }
            currP = currP.succ;
        }

        while (currN != null){
            if (currN.element % 2 != 0){
                neparniPrethodnik = currN;

            }
            else{
                if (neparniPrethodnik != null && neparniPrethodnik.element % 2 != 0){
                    neparni.insertLast(neparniPrethodnik.element);
                    neparniPrethodnik = currN;
                }
            }
            currN = currN.succ;
        }

        //za posledniot element sho ke ostanit, zsh curr ke e null
        if (parniPrethodnik != null && neparniPrethodnik != null){
            if (parniPrethodnik.element % 2 == 0){
                parni.insertLast(parniPrethodnik.element);
            }
            else{
                neparni.insertLast(neparniPrethodnik.element);
            }
        }


        System.out.println(parni);
        System.out.println(neparni);
    }
}
