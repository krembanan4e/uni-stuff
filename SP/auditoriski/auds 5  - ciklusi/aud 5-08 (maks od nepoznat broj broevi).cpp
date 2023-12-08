//Да се напише програма што од непознат број на цели броеви што се внесуваат од тастатура ќе го определи бројот со максимална вредност.
//Притоа, броевите поголеми од 100 не се земаат предвид т.е. се игнорираат. Програмата завршува ако се внесе невалидна репрезентација на број.

#include <iostream>
using namespace std;
int main() {
    int n, maks;

    if ( cin >> maks ){
        while ( cin >> n ){
            if ( n > 100 ) continue;
            if ( maks < n ){
                maks = n;
            }
        }
        cout << maks;
    }
    else {
        cout << "Nevalidna reprezentacija na broj";
    }

    return 0;
}
