/*
Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
Излез: Најголемиот број кој може да се состави од тие цифри


5
1 2 3 4 5
------------
54321

7
9 7 3 7 9 3 1
------------
9977331
*/

import java.util.Scanner;

public class Lab3 {
    public static void print(int []arr, int n){
        for (int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sort(int []arr, int n){
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-1-i; j++){
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void biggest_number(int []arr, int n){
        String str = new String();
        for (int i=0; i<n; i++){
            str += arr[i];
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr,n);
        biggest_number(arr,n);
    }
}
