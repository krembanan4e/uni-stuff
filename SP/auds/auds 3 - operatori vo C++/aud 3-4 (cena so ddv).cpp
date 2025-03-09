//Да се напише програма каде од тастатура ќе се внесе цена на производ,
//а потоа ќе ја испечати неговата цена со пресметан ддв.
//ПОМОШ: ДДВ е 18% од почетната цена

#include <iostream>
using namespace std;
int main() {
    float cena;
    cout << "Vnesi cena na proizvod ";
    cin >> cena;
    cout << "Cenata so presmetan DDV e " << cena * 1.18 << endl;
    return 0;
}
