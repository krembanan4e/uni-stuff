/* Напишете програма која чита два природни броја, почеток и крај, од стандаредн влез.
 * Потоа програмата треба да ги најде и отпечати палиндромите во опсегот [почеток,крај].
 * Палиндром се дефинира како број што останува ист и кога неговите цифри се во обратен редослед.
 * Ваша задача е да ги најдете најмалите и најголемите палиндроми во даденито опсег */

#include <iostream>
using namespace std;
int main(){
    int a, b;
    cin >> a >> b;
    for ( int i = a; i <= b; i++){
        int obratenA = 0;
        int temp = i;
        while ( temp != 0 ){
            obratenA = obratenA * 10 + temp%10;
            temp /= 10;
        }
        if ( obratenA == i ){
            cout << "Smallest Palindromic Number: " << i << endl;
            break;
        }

    }
    for ( int i = b; i >= a; i-- ){
        int obratenB = 0;
        int temp = i;
        while ( temp != 0 ){
            obratenB = obratenB * 10 + temp%10;
            temp /= 10;
        }
        if ( obratenB == i ){
            cout << "Largest Palindromic Number: " << i << endl;
            break;
        }
        
    }


    return 0;
}
