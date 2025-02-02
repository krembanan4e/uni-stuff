package listi;

/*
Нека се дадени две низи, кои треба да
бидат со иста големина. Да се напише
функција која ќе прави промени во двете
низи така што доколку на дадена позиција
тие имаат еднакви елементи, истите треба
да се избришат и во двете низи.

primer:
6
1 2 3 4 5 6
7 2 8 9 5 0
output:
1 3 4 6
7 8 9 0
 */

import java.util.*;

public class Aud1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list2.add(sc.nextInt());
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))){
                list1.remove(list1.get(i));
                list2.remove(list2.get(i));
                i--;
            }
        }

        System.out.println(list1);
        System.out.println(list2);

    }
}
