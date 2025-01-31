/*
Еден новооснован град треба да ги поврзе населбите со патишта. 
Градоначалникот сака да осигура дека секоја населба ќе биде достапна од која било друга населба, но притоа трошоците за изградба на патиштата да бидат минимални. 
Дадена е листа на можни патишта и цената за изградба на секој пат. Да се одреди минималната цена да се поврзат сите населби.

Влез: Во првиот ред е даден бројот на населби N. Потоа во следните N редови се дадени имињата на населбите. 
Во следниот ред е даден бројот на можни патишта M, а потоа во следните M редови се дадени населбите што ги поврзува секој пат и цената за изградба на тој пат.
Излез:  Минималната цена да се поврзат сите патишта.

Пример:
Влез:
4
Downtown
Uptown
Riverview
Lakeside
5
Downtown Uptown 400
Downtown Riverview 200
Uptown Riverview 100
Riverview Lakeside 500
Uptown Lakeside 300

Излез: 600 (Објаснување: ќе се изградат патиштата Downtown-Riverview, Uptown-Riverview и Uptown-Lakeside)
*/

package grafovi.tezinskiNenasocen;

import java.util.*;

public class Courses11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        Map<String, Integer> map = new HashMap<>(); //mapiranje naselba vo indeks

        for (int i = 0; i < n; i++) {
            String naselba = sc.nextLine();
            map.put(naselba, i);
            graph.addVertex(i, naselba);
        }

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String naselba1 = sc.next();
            String naselba2 = sc.next();
            int cena = sc.nextInt();
            sc.nextLine();

            graph.addEdge(map.get(naselba1), map.get(naselba2), cena);
        }

        int sum = 0;
        List<Edge> mst = graph.kruskal();
        ListIterator<Edge> iterator = mst.listIterator();

        while (iterator.hasNext()) {
            Edge e = iterator.next();
            sum += e.getWeight();
        }

        System.out.println(sum);
    }
}
