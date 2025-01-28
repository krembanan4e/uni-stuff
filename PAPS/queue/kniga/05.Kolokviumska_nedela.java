package queue;

/*
Пример:
Влез:
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
APS 3
MIS 1
OOS 2
1
HristinaMihajloska

Излез:
APS
3
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
MIS
1
IlinkaIvanoska
OOS
2
IgorKulev
MagdalenaKostoska
 */

import java.util.ArrayList;
import java.util.Scanner;

public class KnigaQueue_str142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> asistenti = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            asistenti.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> predmeti =  new ArrayList<>();
        for (int i = 0; i < m; i++) {
            predmeti.add(sc.nextLine());
        }

        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<String> otsutni =  new ArrayList<>();
        for (int i = 0; i < k; i++) {
            otsutni.add(sc.nextLine());
        }


        for (int i = 0; i < m; i++) {
            String []parts = predmeti.get(i).split(" ");
            String predmet = parts[0];
            int broj = Integer.parseInt(parts[1]);

            System.out.println(predmet);
            System.out.println(broj);

            for (int j=0; j<broj; j++){
                if (asistenti.getFirst().equals(otsutni.getFirst())){
                    otsutni.add(otsutni.getFirst());
                    otsutni.removeFirst();
                    asistenti.removeFirst();
                }

                System.out.println(asistenti.getFirst());
                asistenti.add(asistenti.getFirst());
                asistenti.removeFirst();
            }

        }
    }
}
