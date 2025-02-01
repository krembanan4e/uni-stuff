package hash;

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



import java.util.*;

public class KnigaHash_str238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, String> table = new CBHT<>(10*n-1);
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String kod = parts[0];
            String zemja = parts[1];
            table.insert(kod, zemja);
        }
        String line = sc.nextLine();
        String broj = line.substring(1);
        String cifra = broj.substring(0, 1);
        String key;

        if (cifra.equals("1")){
            key = "1";
        }
        else if (cifra.equals("2")){
            key = broj.substring(0,2);
        }
        else{
            key = broj.substring(0,3);
        }

        SLLNode<MapEntry<String, String>> curr = table.search(key);
        if (curr == null){
            System.out.println("Error");
        }
        else{
            System.out.println(curr.element.value);
        }
    }
}
