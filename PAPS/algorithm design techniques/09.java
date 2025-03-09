package tehnikiNaKreiranjeAlgoritmi;

/*
За дадена сума од цифри и број од цифри, да се најде најмалиот број чиј цифри ја формираат таа сума.
Влез: На влез се дадени два броја, N бројот на цифри и M сумата на цифри
Излез: На излез треба да се испечати најмалиот број со N цифри кој ја формира таа сума. Ако не постои таков број на излез да се испечати "Ne postoi"

Пример:
Влез:
2 10
Излез:
19
 */

import java.util.*;

public class Courses09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //broj na cifri
        int m = sc.nextInt(); //zbir

        if (m > 9*n){
            System.out.println("Ne postoi");
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();

        m = m-1;

        for (int i = 0; i < n-1; i++){
            if (m == 0){
                list.add(0);
            }
            else if (m < 9){
                list.add(m);
                m = 0;
            }
            else if (m >= 9){
                list.add(9);
                m -= 9;
            }
        }

        list.add(1);
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }

    }
}
