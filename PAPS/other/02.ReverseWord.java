/*
За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава број на зборови кои ќе се внесуваат. 
Во наредните линии се внесуваат самите зборови.

input
3
one
two
three

output
eno
owt
eerht

*/

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        int brBukvi = word.length();
        for (int i=brBukvi-1; i>=0; i--) {
            System.out.print(word.charAt(i));
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); //ko cin.ignore() za enterot posle brojot
        String zbor;
        for (int i=0; i<n; i++){
            zbor = sc.nextLine();
            printReversed(zbor);
        }
    }
}
