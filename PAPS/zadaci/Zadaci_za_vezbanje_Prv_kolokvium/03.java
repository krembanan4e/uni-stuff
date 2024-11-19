/*
На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно за соседниот град МинТаун. Цената на еден билет е 100 денари. 
Ако некој возрасен сака да патува со K деца, треба да плати еден билет за него и K-1 билети за децата (за едно дете не мора да плаќа билет). 
Исто така, возрасен може да се вози и сам, во тој случај ќе си плати еден билет за него. 
Дополнително знаеме дека децата не можат да се возат без да се придружени од некој возрасен.
Во првиот ред од влезот е даден бројот N. Во вториот ред е даден бројот M. 
Потребно е да пресметате колкав е минималниот и максималниот број на денари што може да ги платат патниците за билети и да ги испечатите во две линии. 
Во автобусот ќе има најмалку еден возрасен.

/

4
10
------------
1000
1300

*/

/*
4
10
-------
1000
1300



aku 1 vozrasen se vozit so 2 deca ke platit eden za nego i eden za edno dete (2*100=200)
aku 1 vozrasen se vozit so 2 deca ke platit eden za nego i eden za edno dete (2*100=200)
aku 1 vozrasen se vozit so 3 deca ke platit eden za nego i dva za dve deca (3*100=300)
aku 1 vozrasen se vozit so 3 deca ke platit eden za nego i dva za dve deca (3*100=300)
min 1000

aku 3 vozrasni se vozat sami, sekoj plakjat po 100 denari za negoviot bilet (3*100 = 300)
+ aku 1 vozrasen se vozit so 10te deca ke platit bilet za nego i za 9 deca (10*100 = 1000)
max 1300

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int[] arr = new int[N];
        int z =0;
        int temp = M;
        //prajme niza 3,3,2,2
        //10 da se rasporedit na 4 vraboteni maksimalno ramnomerno
        while (temp > 0) {
            arr[z++]++;
            temp--;

            if (z == N) {
                z = 0;
            }

            if (temp == 0) {
                break;
            }
        }

//        for (i = 0; i < N; i++){
//            System.out.print(arr[i]);
//        }

        int min_suma = 0;
        for (i = 0; i < N; i++) {
            if (arr[i] == 0){
                min_suma += 100;
            }
            min_suma += arr[i]*100;
        }
        System.out.println(min_suma);

        int max_suma = 0;
        if (M == 0){
            max_suma = N*100 + M*100;
        }
        else{
            max_suma = (N-1)*100 + M*100;
        }

        System.out.println(max_suma);


    }

}
