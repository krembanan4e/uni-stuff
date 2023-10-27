//Да се напише програма со која корисникот внесува два цели броја, а програмата ќе изврши замена на броевите, 
//одностно првиот број ќе ја земе вредноста на вториот, а вториот ќе ја земе вредноста на првиот. 
//Притоа да се испечати разликата на броевите пред и после направената замена.
//Упатство: за да направите замена на броевите користете привремена променлива
// input:           output:
// 32               Vrednosta na broj1 i broj2 pred zamena na broevite e: 32,5 a razlikata: 27
// 5                Vrednosta na broj1 i broj2 posle zamena na broevite e: 5,32 a razlikata: -27

#include <iostream>
using namespace std;
int main() {
    int broj1, broj2, n1, n2, razlika1, razlika2, temp;
    cin >> broj1 >> broj2;
    n1 = broj1;
    n2 = broj2;
    razlika1 = broj1 - broj2;
    temp = broj1;
    broj1 = broj2;
    broj2 = temp;
    razlika2 = broj1 - broj2;
    cout << "Vrednosta na broj1 i broj2 pred zamena na broevite e: " << n1 << "," << n2 << " a razlikata: " << razlika1 << endl;
    cout << "Vrednosta na broj1 i broj2 posle zamena na broevite e: " << broj1 << "," << broj2 << " a razlikata: " << razlika2;
    return 0;
}
