//Да се внесат вредности на две катети на правоаголен триаголник.
//Ваша задача е да ги пресметате и испечатите квадратот на хипотенузата и плоштината на триаголникот.
// input:           output:
// 2 2              8
//                  2

#include <iostream>
#include<cmath>
using namespace std;
int main() {
    float kateta1;
    float kateta2;
    double hipotenuza;
    double plostina;

    cin >> kateta1;
    cin >> kateta2;

    hipotenuza = sqrt ((kateta1*kateta1) + (kateta2*kateta2));
    plostina = 0.5 * kateta1 * kateta2;

    cout << hipotenuza * hipotenuza << endl;
    cout << plostina;
    return 0;
}
