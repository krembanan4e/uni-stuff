package grafovi.listaNetezinskiNasocen;

import java.util.*;

public class Courses_SantaClaus {
    public static int bfs(AdjacencyListGraph<Integer> graph, int startVertex, int counter) { //BFS od klasata sho e
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            //System.out.print(vertex + " ");
            counter++;

            for (Integer neighbor : graph.getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int U = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < U; i++) {
            int R = sc.nextInt();
            int Q = sc.nextInt();
            graph.addEdge(R, Q);
        }

        int L = sc.nextInt();

        int ezera = bfs(graph, L, 0);

        System.out.println(ezera - 1);
    }
}
