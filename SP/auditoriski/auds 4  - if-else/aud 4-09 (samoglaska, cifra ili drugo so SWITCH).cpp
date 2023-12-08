//Да се напише програма што за знак внесен од тастатура ќе одреди дали е самогласка, цифра или другo.
//SWITCH

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    char c;
    cin >> c;
    if ( c >= 'A' && c <= 'Z')
    {
        c = char ( c + ( 'a' - 'A' ) );
    }
    switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            cout << "Samoglaska.";
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            cout << "Cifra.";
            break;
        default:
            cout << "Drugo.";

    }


    return 0;
}
