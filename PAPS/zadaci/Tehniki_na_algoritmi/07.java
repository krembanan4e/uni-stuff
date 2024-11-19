/*
Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа. 
Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и да се испечати неговата позиција. 
Доколку бројот не е во низата да е испечати "Ne postoi".
Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.

5 3
1 2 3 4 5
--------------
2



7 7
1 2 3 4 5 6 7
-------------
6
*/

import java.util.*;

public class Main{
    public static int binary_search(int []arr, int start, int end, int m){
        int middle = (end + start) / 2;
        if (m == arr[middle] && start == end){
            return middle;
        }
        if (m != arr[middle] && start == end){
            return -1;
        }
        if (m < arr[middle]){
            return binary_search(arr, 0, middle-1, m);
        }
        else{
            return binary_search(arr, middle + 1, end, m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = binary_search(arr, 0, n-1, m);
        if (idx == -1){
            System.out.println("Ne postoi");
        }
        else{
            System.out.println(idx);
        }
    }
}
