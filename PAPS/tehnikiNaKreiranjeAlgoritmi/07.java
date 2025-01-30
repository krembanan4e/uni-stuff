package tehnikiNaKreiranjeAlgoritmi;

/*
Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа.
Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и да се испечати неговата позиција. Доколку бројот не е во низата да е испечати "Ne postoi".

Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.

5 3
1 2 3 4 5
-----------
2
 */

import java.util.*;

public class Courses07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int foundIndex = Collections.binarySearch(list, m);
        if (foundIndex < 0){
            System.out.println("Ne postoi");
        }
        else{
            System.out.println(foundIndex);
        }
    }
}
