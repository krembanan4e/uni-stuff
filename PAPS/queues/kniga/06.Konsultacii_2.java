package queue;

/*
Пример:   OD KNIGATA
Влез:
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
2
AnastasMishev
VladimirTrajkovik
1
SlobodanKalajdziski
-------------------------
Излез:
IlinkaIvanoska
AnastasMishev
IgorKulev
VladimirTrajkovik
MagdalenaKostoska
SlobodanKalajdziski
HristinaMihajloska
SlobodanKalajdziski



Primer 2: (obratno teorija i zadaci za testiranje)
2
AnastasMishev
VladimirTrajkovik
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
1
SlobodanKalajdziski
 */

import java.util.ArrayList;
import java.util.Scanner;

public class KnigaQueue_str143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> prasanja = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prasanja.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> zadaci = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            zadaci.add(sc.nextLine());
        }

        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<String> dvete = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            dvete.add(sc.nextLine());
        }

        //prvo eden od prasanja, pa eden od dvete(prasanja), pa eden od zadaci, pa eden od dvete(zadaci)

        int p = n+k; //vkupno za prasanja
        int z = m+k; //vkupno za zadaci
        int vkupno = n+m+k;

        for (int i = 0; i < vkupno; i++) {
            if (!prasanja.isEmpty()){
                System.out.println(prasanja.getFirst());
                prasanja.removeFirst();
                if (!zadaci.isEmpty()){
                    System.out.println(zadaci.getFirst());
                    zadaci.removeFirst();
                }
                else if (zadaci.isEmpty()){
                    System.out.println(dvete.getFirst());
                    prasanja.add(dvete.getFirst());
                    dvete.removeFirst();
                }
                if (dvete.isEmpty()){
                    while (!prasanja.isEmpty()){
                        System.out.println(prasanja.getFirst());
                        prasanja.removeFirst();
                    }
                }
            }

            else if (!zadaci.isEmpty()){
                if(!dvete.isEmpty()){
                    System.out.println(dvete.getFirst());
                    zadaci.add(dvete.getFirst());
                    dvete.removeFirst();
                }
                if (!prasanja.isEmpty()){
                    System.out.println(prasanja.getFirst());
                    prasanja.removeFirst();
                }
                if (prasanja.isEmpty()){
                    System.out.println(zadaci.getFirst());
                    zadaci.removeFirst();
                }
            }
        }
    }
}
