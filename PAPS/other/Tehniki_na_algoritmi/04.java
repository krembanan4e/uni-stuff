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
--------
2



5
1 2
2 3
3 4
4 5
5 6
-------
2

*/

import java.util.*;

public class Main{
    public static int max_offices (int []beginnings, int []endings, int n){
        int []intervals = new int[endings[n-1] + 1];
        int min_offices = 1;
        for (int i = 0; i < n; i++){
            for (int j = beginnings[i]; j <= endings[i]; j++){
                intervals[j]++;
                if (intervals[j] > min_offices){
                    min_offices = intervals[j];
                }
            }
        }
        
        return min_offices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []beginnings = new int[n];
        int []endings = new int[n];
        for (int i = 0; i < n; i++) {
            beginnings[i] = sc.nextInt();
            endings[i] = sc.nextInt();
        }
        
        Arrays.sort(beginnings);
        Arrays.sort(endings);

        System.out.println(max_offices(beginnings, endings, n));
    }
}

