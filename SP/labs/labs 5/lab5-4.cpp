/* Да се дефинираат и имплементираат следните функции:
 * int obratenBroj (int broj) - функција која што прима 1 аргумент broj и како резултат го враќа обратниот број.
 * int sumaCifri (int broj) - функција којашто прима 1 аргумент broj и како резултат ја враќа сумата на цифрите на тој број.
 * void pecatiVoInterval (int a, int b) - функција што прима 2 аргументи a и b, но не враќа никаков резултат.
 * Целта на оваа функција е само да ги испечати сите броеви во интервалот од а до б (вклучувајќи ги и нив) за којшто важи:
 * бројот Х е делив со обратниот број од збирот на цифрите на бројот Х. Да се искористат првите 2 функции за имплементирање
 * на оваа функција. Пример: 922 збир на цифри: 20, обратен: 2, следи 992 е делив со 2 па се печати овој број
 * input                 output
 * 10000 11000           10000 10002 10008 10009 10010 10011 10012 10014 .... */

#include <iostream>

using namespace std;

int obratenBroj(int broj) {
    int obraten = 0;
    while (broj != 0) {
        obraten = obraten * 10 + (broj % 10);
        broj /= 10;
    }
    return obraten;
}

int sumaCifri(int broj) {
    int suma = 0;
    while (broj != 0) {
        suma += broj % 10;
        broj /= 10;
    }
    return suma;
}

void pecatiVoInterval(int a, int b) {
    for (int i = a; i <= b; i++) {
        if (i % (obratenBroj(sumaCifri(i))) == 0) {
            cout << i << endl;
        }
    }
}

int main() {
    int pocetok, kraj;
    cin >> pocetok >> kraj;
    pecatiVoInterval (pocetok, kraj);

    return 0;
}
