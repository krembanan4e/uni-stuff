package tehnikiNaKreiranjeAlgoritmi;

/*
Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
Излез: Најголемиот број кој може да се состави од тие цифри

5
1 2 3 4 5
-------------
54321


7
9 7 3 7 9 3 1
--------------
9977331
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Courses01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i));
        }
    }
}
