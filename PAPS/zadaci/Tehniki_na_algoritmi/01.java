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
-------------
9977331
*/

import java.util.*;

public class Main{

    public static void biggest_number(ArrayList<Integer> digits, int n){
        String number = new String("");
        digits.sort(Integer::compareTo);
        for (int i = n-1; i >= 0; i--){
            number += digits.get(i);
        }
        System.out.println(number);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            digits.add(sc.nextInt());
        }

        biggest_number(digits, n);
    }
}
