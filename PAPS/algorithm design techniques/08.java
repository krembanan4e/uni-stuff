package tehnikiNaKreiranjeAlgoritmi;

/*
Дадена е низа од N работни задачи, со проценето времетраење во часови, кои треба да се извршат во една компанија.
Компанијата има на располагање M вработени кои работат по 8 часа на ден.
Сите работни активности се помали или еднакви од 8 часа и не може да се извршат половично
Ваша задача е да ја распределите работата помеѓу вработените така што работните задачи ќе се извршат за најкраток можен рок.

Влез: На влез се дадени два броја, N, бројот на задачи и M бројот на вработени.
Во вториот ред на влезот дадени се N цели броеви кои го означуваат времетраењето на секоја задача.
Излез: На излез прво се печати бројот на работни денови потребни за да се извршат задачите.
Потоа се печати збирот од вкупниот број на слободни часови кај сите вработени според вашата распределба.

7 2
8 7 3 5 1 3 1
------------------
2 4
 */

import java.util.*;

public class Courses08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //broj na zadaci
        int m = sc.nextInt(); //broj na rabotnici

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
            tempList.add(num);
        }

        list.sort(Comparator.reverseOrder()); //za vo opagjacki

        //na - dodavame brojki dur dojt do 8*m -> to e 1 den
        int hours = m * 8;
        int temp = 0;
        int days = 0;


        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
            if (temp > 8*m) {
                temp -= list.get(i);
            } else if (temp == 8*m) {
                days++;
                temp = 0;
                list.set(i, 0);
                i = -1;
            }
            else{
                list.set(i, 0);
            }
        }

        int remaining = 0;

        if (days != 0){
            if (temp != 0){
                days++;
                remaining += m * 8 - temp;
            }
            else{
                remaining = 0;
            }
        }

        else if (days == 0){
            temp= 0;
            for (int i = 0; i < tempList.size(); i++) {
                temp += tempList.get(i);
                if (temp > 8*m) {
                    temp -= tempList.get(i);
                    remaining += 8*m-temp;
                    temp = 0;
                    days++;
                    i--;
                }
            }
            if (temp != 0){
                days++;
                remaining += hours-temp;
            }
        }

        System.out.println(days + " " + remaining);
    }
}
