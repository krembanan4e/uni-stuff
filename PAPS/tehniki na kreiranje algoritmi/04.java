package tehnikiNaKreiranjeAlgoritmi;

/*
Дадени се N состаноци со време на почеток и крај. Да се најде минималниот број на сали за состаноци потребен за да се одржат сите состаноци.
Влез: Првиот број од влезот е бројот на состаноци N, а потоа во следниот ред минутата на почнување и минутата на завршување на состанокот.
Излез: Најмалиот потребен број на соби за состаноци за да можат да се одржат сите состаноци

5
1 2
1 2
5 10
11 14
15 20
---------
2
 */

import java.util.*;

public class Courses04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> beginnings = new ArrayList<>();
        ArrayList<Integer> endings = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int e = sc.nextInt();
            beginnings.add(b);
            endings.add(e);
            max = Math.max(max, e);
        }

        int maxRooms = 0;
        int []intervals = new int[max + 1];

        for (int i = 0; i < n; i++) {
            for (int j = beginnings.get(i); j <= endings.get(i); j++){
                intervals[j]++;
                maxRooms = Math.max(maxRooms, intervals[j]);
            }
        }

        System.out.println(maxRooms);
    }
}
