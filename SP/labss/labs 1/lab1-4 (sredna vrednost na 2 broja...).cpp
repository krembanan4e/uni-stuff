//Да се напише програма во која корисникот внесува два цели броја. Програмата треба да ја најде нивната средна вредност.
//Потоа, програмата треба да го зголеми првиот број за вредноста на таа средна вредност, а вториот број да го намали за истата вредност.
//На крајот, да се испечати новата разлика меѓу броевите.
// input:           output:
// 3                Razlikata e: 6
// 5              

#include <iostream>
using namespace std;
int main() {

    int x, y, srednaVrednost, razlika=0;
    cin >> x >>y;
    srednaVrednost = (x+y)/2;
    x += srednaVrednost;
    y -= srednaVrednost;
    cout << "Razlikata e: " << x-y;

    return 0;
}
