/*
Дадени се градови и патишта кои постојат помеѓу нив. Дел од патиштата се поплавени и не може да се користат, 
што може да доведе до тоа градовите да се поделат на групи што не се меѓусебно поврзани. 
Секој град од една група е поврзан со барем еден друг град од групата преку достапни (непоплавени) патишта, а не е поврзан со градови надвор од групата. 
Да се одреди колку вакви групи ќе има во случај на поплава.

Влез: Во првиот ред е даден бројот на патишта M. Во следните M редови се дадени градовите кои ги поврзува секој пат. 
Потоа е даден бројот k на поплавени патишта, а во следните k редови се дадени поплавените патишта.
Излез:  Бројот на групи на градови кои ќе останат меѓусебно поврзани.

Пример:
Влез:
6  
London Paris  
Paris Brussels  
Brussels Amsterdam  
London Brussels  
Paris Berlin  
Berlin Warsaw  
2  
Paris Berlin  
London Brussels  

Излез: 2 (Објаснување: Ако не може да се користат патиштата Paris-Berlin и London-Brussels, градовите ќе се поделат во две групи: {London, Paris, Brussels, Amsterdam} и {Berlin, Warsaw})
*/

package grafovi;

import java.util.*;

public class Courses04 {
    private static void visitConnectedCities(AdjacencyListGraph<String> graph, String city, Set<String> visited) {
        visited.add(city);

        for (String neighbor : graph.getNeighbors(city)){
            if (!visited.contains(neighbor)){
                visitConnectedCities(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.next(), sc.next());
        }

        int k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            graph.removeEdge(sc.next(), sc.next());
        }

        Set<String> visited = new HashSet<>();
        int numOfGroups = 0;

        // dodaj getAdjacencyList() vo klasata AdjacencyListGraph
        // vo graph.getAdjacencyList().keySet() se site vertices

        for (String city : graph.getAdjacencyList().keySet()){
            if (!visited.contains(city)){
                visitConnectedCities(graph, city, visited);
                numOfGroups++;
            }
        }

        System.out.println(numOfGroups);
    }
}
