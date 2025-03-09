package queue;

/*
Пример:
Влез:
2
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
VladimirTrajkovik
SlobodanKalajdziski
AnastasMisev
1
IlinkaIvanoska

Излез: 1
IlinkaIvanoska
VladimirTrajkovik
2
SlobodanKalajdziski
AnastasMisev
3
IgorKulev
MagdalenaKostoska
4
HristinaMihajloska
 */

import java.util.ArrayList;
import java.util.Scanner;

public class KnigaQueue_str129 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kapacitet = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> prijaveni = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prijaveni.add(sc.next());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ostanati = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ostanati.add(sc.next());
        }

        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<String> matematika = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            matematika.add(sc.next());
        }

        //prvo od matematika, pa od ostanati, pa od prijaveni
        //spored to kolku e kapacitetot

        ArrayList<String> site = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            site.add(matematika.get(i));
        }
        for (int i = 0; i < m; i++) {
            site.add(ostanati.get(i));
        }
        for (int i = 0; i < n; i++) {
            if (site.contains(prijaveni.get(i))) {
                continue;
            }
            else{
                site.add(prijaveni.get(i));
            }
        }

        double vkupno = Math.ceil((n+m+k)/kapacitet);
        int vk = (int)vkupno;

        for (int i = 0; i < vk; i++) {
            System.out.println(i+1);
            for (int j=0; j<kapacitet; j++){
                if (!site.isEmpty()){
                    System.out.println(site.getFirst());
                    site.removeFirst();
                }
                else {
                    break;
                }
            }
        }
    }
}
