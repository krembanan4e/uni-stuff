/*
Една компанија сака да воспостави комуникациска мрежа меѓу своите канцеларии во различни градови. 
Компанијата има листа на можни врски помеѓу градовите и нивната цена. Целта е да се минимизира вкупната цена за поврзување на сите градови. 
Да се одреди минималната цена за поврзување на сите градови.

Влез: Во првиот ред е даден бројот на градови N. Потоа во следните N редови се дадени имињата на градовите. 
Во следниот ред е даден бројот на можни врски M, а потоа во следните M редови се дадени градовите што ги поврзува секоја врска и цената за воспоставување на таа врска.
Излез:  Минималната цена да се поврзат сите градови.

Пример:
Влез:
4
London
Paris
Brussels
Amsterdam
5
London Paris 400
London Brussels 200
Paris Brussels 100
Brussels Amsterdam 150
Paris Amsterdam 300

Излез: 450 (Објаснување: ќе се воспостават врските London-Brussels, Brussels-Amsterdam и Brussels-Paris)
*/

package grafovi.tezinskiNenasocen;

import java.util.*;

public class Courses10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        Map<String, Integer> map = new HashMap<>(); //mapiranje grad vo indeks

        for (int i = 0; i < n; i++) {
            String city = sc.nextLine();
            map.put(city, i);
            graph.addVertex(i, city);
        }

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String city1 = sc.next();
            String city2 = sc.next();
            int price = sc.nextInt();
            sc.nextLine();
            
            graph.addEdge(map.get(city1), map.get(city2), price);
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
