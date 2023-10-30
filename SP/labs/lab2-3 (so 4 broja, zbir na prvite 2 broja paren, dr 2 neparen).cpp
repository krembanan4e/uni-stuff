//Да се напише програма со која се внесуваат 4 броја. Доколку збирот на првите 2 броја е парен број, а збирот на другите 2 е непарен
//да се испечати 1, а во спротивно 0

//input          output
//3 5 1 2        1
//6 4 7 3        0

#include <iostream>
using namespace std;
int main() {

    int n1, n2, n3, n4, sum12 = 0, sum34 = 0, pecati;
    cin >> n1 >> n2 >> n3 >> n4;
    sum12 = n1 + n2;
    sum34 = n3 + n4;
    pecati = ( sum12 % 2 == 0 && sum34 % 2 != 0 );
    cout << pecati;



    return 0;
}
