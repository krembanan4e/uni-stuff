/* Напишете програма која чита два природни броја, почеток и крај, од стандарден влез.
 * Програмата треба да го отпечати најголемиот палиндром во опсегот [почеток,крај].
 * Решението треба да се направи со 3 функции:
 * - reverse (int number) - функција за пресметување на превртен број
 * - isPalindrom (int number) - функција која ќе провери дали број се чита исто одлево надесно и обратно
 * - findLargest (int start, int end) - Функција која ќе го најде најголемиот палиндром во опсегот [start,end]
 * input        output
 * 10 50        Largest Palindromic Number: 44 */

#include <iostream>

using namespace std;

int reverse(int number) {
    int prevrten = 0;
    while (number != 0) {
        prevrten = prevrten * 10 + (number % 10);
        number /= 10;
    }
    return prevrten;
}

bool isPalindrom(int number) {
    int prevrtenBroj = reverse(number);
    if (prevrtenBroj == number) {
        return true;
    }
    else {
        return false;
    }
}

int findLargest(int start, int end) {
    int i;
    for (i = end; i >= start; i--) {
        if (isPalindrom(i)) {
            break;
        }
    }
    return i;
}

int main() {
    int pocetok, kraj;
    cin >> pocetok >> kraj;
    cout << "Largest Palindromic Number: " << findLargest(pocetok, kraj) << endl;

    return 0;
}
