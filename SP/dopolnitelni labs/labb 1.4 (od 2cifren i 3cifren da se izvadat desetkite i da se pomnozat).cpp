//Од двоцифрен и троцифрен број да се извадат десетките и да се помножат тие 2 цифри.

#include <iostream>
using namespace std;
int main() {
    int xx, yyy, d1, d2;
    cout << "Vnesi 1 dvocifren i 1 trocifren broj" << endl;
    cin >> xx >> yyy;
    d1 = xx / 10;
    d2 = yyy / 10 % 10;
    cout << "Dvete cifri od desetkite pomnozeni: " << d1 * d2;
    return 0;
}
