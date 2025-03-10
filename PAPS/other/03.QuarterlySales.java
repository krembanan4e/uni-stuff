/*
За потребите на софтвер за евиденција на приходите остварени од вработените во одделот за продажба, да се дефинира класа QuarterlySales во која се чуваат 
бројот на продажби остварени во одреден квартал, приходот добиен од секоја продажба и бројот на кварталот.

Потоа, да се дефинира друга класа SalesPerson за кој се чува име (string) и низа од квартали (точно 4). 
За класите да се имплементираат соодветните конструктори и методи за правилно извршување на програмата. Да се имплементираат следните барања:

• Метод int sumSales(SalesPerson sp) кој ќе врати сума од сите приходи остварени од дадениот вработен во одделот за продажба во сите квартали.
• Метод SalesPerson salesChampion(SalesPerson [] arr) кој за дадената низа од работници ќе го врати работникот со најголем остварен приход (од сите квартали).
• Да се дополни main методот во кој ќе се иницијализира низа од вработени во одделот за продажба и квартали согласно влезните тест примери. Во првиот ред се чита број на вработени, 
а понатаму прво во еден ред се чита името, па за секој квартал во еден ред бројот на продажби, и во следниот ред приходот добиен од секоја од тие продажби.
• На стандарден излез да се испечати низата од вработени во одделот за продажба со помош на методата void table(SalesPerson [] arr) која за низата од вработени 
ќе отпечати приказ во следниот формат (за простор при печатење се користат три празни места):

input:
5
Damian
3
2000 1500 1000
5
1000 1300 2500 800 1100
2
3000 2000
1
1700
Samantha
4
1500 2000 1700 1200
6
900 1200 1800 1100 1500 1300
3
2500 3000 2000
5
800 1000 1300 1200 900
Jackson
5
1300 1500 1600 1200 1400
4
1700 2100 2000 1900
6
900 1200 1500 1800 2000 2200
7
500 700 900 1100 1300 1500 1700
Olivia
2
3500 3000
3
2000 2500 3000
4
1500 1800 2100 2400
5
1000 1300 1600 1900 2200
Liam
6
1100 1400 1700 2000 2300 2600
7
500 700 900 1100 1300 1500 1700
8
800 1000 1200 1400 1600 1800 2000 2200
3
2700 3000 3300


output:
SP   1   2   3   4   Total
Damian   4500   6700   5000   1700   17900
Samantha   6400   7800   7500   5200   26900
Jackson   7000   7700   9600   7700   32000
Olivia   6500   7500   7800   8000   29800
Liam   11100   7700   12000   9000   39800

SALES CHAMPION: Liam
*/

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues; //prihodi
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public void setNumOfSales(int numOfSales) {
        this.numOfSales = numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public void setRevenues(int[] revenues) {
        this.revenues = revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }

    public void setQuarterNo(int quarterNo) {
        this.quarterNo = quarterNo;
    }

    public int totalSalesPerQuartal(){
        int sum=0;
        for (int i=0; i<numOfSales; i++){
            sum += revenues[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        int sum=0;
        for (int i=0; i<numOfSales; i++){
            sum += revenues[i];
        }
        return sum + "   ";
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }

    public void setQuarters(QuarterlySales[] quarters) {
        this.quarters = quarters;
    }

    int totalOfAllQuartals(){
        int sum=0;
        for (int i=0; i<4; i++){
            sum += quarters[i].totalSalesPerQuartal();
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = new String();
        s += name + "   ";
        for (int i=0; i<4; i++){
            s += quarters[i].toString();
        }
        s += totalOfAllQuartals();
        return s;
    }
}



public class Main {

    public static int sumSales(SalesPerson sp)
    {
        int sum=0;
        for (int i=0; i<sp.getQuarters().length; i++){
            //getQuarters() ni vrakjat niza, od nizata go zemame i-tiot element,
            //i-tiot kvartal i za nego presmetvime totalSalesPerQuartal()
            sum += sp.getQuarters()[i].totalSalesPerQuartal();
        }
        return sum;
    }

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        int max = sumSales(arr[0]); //vkupniot promet na prviot chovek
        SalesPerson champion = arr[0]; //prviot e champion na pochetok
        for (int i=1; i<arr.length; i++){
            if (sumSales(arr[i]) > max){
                max = sumSales(arr[i]);
                champion = arr[i];
            }
        }
        return champion;
    }

    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i].toString());
            if (i == arr.length-1){
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++) //za sekoj coek od n lugje
        {
            //your code goes here
            input.nextLine();
            String name = input.nextLine();
            QuarterlySales[] quartals = new QuarterlySales[4];
            for (int j=0; j<4; j++)
            { //za sekoj coek citame po 4 kvartali
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];
                for (int k=0; k<numOfSales; k++)
                {
                    revenues[k] = input.nextInt();
                }
                int quarterNo = j+1;
                quartals[j] = new QuarterlySales(numOfSales, revenues, quarterNo);
            }
            SalesPerson person = new SalesPerson(name, quartals);
            arr[i] = person;
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
