//Да се напише програма каде од тастатура ќе се внесе цена на производ,
//број на рати на кои се исплаќа и камата (каматата е број изразен во проценти од 0 до 100).
//Програмата треба да го испечати износот на ратата и вкупната сума што ќе се исплати за производот
//ПОМОШ: Пресметајте ја целата сума, па потоа ратата.

#include <iostream>
using namespace std;
int main() {
    float cenaNaProizvod, kamata, rata, vkupnaSuma;
    int brojNaRati;
    cout << "Vnesi cena na proizvod: " ;
    cin >> cenaNaProizvod;
    cout << "Vnesi broj na rati na koj se isplakja: " ;
    cin >> brojNaRati;
    cout << "Vnesi kamata: ";
    cin >> kamata;
    vkupnaSuma = cenaNaProizvod * ( 1 + kamata/100 );
    rata = vkupnaSuma / brojNaRati;
    cout << "Edna rata iznesuva " << rata << endl;
    cout << "Vkupnata suma iznesuva " << vkupnaSuma << endl;

    return 0;
}
