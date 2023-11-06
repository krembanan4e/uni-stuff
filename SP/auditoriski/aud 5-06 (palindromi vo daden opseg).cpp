//Да се напише програма што ќе ги испечати сите броеви од зададен опсег кои се читаат исто и одлево надесно и оддесно налево.
//пример броеви:
//12321 5061605

#include <iostream>
using namespace std;
int main() {
    int pocetok, kraj;
    cin >> pocetok >> kraj;
    for ( int i = pocetok; i <= kraj; i++ ){
        int temp = i;
        int obraten = 0;
        while ( temp > 0 ){
            obraten = obraten * 10 + temp % 10;
            temp /= 10;
        }
        if ( obraten == i ){
            cout << i << " ";
        }
    }

    return 0;
}
