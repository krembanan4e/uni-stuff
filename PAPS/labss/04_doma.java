/*
Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа. 
Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и да се испечати неговата позиција. 
Доколку бројот не е во низата да е испечати "Ne postoi".
Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.


Input	Result
5 3
1 2 3 4 5
----------
2


7 7
1 2 3 4 5 6 7
-----------
6
*/

import java.util.Scanner;

public class Main {
    public static int binary_search(int []arr, int start, int end, int m){
        int middle = (start+end) / 2;
        if (m == arr[middle]){
            return middle;
        }
        if (start == end && m != arr[middle]){
            return -1;
        }

        if(m > arr[middle]){
            return binary_search(arr, middle+1, end, m);
        }
        else{
            return binary_search(arr, start, middle-1, m);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int []arr = new int[N];
        for (int i =0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = N-1;

        int index = binary_search(arr, start, end, M);
        if (index == -1){
            System.out.println("Ne postoi");
        }
        else{
            System.out.println(index);
        }
    }
}
