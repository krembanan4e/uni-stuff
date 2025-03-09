/*
Дадени се рутери означени со броеви од 0 до N-1 кои се поврзани во мрежа. Ако некој рутер R падне, мрежата може да се подели на групи на рутери што не се меѓусебно поврзани. 
Секој рутер од една група е поврзан со барем еден друг рутер од групата, а не е поврзан со рутери надвор од групата. 
Да се одреди колку вакви групи ќе настанат доколку рутерот R престане да работи.

Влез: Во првиот ред е даден бројот на рутери N. Во следниот ред е даден бројот на врски помеѓу рутерите M, а во следните M редови се дадени рутерите кои ги поврзува секоја врска. 
Во последниот ред е даден рутерот R што престанал да работи.
Излез:  Бројот на групи на рутери.

Пример:
Влез:
5  
4
0 1
1 2
2 3
2 4  
1 

Излез: 2 (Објаснување: Ако падне рутерот 1 ќе се појават две групи: 0 и 2,3,4)
*/

package grafovi;

import java.util.*;

public class Courses03 {
    private static void visitConnectedRouters(AdjacencyListGraph<Integer> graph, int router, Set<Integer> visited) {
        visited.add(router);

        for (int neighbor : graph.getNeighbors(router)){
            if (!visited.contains(neighbor)){
                visitConnectedRouters(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //broj na ruteri
        int m = sc.nextInt(); //broj na vrski

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        int k = sc.nextInt();
        graph.removeVertex(k);

        Set<Integer> visited = new HashSet<>();
        int numOfGroups = 0;

        // dodaj getAdjacencyList() vo klasata AdjacencyListGraph
        // vo graph.getAdjacencyList().keySet() se site vertices

        for (int router : graph.getAdjacencyList().keySet()){
            if (!visited.contains(router)){
                visitConnectedRouters(graph, router, visited);
                numOfGroups++;
            }
        }

        System.out.println(numOfGroups);
    }
}

