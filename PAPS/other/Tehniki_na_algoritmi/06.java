/*
Дадена е низа од „речиси“ сортирани броеви во растечки редослед, во смисол дека во сортирана низа има неколку залутани броеви кои се надвор од редоследот. 
Залутаните броеви се секогаш мали броеви кои се наоѓаат подесно од нивното вистинско место.
Ваша задача е да ги најдете залутаните броеви, како и бројот на места што залутаниот број треба да се помести во лево за низата да биде сортирана.
НАПОМЕНА: Оптималното решение има сложеност помала од квадратна

Влез:
Во првиот ред е даден број N, големината на низата
Во наредните N редови се дадени броевите од низата.

Излез:
Во првиот ред се печати M, бројот на залутани броеви.
Во наредните M редови, се печати секој залутан број, како и бројот на места за кои треба да биде поместен во лево.

Забелешка: Залутаните броеви се растечки подредени еден во однос на друг, во смисол дека залутан број при поместување на лево нема да премине преку друг залутан број.

Пример:
Влез:

8
1
3
4
5
2
6
8
7

Излез:
2
2 3
7 1

Образложение:
Дадени се 8 броеви на влез. Од нив, бројот 2 и бројот 7 се надвор од своите места. 
Ако бројот 2 го поместиме за 3 места на лево, а бројот 7 го поместиме за 1 место на лево, низата ќе биде во сортиран редослед.
*/

import java.util.*;

public class Main{
    public static void zalutani_broevi(int []arr, int n){
        int mesta_counter = 0;
        int []mesta = new int[n];
        int m = 0; //brojac za nizata od mesta
        int []zalutani = new int[n];
        int z = 0; //brojac za nizata od zalutani

        for (int i = 0; i < n-1; i++){  //niza od zalutani broevi
            if (arr[i] > arr[i+1]){
                zalutani[z++] = arr[i+1];
            }
        }

        for (int i = 0; i < z; i++) {//za sekoj zalutan broj
            for (int j = 0; j < n; j++){ //za sekoj broj od originalnata niza
                if (zalutani[i] >= arr[j]){
                    if (mesta_counter != 0){
                        mesta[m++] = mesta_counter;
                        i++;
                    }
                    mesta_counter = 0;
                }
                if (zalutani[i] < arr[j]){ //od kolku broevi e pomal, tolku mesta e podesno
                    mesta_counter++;
                }
            }
        }

        System.out.println(z);
        for (int i = 0; i < z; i++){
            System.out.println(zalutani[i] + " " + mesta[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        zalutani_broevi(arr, n);
    }
}
