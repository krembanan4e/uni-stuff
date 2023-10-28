//Да се напише програма која за даден цел број секунди
//кој се чита од стандарден влез,
//ќе ги отпекати на екран соодветните вредности во часови, минути и секунди.


#include <iostream>
using namespace std;
int main() {
    int sekundi, h, m, s;
    cout << "Vnesi sekundi " << endl;
    cin >> sekundi;
    h = sekundi / 3600; sekundi -= ( h * 3600 );
    m = sekundi / 60; sekundi -= ( m * 60 );
    s = sekundi;
    cout << h << " chasovi, " << m << " minuti, " << s << " sekundi.";
    return 0;
}
