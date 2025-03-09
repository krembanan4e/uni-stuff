/*
Дадени се состојки за рецепт, при што не се достапни сите потребни состојки. 
Можно е достапните состојки да се транформираат во потребните, при што секоја трансофрмација има одредена цена. 
Дадени се можните директни трансформации и цената за секоја од нив. Да се одреди најмалата цена за да се транформираат достапните состојки во потребните.

Влез: Во првиот ред е даден бројот на состојки N во секоја група (достапни и потребни). 
Потоа во следните N редови се дадени парови на состојки: достапната состојка и состојката во кој треба да се трансформира. 
Во следниот ред е даден бројот на можни трансформации M, а потоа во следните M редови се дадени трансформациите и нивните цени.
Излез:  Минималната цена да се трансформираат сите состојки.

Пример:
Влез:
4
Flour Flour
Pork Bacon
Bacon Pork
Chicken Ham
6
Flour Pork 2
Pork Bacon 5
Bacon Pork 5
Bacon Ham 1
Ham Pork 2
Chicken Ham 20

Излез: 28 

(Објаснување: транформација flour->flour 0, транформација pork->bacon 5, транформација bacon->pork 3, транформација chicken->ham 20,  вкупно: 28)
*/

//vo addEdge iskomentiran e delot za nenasocen graf

package grafovi.listaTezinskiNasocen;

import java.util.*;

public class Courses09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, String> map = new HashMap<>(); //mapiranje na dostapna vo potrebna sostojka

        for (int i = 0; i < n; i++) {
            String dostapna = sc.next();
            String potrebna = sc.next();
            map.put(dostapna, potrebna);
        }

        int m = sc.nextInt();
        sc.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < m; i++) {
            String d = sc.next();
            String p = sc.next();
            int cena = sc.nextInt();
            sc.nextLine();
            graph.addEdge(d, p, cena);
        }

        int suma = 0;

        for (String dostapna : map.keySet()){
            Map<String, Integer> distances = graph.shortestPath(dostapna); //za sekoja dostapna sostojka daj HashMap so site najkratki ceni od nejze do sekoja druga sostojka
            String potrebna = map.get(dostapna); //za taja dostapna sostojka zemi ja potrebnata sostojka

            for (String dest : distances.keySet()){
                if (potrebna.equals(dest)){
                    suma += distances.get(dest);
                }
            }
        }

        System.out.println(suma);
    }
}

