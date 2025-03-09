//Да се напише програма за пресметување на y = x^n за даден природен број n, n >= 1 и реален број x.

#include <iostream>
using namespace std;
int main() {
    int n;
    float x, y = 1;
    cin >> x >> n;
    if ( n >= 1 ){
        for ( int i = 1; i <= n; i++ ){
            y *= x;
        }
        cout << y;
    }

    return 0;
}
