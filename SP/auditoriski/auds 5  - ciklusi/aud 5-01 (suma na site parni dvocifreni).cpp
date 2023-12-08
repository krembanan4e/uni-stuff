//Да се напише програма за пресметување на сумата на сите парни двоцифрени броеви. Добиената сума се печати на екран.

#include <iostream>
using namespace std;
int main() {
    int suma = 0;
    for ( int i = 0; i < 100; i++ ){
        if ( i % 2 == 0 ){
            suma += i;
        }
    }
    cout << suma;

    return 0;
}
