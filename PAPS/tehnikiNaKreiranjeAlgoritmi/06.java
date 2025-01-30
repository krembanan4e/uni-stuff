package tehnikiNaKreiranjeAlgoritmi;

/*
Дадена е низа од „речиси“ сортирани броеви во растечки редослед, во смисол дека во сортирана низа има неколку залутани броеви кои се надвор од редоследот.
Залутаните броеви се секогаш мали броеви кои се наоѓаат подесно од нивното вистинско место.
Ваша задача е да ги најдете залутаните броеви, како и бројот на места што залутаниот број треба да се помести во лево за низата да биде сортирана.
НАПОМЕНА: Оптималното решение има сложеност помала од квадратна

Влез:
Во првиот ред е даден број N, големината на низата. Во наредните N редови се дадени броевите од низата.
Излез:
Во првиот ред се печати M, бројот на залутани броеви.
Во наредните M редови, се печати секој залутан број, како и бројот на места за кои треба да биде поместен во лево.

8
1
3
4
5
2
6
8
7
--------------
2
2 3
7 1
 */

import java.util.*;

public class Courses06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.reverse(list);

        ArrayList<Integer> zalutani = new ArrayList<>();
        ArrayList<Integer> pozicii = new ArrayList<>();

        //od kolku brojoj e pomal toj broj -> tolku pozicii se
        
        int counter = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int n1 = list.get(i);
            boolean flag = false;
            for (int j = i+1; j < n; j++) {
                int n2 = list.get(j);
                if (n1 >= n2) {
                    if (flag){
                        //System.out.println(num + " " + counter);
                        zalutani.add(num);
                        pozicii.add(counter);
                        flag = false;
                        counter = 0;
                    }
                    break;
                }
                else{
                    num = n1;
                    counter++;
                    flag = true;
                }
            }
        }

        if (counter != 0){ //za posledniot broj ak ne vlezit vo vtoriot for
            zalutani.add(num);
            pozicii.add(counter);
        }

        Collections.reverse(zalutani);
        Collections.reverse(pozicii);
        System.out.println(zalutani.size());
        
        for (int i = 0; i < zalutani.size(); i++) {
            System.out.println(zalutani.get(i) + " " + pozicii.get(i));
        }
    }
}
