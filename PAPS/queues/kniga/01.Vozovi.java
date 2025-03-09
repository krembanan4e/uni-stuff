package queue;

/*
30
55
100
44
33
0
0
22
5
11
8
60
4
21
90
12
56
108
404
3
0
0
22
0
110
0
6
0
17
0
71

Излез:
3 4 5 6 8 11 12 17 21 22 22 33 44 55 56 60 71 90 100 108 110 404 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KnigaQueue_str125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> vagoni = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int vagon = sc.nextInt();
            if (vagon != 0) {
                vagoni.add(vagon);
            }
        }

        Collections.sort(vagoni);
        for (int i = 0; i < vagoni.size(); i++) {
            System.out.print(vagoni.get(i) + " ");
        }
    }
}
