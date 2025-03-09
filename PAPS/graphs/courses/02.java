/*
Дадени се луѓе, дел од кои меѓусебно се познаваат. 
Треба да се организираат дочеци на Нова Година, така што секој човек во едно друштво што слави заедно се познава со барем еден друг човек од тоа друшвто, 
а не се познава со никој надвор од тоа друштво. Да се одреди колку дочеци на Нова Година ќе организираат дадените луѓе.

Влез: Во првиот ред е даден бројот на луѓе N. Потоа во следните N редови се дадени имињата на луѓето. 
Во следниот ред е даден бројот на познанства M, а во следните M редови се дадени луѓето кои се познаваат.
Излез:  Бројот на дочеци на Нова Година.

Пример:
Влез:
6
Alice
Bob
Charlie
Diana
Eve
Frank
3
Alice Bob
Charlie Diana
Eve Frank 

Излез: 3 (Објаснување: Alice и Bob претставуваат една група, Charlie и Diana се втора група, а Eve и Frank во трета)
*/

package grafovi;

import java.util.*;

public class Courses02 {
    private static void visitConnectedPeople(AdjacencyListGraph<String> graph, String person, Set<String> visited) {
        visited.add(person);

        for (String neighbor : graph.getNeighbors(person)){
            if (!visited.contains(neighbor)){
                visitConnectedPeople(graph, neighbor, visited);
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
        int numOfGatherings = 0;

        // dodaj getAdjacencyList() vo klasata AdjacencyListGraph
        // vo graph.getAdjacencyList().keySet() se site vertices

        for (String person : graph.getAdjacencyList().keySet()){
            if (!visited.contains(person)){
                visitConnectedPeople(graph, person, visited);
                numOfGatherings++;
            }
        }

        System.out.println(numOfGatherings);
    }
}

