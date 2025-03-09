//Да се напише програма која за петцифрен број внесен од стандарден влез ќе ја пресмета сумата на цифрите на парните и непарните позиции соодветно.
//Напомена: Последната цифра во бројот се наоѓа на 0-та позиција. 
//Појаснување: За бројот 54321 цифрата на 0-та позиција е 1, додека цифрата на 4-та позиција е 5.
// input:           output:
// 54321            Sumata na cifrite na parnite pozicii e 9
//                  Sumata na cifrite na neparnite pozicii e 6

#include <iostream>
using namespace std;
int main() {
    int n, n0, n1, n2, n3, n4, sumP = 0, sumN = 0;
    cin >> n;
    n0 = n % 10;
    n1 = n / 10 % 10;
    n2 = n / 100 % 10;
    n3 = n / 1000 % 10;
    n4 = n / 10000;
    sumP = n0 + n2 + n4;
    sumN = n1 + n3;
    cout << "Sumata na cifrite na parnite pozicii e " << sumP << endl;
    cout << "Sumata na cifrite na neparnite pozicii e " << sumN;


    return 0;
}
