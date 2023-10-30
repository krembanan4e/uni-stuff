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
        default:
            cout << "Soglaska.";

    }


    return 0;
}
