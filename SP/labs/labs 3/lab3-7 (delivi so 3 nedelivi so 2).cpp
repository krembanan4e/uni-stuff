//Да се напише програма што ќе ја испечати сумата на сите броеви деливи со 3 и неделиви со 2
//во интервал (A,B]. А и В се внесуваат од тастатура

//input              output
//10 20              15

//10 1000            83655

//500 600            9333

#include <iostream>
using namespace std;
int main() {
    int a, b, suma = 0;
    cin >> a >> b;
    for ( int i = a; i <= b; i++ ){
        if (( i % 3 == 0 ) && (i % 2 != 0)){
            suma += i;
        }
    }
    cout << suma;

    return 0;
}
