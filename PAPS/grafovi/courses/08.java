/*
Потребно е дадени материјали да се трансформираат во други материјали. Дадени се можните директни трансформации и цената за секоја од нив.
Да се одреди најмалата цена за да се транформираат почетните материјали во целните.

Влез: Во првиот ред е даден бројот на материјали N во секоја група (почетни и целни). 
Потоа во следните N редови се дадени парови на материјали: почетниот материјал и материјалот во кој треба да се трансформира. 
Во следниот ред е даден бројот на можни трансформации M, а потоа во следните M редови се дадени трансформациите и нивните цени.
Излез:  Минималната цена да се трансформираат сите материјали.

Пример:
Влез:
4
Wood Wood
Iron Steel
Steel Iron
Glass Mirror
6
Wood Iron 2
Iron Steel 5
Steel Iron 5
Steel Mirror 1
Mirror Iron 2
Glass Mirror 20

Излез: 28 
(Објаснување: транформација wood->wood 0; транформација iron->steel 5; транформација steel->iron 3; транформација glass->mirror 20 ----> вкупно: 28)
*/

//vo addEdge iskomentiran e delot za nenasocen graf

package grafovi.listaTezinskiNasocen;

import java.util.*;

public class Courses08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> map = new HashMap<>(); //pocheten materijal vo transformiran materijal

        for (int i = 0; i < n; i++) {
            String pocheten = sc.next();
            String transformrian = sc.next();
            map.put(pocheten, transformrian);
        }

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String p = sc.next();
            String t = sc.next();
            int cena = sc.nextInt();
            sc.nextLine();
            graph.addEdge(p, t, cena);
        }

        int suma = 0;

        for (String pocheten : map.keySet()){
            Map<String, Integer> distances = graph.shortestPath(pocheten); //za sekoj poceten matrijal daj HashMap so najkratkite rastojanija od nego do sekoj drug matrijal
            String transformiran = map.get(pocheten); //za toj poceten matrijal zemi go transformiraniot matrijal
            
            for (String dest : distances.keySet()){ 
                if (transformiran.equals(dest)){
                    suma += distances.get(dest);
                }
            }
        }

        System.out.println(suma);
    }
}
