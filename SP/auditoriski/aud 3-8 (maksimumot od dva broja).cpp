//Да се напише програма со која ќе се отпечати максимумот од два броја чии вредности се читаат од тастатура.

#include <iostream>
using namespace std;
int main() {
    int a, b;
    cin >> a >> b;
    if ( a > b ){
        cout << "Maksimumot e " << a;
    }
    else{
        cout << "Maksimumot e " << b;
    }

// maks = ( a > b ) ? a : b;      cout << maks 
    
    return 0;
}
