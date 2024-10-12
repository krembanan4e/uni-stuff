//da se napise programa vo koja ke se presmeta suma na prvite N prosti broevi

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //za citanje od tastatura
        int n = sc.nextInt();
        int sum=0;
        for (int i=1; i<n; i++){
            boolean isPrime=true;
            for (int j=2; j<i; j++){
                if (i%j==0){
                    isPrime=false;
                }
            }
            if (isPrime){
                sum+=i;
            }
        }
        System.out.println("Sumata na prvite " + n + " prosti broevi e: " + sum);
    }
}
