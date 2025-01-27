package listi;

/*
3
Ana
Bojana
Dejan
3
Andrijana
Biljana
Darko

output:
Ana->Andrijana->Biljana->Bojana->Darko->Dejan
 */

import java.util.Scanner;

public class KnigaListi_str45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        SLL<String> list1 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        SLL<String> list2 = new SLL<>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(sc.nextLine());
        }

        SLLNode<String> curr1 = list1.getFirst();
        SLLNode<String> curr2 = list2.getFirst();

        SLL<String> result = new SLL<>();

        while (curr1 != null && curr2 != null) { //ko ke dojt edniot do null prekinvit
            if (curr1.element.compareTo(curr2.element) < 0){ // 1 < 2
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            }
            else{
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
        }

        if (curr1 != null) {
            while (curr1 != null){
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            }
        }

        if (curr2 != null) {
            while (curr2 != null){
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
        }

        System.out.println(result);
    }
}
