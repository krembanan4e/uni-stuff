package hesh;
import java.util.*;
//strana 238 vo knigata

/*
Пример:
Влез:
12
1 SoedinetiAmerikanskiDrzavi
20 Egipet
21 Maroko
26 Zambija
351 Portugalija
355 Albanija
359 Bugarija
372 Estonija
381 Srbija
385 Hrvatska
387 BosnaiHercegovina
389 Makedonija
+2611332345678

Излез: Zambija
*/

public class PovikuvackiBrojNaZemja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, String> table1 = new CBHT<>(2*n-1); //ednocifren kod
        CBHT<String, String> table2 = new CBHT<>(2*n-1); //dvocifren kod
        CBHT<String, String> table3 = new CBHT<>(2*n-1); //tricifren kod

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String broj = parts[0];
            String zemja = parts[1];
            switch (broj.length()){
                case 1:
                    table1.insert(broj, zemja);
                    break;
                case 2:
                    table2.insert(broj, zemja);
                    break;
                case 3:
                    table3.insert(broj, zemja);
                    break;
            }
        }

        String tel_broj = sc.nextLine().substring(1); //da ne ja zemat pluskata

        switch (tel_broj.charAt(0)){
            case '1':
                System.out.println("SoedinetiAmerikanskiDrzavi");
                break;
            case '2':
                SLLNode<MapEntry<String, String >> curr = table2.search(tel_broj.substring(0,2));
                if (curr != null) {
                    System.out.println(curr.element.value);
                }
                break;
            case '3':
                SLLNode<MapEntry<String, String >> curr2 = table2.search(tel_broj.substring(0,3));
                if (curr2 != null) {
                    System.out.println(curr2.element.value);
                }
                break;
        }
        
    }
}
