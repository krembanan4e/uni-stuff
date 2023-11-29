/*Write a program that will read n pairs od natural numbers (n is first, than the n pairs)
 * It is necessary to check for each read pair of numbers, whether all the digits od the first number
 * appear in the second number. If this condition is met, the program will print YES, otherwise NO.
 * Checking whether all the digits of one number appear in the second number should be done with the function appears(int first, int second)
 * input                output
 * 4                    NO
 * 421988 4111992       NO
 * 985 85643            NO
 * 8546 1235            YES
 * 3322 123  */

#include <iostream>

using namespace std;

void appear(int first, int second) {
    int tempSecond, cifra1, cifra2;
    while (first != 0) {
        bool najde = true;
        cifra1 = first % 10;
        tempSecond = second;
        while (tempSecond != 0) {
            cifra2 = tempSecond % 10;
            if (cifra2 == cifra1) {
                break;
            }
            else {
                tempSecond /= 10;
            }
            if (tempSecond == 0) {
                najde = false;
            }

        }
        if (!najde) {
            cout << "NO" << endl;
            break;
        }
        first /= 10;
        if (first == 0) {
            cout << "YES" << endl;
            break;
        }
    }
}

int main() {
    int n, a, b;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a >> b;
        appear(a, b);
    }
    return 0;
}
