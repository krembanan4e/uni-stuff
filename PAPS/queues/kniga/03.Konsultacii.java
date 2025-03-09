package queue;

/*
Пример:
Влез:
3
IlinkaIvanoska A
MagdalenaKostoska A
HristinaMihajloska B
1
IgorKulev

Излез:
IlinkaIvanoska
IgorKulev
HristinaMihajloska
MagdalenaKostoska
 */

import java.util.ArrayList;
import java.util.Scanner;

public class KnigaQueue_str133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> aps = new ArrayList<>(); //prijaveni za aps
        for (int i = 0; i < n; i++) {
            aps.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> mms = new ArrayList<>(); //prijaveni za mms
        for (int i = 0; i < m; i++) {
            mms.add(sc.nextLine());
        }

        String tip;
        String prethoden_tip = "";
        for (int i = 0; i < n+m; i++) {
            String []parts = aps.getFirst().split(" ");
            String ime = parts[0];
            tip = parts[1];

            if (tip.equals(prethoden_tip)){
                aps.add(aps.getFirst());
                aps.removeFirst();
                if (!mms.isEmpty()){
                    System.out.println(mms.getFirst());
                    mms.removeFirst();
                }
            }
            else{
                System.out.println(ime);
                aps.removeFirst();
                prethoden_tip = tip;
            }

        }
    }
}
