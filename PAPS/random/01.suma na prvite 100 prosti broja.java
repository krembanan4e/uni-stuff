//da se napise programa vo koja ke se ispechati zbirot na prvite 100 prosti broevi

public class Main{
    public static void main(String[] args){
        int limit = 100;
        int sum = 0;
        for (int i=1; i<limit; i++){
            boolean isPrime = true;
            for (int j=2; j<i; j++){
                if (i%j==0){
                    isPrime = false;
                    //ako mu najme delitel ne e prost
                }
            }
            if (isPrime){
                sum+=i;
            }
        }
        System.out.println("Sumata na prvite 100 prosti broja e: " + sum);
    }
}
