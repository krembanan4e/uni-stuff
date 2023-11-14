#include <iostream>
using namespace std;
int main(){
    char znak, c;
    cin >> znak;
    if ( znak >= '0' && znak <= '9'){
        c = znak - '0';
        cout << "Znakot vo int broj e: " << c;   //char digit vo int
    }
    else if ( znak >= 'a' && znak <= 'z'){
        c = ( znak + ( 'A' - 'a'));
        cout << "Znakot vo mala vo golema bukva e: " << c;    //mala vo golema
    }
    else if ( znak >= 'A' && znak <= 'Z'){
        c = ( znak + ( 'a' - 'A'));
        cout << "Znakot od golema vo mala bukva e: " << c;    //golema vo mala
    }

    return 0;
}
