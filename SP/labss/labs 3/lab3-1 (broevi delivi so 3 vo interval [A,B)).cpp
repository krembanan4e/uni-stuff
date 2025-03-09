//Да се напише програма што ќе ја испечати сумата на сите броеви деливи со 3
//во интервалот [A,B). А и В се внесуваат од тастатура.

#include <iostream>
using namespace std;
int main() {
    int a, b, suma = 0;
    cin >> a >> b;
    for ( int i = a; i < b; i++ ){
        if ( i % 3 == 0 ){
            suma += i;
        }
    }
    cout << suma;


return 0;
}
