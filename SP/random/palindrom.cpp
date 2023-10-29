#include <iostream>
using namespace std;
int main() {
    int n, temp, broj;
    cout << "Vnesi broj:";
    cin >> n;
    broj = n; //deka n se menvit vo while, za da se zachuvat prvichniot broj ovde
    while ( n != 0 ) {
        temp = (temp * 10) + n % 10;
        n = n / 10;
        
        /* primer za 12321
         * temp = 0 * 10 + 1 = 1           n = 1232
         * temp = 1 * 10 + 2 = 12          n = 123
         * temp = 12 * 10 + 3 = 123        n = 12
         * temp = 123 * 10 + 2 = 1232      n = 1
         * temp = 1232 * 10 + 1 = 12321    n = 0
         */
    }
    if ( temp == broj ){
        cout << "Brojot e palindrom :)" << endl;
    }
    else {
        cout << "Brojot ne e palindrom :(" << endl;
    }


    return 0;
}
