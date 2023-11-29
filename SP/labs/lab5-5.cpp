/* Од тастатура се внесуваат броеви m,n,p. Да се најдат првите 10 бореви поголеми од m кои ја содржат цифрата n p-пати.
 * Решението да се имплементира со помош на функција countOccurence (int number, int digit) која прима 2 аргументи,
 * број и цифра, а како резултат враќа колку пати цифрата digit се јавува во бројот number.
 * input           output
 * 50 2 3          222 1222 2022 2122 2202 2212 2220 2221 2223 2224 */

#include <iostream>

using namespace std;

int countOccurence(int number, int digit) {
    int counter = 0;
    while (number != 0) {
        if ((number % 10) == digit) {
            counter++;
        }
        number /= 10;
    }
    return counter;
}

void pecatiDesetBroja(int broj, int cifra, int brojac) {
    int counter = 0;
    for (broj++; counter <= 9; broj++){
        if (countOccurence(broj, cifra) == brojac) {
            cout << broj << endl;
            counter++;
        }
    }
}

int main(){
    int m,n,p;
    cin>>m>>n>>p;
    pecatiDesetBroja(m,n,p);
    return 0;
}
