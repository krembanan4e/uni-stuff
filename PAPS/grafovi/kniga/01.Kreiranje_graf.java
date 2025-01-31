package grafovi.netezinskiNenasocen;

/*
Пример:
Влез:
5
CREATE 4
ADDEDGE 0 3
PRINTMATRIX
PRINTNODE 2
ADJACENT 0 2
DELETEEDGE 3 0

Излез:
0 0 0 1
0 0 0 0
0 0 0 0
1 0 0 0
C
0
 */

/*

ova da se dodajt vo klasata AdjacencyMatrixGraph

    public void printMatrix(){
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
*/

import java.util.*;

public class KnigaGrafovi_str359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String []line = sc.nextLine().split(" ");
        int num = Integer.parseInt(line[1]);

        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(num);
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String command = parts[0];
            if (command.equals("ADDEDGE")){
                int v1 = Integer.parseInt(parts[1]);
                int v2 = Integer.parseInt(parts[2]);
                graph.addEdge(v1, v2);
            }
            else if (command.equals("DELETEEDGE")){
                int v1 = Integer.parseInt(parts[1]);
                int v2 = Integer.parseInt(parts[2]);
                graph.removeEdge(v1, v2);
            }
            else if (command.equals("ADJACENT")){
                int v1 = Integer.parseInt(parts[1]);
                int v2 = Integer.parseInt(parts[2]);
                List<Integer> list = graph.getNeighbors(v1);
                if (list.contains(v2)){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if (command.equals("PRINTMATRIX")){
                graph.printMatrix();
            }
            else if (command.equals("PRINTNODE")){
                int v = Integer.parseInt(parts[1]);
                System.out.println((char)('A' + v));
            }
        }

    }
}
