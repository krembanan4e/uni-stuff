//Eден природен e „интересен“ ако неговиот обратен број е делив со неговиот број на цифри. Обратен број е бројот составен од истите цифри, но во обратен редослед 
//(на пример, 653 е обратен број на бројот 356). Од тастатура се внесува природен број n ( n > 9). 
//Да се најде и отпечати најголемиот природен број помал од n кој што е „интересен“. Ако внесениот број не е валиден, да се отпечати соодветна порака (Brojot ne e validen).

#include <iostream>
using namespace std;
int main(){
    int n, i, brCifri, obraten , temp;
    cin >> n;
    if ( n < 9 ){
        cout << "Brojot ne e validen";
    }
    else{
        for ( i = n ; i >= 9 ; i-- ){
            temp = i;
            obraten = 0;
            brCifri = 0;
            while ( temp > 0 ){
                obraten = obraten * 10 + ( temp % 10 );
                temp /= 10;
                brCifri++;
            }

            if ( (obraten % brCifri == 0) && (i < n) ){
                cout << i;
                break;
            }
        }
    }


    return 0;
}
