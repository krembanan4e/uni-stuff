/*
За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. 
На стандарден излез да се испечати трансформираната низа.

input
12
1 9 8 4 0 0 2 7 0 6 0 9

output
Transformiranata niza e:
0 0 0 0 1 9 8 4 2 7 6 9

*/

import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int brojac = 0;
        for (int a : arr){
            if (a == 0){
                brojac++;
            }
        }

        int[] arr2 = new int[n];
        for (int i=0; i<n; i++){
            if (arr[i] != 0){
                arr2[brojac++] = arr[i];
            }
        }

        System.out.println("Transformiranata niza e:");
        for (int a : arr2){
            System.out.print(a + " ");
        }

    }

    public static void main (String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        pushZerosToBeginning(arr, n);

    }
}
