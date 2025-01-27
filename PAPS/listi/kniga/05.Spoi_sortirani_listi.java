package listi;

import java.util.Scanner;

public class KnigaListi_str46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        SLL<Integer> pom = new SLL<>();
        for (int i = 0; i < n; i++) {
            Integer br = sc.nextInt();
            list.insertLast(br);
            pom.insertLast(br);
        }

        //System.out.println(list);
        pom.mirror();
        //System.out.println(pom);

        int k = n/2;
        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> curr1 = list.getFirst();
        SLLNode<Integer> curr2 = pom.getFirst();

        for (int i = 0; i < k; i++) {
            result.insertLast(curr1.element);
            result.insertLast(curr2.element);
            curr1 = curr1.succ;
            curr2 = curr2.succ;
        }

        if (n % 2 != 0){
            result.insertLast(curr1.element);
        }
        System.out.println(result);
    }
}
