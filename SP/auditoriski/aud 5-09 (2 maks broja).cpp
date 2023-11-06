//Да се напише програма што од непознат број на цели броеви што се внесуваат од тастатура
//ќе ги определи двата броја со најголеми вредности. Програмата завршува ако се внесе невалидна репрезентација на број.
//пример
//Ако се внесат броевите 2 4 7 4 2 1 8 6 9 7 10 3 програмата ќе отпечати 10 и 9.

#include <iostream>
using namespace std;
int main() {
    int maks1, maks2, n, temp;
    if ( cin >> maks1 >> maks2 ){
        if ( maks2 > maks1 ){
            temp = maks1;
            maks1 = maks2;
            maks2 = temp;
        }
        while ( cin >> n ){
            if ( n > maks1 ){
                maks2 = maks1;
                maks1 = n;
            }
            else if ( n > maks2 ){
                maks2 = n;
            }
        }
        cout << maks1 << " " << maks2;
    }
    else {
        cout << "Nevalidna reprezentacija na broj!" ;
    }



    return 0;
}
