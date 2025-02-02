package listi;

/*
Да се напише функција којашто за дадена
еднострано поврзана листа од цели броеви ќе
го врати бројот на парни елементи во истата.

primer:
6
1 2 3 4 5 6
output:
3
 */

import java.util.*;

public class Aud2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        SLLNode<Integer> curr = list.getFirst();
        int counter = 0;

        while (curr != null) {
            if (curr.element % 2 == 0){
                counter++;
            }
            curr = curr.succ;
        }

        System.out.println(counter);
    }
}
