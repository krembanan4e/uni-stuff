/*
За дадена низа од N цели броеви, да се избришат елементите со вредност помала од просекот на сите елементи во низата. 
На пример за низата 1, 2, 3, 4, 5 просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, што значи треба да се избришат елементите 1 и 2, што значи низата после оваа трансформација ќе биде 3, 4, 5.

Влез: Првиот број од влезот е бројот на елементи во низата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
Излез: Низата пред и после направената трансформација.


5
1 2 3 4 5
---------------
{1,2,3,4,5}
{3,4,5}

*/

import java.util.*;
import java.io.*;

public class Main{

    public static void print(int[] array, int n){
        if (n==1){
            System.out.print("{" + array[0] + "}");
        }
        else{
            for (int i=0; i<n; i++){
                if (i==0){
                    System.out.print("{" + array[i]);
                    continue;
                }
                System.out.print("," + array[i]);
                if (i==array.length-1){
                    System.out.print("}");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        int sum = 0;
        for (int i=0; i<N; i++){
            array[i] = input.nextInt();
            sum += array[i];
        }

        double average = (double)sum/(double)N;

        int counter = 0;
        for (int a : array){
            if (a < average){
                counter++;
            }
        }

        int[] array2 = new int[N-counter];

        for (int i=0, j=0; i<array.length; i++){
            if (array[i] >= average){
                array2[j++] = array[i];
            }
        }

        print(array, N);
        System.out.println();
        print(array2, N-counter);

    }
}
