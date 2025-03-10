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

public class Main{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //broj na cifri
        int m = sc.nextInt(); //suma
        int []arr = new int[n];
        arr[0] = 1; //prvata cifra na brojot da e 1
        m = m - 1; //namali ja sumata za 1, deka 1 e prvata cifra

        if (n*9 < m){
            System.out.println("Ne postoi");
            return;
        }

        for (int i = n-1; i > 0; i--){
            if (m == 0){
                break;
            }
            if (m < 9){ //ako sumata e <9 stavi go to sho e ostanato
                arr[i] = m;
                break;
            }
            else{ //ako sumata e >=9, stavi 9ka i namali ja sumata za 9
                arr[i] = 9;
                m -= 9;
            }

        }

        for (int i = 0; i < n; i++){
            System.out.print(arr[i]);
        }

    }
}
