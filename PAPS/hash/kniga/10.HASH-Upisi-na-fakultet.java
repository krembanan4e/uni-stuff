package hesh;
import java.util.*;
//strana 231 vo knigata

/*
Пример1:
Влез:
2
0610992333666 5.0
0901993222233 4.7
4
2205990121212 2.45
0901993222233 4.68
0610992333666 5.0
1511989984256 3.45
0901993222233

Излез:
Error
----------------------
Пример2:
Влез:
2
0610992333666 5.0
0901993222233 4.78
4
2205990121212 2.45
0901993222233 4.68
0610992333666 5.0
1511989984256 3.45
0610992333666

Излез:
OK
-----------------------
Пример3:
Влез:
2
0610992333666 5.0
0901993222233 4.78
4
2205990121212 2.45
0901993222233 4.68
0610992333663 5.0
1511989984256 3.45
0610992333666

Излез:
Empty

 */

public class UpisiNaFakultet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Float> table1 = new CBHT<>(2*n-1); //key e maticniot, value e prosekot
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String maticen = parts[0];
            Float prosek = Float.parseFloat(parts[1]);
            //SLLNode<MapEntry<String , Float>> curr = table1.search(maticen);
            table1.insert(maticen, prosek);
        }

        int m = sc.nextInt();
        sc.nextLine();
        CBHT<String, Float> table2 = new CBHT<>(10*m-1); //key e maticniot, value e prosekot
        //10*m zsh ak e pomal broj se stavet vo ista koficka 2 podatoci, a ne trebit da se prebrishat :)
        for (int i = 0; i < m; i++) {
            String []parts = sc.nextLine().split(" ");
            String maticen = parts[0];
            Float prosek = Float.parseFloat(parts[1]);
            //SLLNode<MapEntry<String , Float>> curr = table2.search(maticen);
            table2.insert(maticen, prosek);
        }

        String maticen = sc.nextLine();
        SLLNode<MapEntry<String, Float>> curr1 = table1.search(maticen); //baraj vo prvata
        SLLNode<MapEntry<String, Float>> curr2 = table2.search(maticen); //baraj vo vtorata

        if (curr1 != null){ //go imat vo prvata

            if (curr2 == null){ //go nemat vo vtorata
                System.out.println("Empty");
            }

            if (curr2 != null){ //go imat vo vtorata
              
                if (curr1.element.value.equals(curr2.element.value)){
                    System.out.println("OK");
                }
                if (!curr1.element.value.equals(curr2.element.value)){
                    System.out.println("Error");
                }
              
            }

        }

        // System.out.println(table1);
        // System.out.println("------------------");
        // System.out.println(table2);

    }
}
