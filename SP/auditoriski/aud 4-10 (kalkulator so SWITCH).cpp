//Да се напише програма што ќе претставува едноставен калкулатор. Во програмата се вчитуваат два броја и оператор во формат:
//broj1 operator broj2
//По извршената операција во зависност од операторот, се печати резултатот во формат:
//broj1 operator broj2 = rezultat

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int br1, br2;
    char operacija;
    cout << "Vnesi broj" << endl; cin >> br1;
    cout << "Vnesi operator" << endl; cin >> operacija;
    cout << "Vnesi broj" << endl; cin >> br2;
    switch (operacija){
        case '+': cout << br1 << " " << operacija << " " << br2 << " = " << br1+br2; break;
        // ili int rezultat = br1+br2 pa posle dolu cout ova
        case '-': cout << br1 << " " << operacija << " " << br2 << " = " << br1-br2; break;
        case '*': cout << br1 << " " << operacija << " " << br2 << " = " << br1*br2; break;
        case '/':
            if ( br2 != 0 ){
                cout << br1 << " " << operacija << " " << br2 << " = " << (float) br1/br2; break;
            }
            else {
                cout << "Ne se deli so nula!"; break;
            }
    }


    return 0;
}
