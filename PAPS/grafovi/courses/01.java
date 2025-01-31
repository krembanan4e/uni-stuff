/*
Дадени се објекти кои се поврзани со улици и се групирани во градови. 
За група на објекти се смета дека припаѓаат на еден град ако секој објект е поврзан со барем еден друг објект од тој град, а не е поврзан со ниту еден објект од некој друг град. 
Да се одреди во колку градови се групирани дадените објекти.

Влез: Во првиот ред е даден бројот на објекти N. Потоа во следните N редови се дадени имињата на објектите. 
Во следниот ред е даден бројот на улици M, а во следните M редови се дадени објектите кои ги поврзува секоја улица.
Излез:  Бројот на градови во кои се групирани дадените објекти.

Пример:
Влез:
5  
School1  
ApartmentBuilding1  
Park1  
Supermarket1  
Hospital1  
2  
School1 ApartmentBuilding1  
Park1 Supermarket1  

Излез: 3 (Објаснување: School1 и ApartmentBuilding1 се во еден град, Park1 и Supermarket1 во друг и Hospital1 во трет)
*/

package grafovi;

import java.util.*;

public class Courses01 { 

    public static void visitConnectedObjects(AdjacencyListGraph<String> graph, String object, Set<String> visited){
        visited.add(object);

        for (String neighbor : graph.getNeighbors(object)){
            if (!visited.contains(neighbor)){
                visitConnectedObjects(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            graph.addVertex(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.next(), sc.next());
        }

        Set<String> visited = new HashSet<>();
        int numOfCities = 0;

        // dodaj getAdjacencyList() vo klasata AdjacencyListGraph
        // vo graph.getAdjacencyList().keySet() se site vertices

        for (String object : graph.getAdjacencyList().keySet()){
            if (!visited.contains(object)){
                visitConnectedObjects(graph, object, visited);
                numOfCities++;
            }
        }

        System.out.println(numOfCities);
    }
}

