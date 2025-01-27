package listi;
/*
3
4
1 2 3 4
2 3 4 5
6 7 8 9

output:
4200
 */

import java.util.Scanner;

public class KnigaListi_str64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DLL<DLL<Integer>> list = new DLL<>();

        int proizvod = 1;

        for (int i=0; i<n; i++){
            DLL<Integer> vnatresna = new DLL<>();
            int suma = 0;
            for (int j=0; j<m; j++){
                int broj = sc.nextInt();
                vnatresna.insertLast(broj);
                suma += broj;
            }
            proizvod *= suma;
            list.insertLast(vnatresna);
        }
        
        System.out.println(proizvod);
    }
}
