/*
Дадени се N возови со време на пристигање и поаѓање. Да се најде минималниот број на платформи потребен за да се сместат тие возови.
Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
Излез: Најмалиот потребен број на платформи за да се сместат сите возови

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
    public static int min_platforms(int[] arrivals,int[] departures, int n){
        int[] intervals = new int[departures[n-1] + 1];
        int min_platforms = 1;
        for (int i = 0; i < n; i++){
            for (int j = arrivals[i]; j <= departures[i]; j++){
                intervals[j]++;
                if (intervals[j] > min_platforms){
                    min_platforms = intervals[j];
                }
            }
        }
        return min_platforms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arrivals = new int[n];
        int [] departures = new int[n];
        for (int i = 0; i < n; i++) {
            arrivals[i] = sc.nextInt();
            departures[i] = sc.nextInt();
        }

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        System.out.println(min_platforms(arrivals, departures, n));
    }
}
