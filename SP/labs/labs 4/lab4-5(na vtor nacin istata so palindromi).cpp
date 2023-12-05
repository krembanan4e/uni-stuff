/* Напишете програма која чита два природни броја, почеток и крај, од стандаредн влез.
 * Потоа програмата треба да ги најде и отпечати палиндромите во опсегот [почеток,крај].
 * Палиндром се дефинира како број што останува ист и кога неговите цифри се во обратен редослед.
 * Ваша задача е да ги најдете најмалите и најголемите палиндроми во дадениoт опсег */

#include <iostream>
using namespace std;
int main(){
    int a, b, smallest, largest;
    cin >> a >> b;
    smallest = b;
    largest = 0;
    for ( int i = a; i <= b; i++ ){
        int reverse = 0;
        int temp = i;
        while ( temp != 0 ){
            reverse = reverse * 10 + temp%10;
            temp /= 10;
        }
        if ( reverse == i ){
            if ( reverse < smallest ){
                smallest = reverse;
            }
            else if ( reverse > largest ){
                largest = reverse;
            }
        }

    }
    cout << "Smallest Palindromic Number: " << smallest << endl;
    cout << "Largest Palindromic Number: " << largest << endl;


    return 0;
}
