//Да се прочита број N од тастатура. 
//Да се дефинира функција form(int n) што ќе испечати форма од ѕвезди како што е прикажано на сликата.
//За да се освојат сите поени од вежбата, потребно е функцијата form да биде рекурзивна.

// input     output
// 5         *****
//           ****
//           ***
//           **
//           *

#include <iostream>
using namespace std;

//ova pecatit samo za 5 *****, za 4 ****, za 3 *** ...
void pecati (int n){
    if (n==0)
        return;
    cout << "*";
    pecati (n-1);
}

//kolku pati da vrtit funkcijata
void form (int n){
    if (n==0)
        return;
    pecati(n);
    cout << endl;
    form (n-1);
}

int main(){
   int n;
   cin >> n;
   form(n);

    return 0;
}
