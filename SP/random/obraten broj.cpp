#include <iostream>
using namespace std;
int main(){
    int n, obraten = 0;
    cin >> n;
    while ( n != 0 ){
        obraten = obraten * 10 + n%10;
        n /= 10;
    }
    cout << obraten;

    return 0;
}
