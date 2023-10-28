//Да се напише програма која чита знак од тастатура и во зависнот од тоа
//дали е мала или голема буква печати 1 или 0, соодветно.
//ПОМОШ: Користете логички и релациски оператори за тестирање на ASCII вредноста на знакот.
//Бонус: Направете проверка дали знакот е цифра

#include <iostream>
using namespace std;
int main() {
    char ch;
    int rezultat;
    cout << "Vnesi znak " << endl;
    cin >> ch;
    if ((ch >= '0') && (ch <= '9')){
        cout << "Vnesovte cifra ";
    }
    else {
        rezultat = (ch >= 'a') && (ch <= 'z');
        cout << rezultat;
    }
    return 0;
}
