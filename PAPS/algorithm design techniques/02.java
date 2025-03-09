package tehnikiNaKreiranjeAlgoritmi;

/*
Дадени се N возови со време на пристигање и поаѓање.
Да се најде минималниот број на платформи потребен за да се сместат тие возови.
Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
Излез: Најмалиот потребен број на платформи за да се сместат сите возови

5
1 2
2 3
3 4
4 5
5 6
---------
2
 */

import java.util.*;

public class Courses02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> pristignivanja = new ArrayList<>();
        ArrayList<Integer> poagjanja = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            pristignivanja.add(p1);
            poagjanja.add(p2);
            max = Math.max(max, p2);
        }

        int []intervali = new int[max+1];
        int platformi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = pristignivanja.get(i); j <= poagjanja.get(i) ; j++) {
                intervali[j]++;
                platformi = Math.max(platformi, intervali[j]);
            }
        }

        System.out.println(platformi);

    }
}
