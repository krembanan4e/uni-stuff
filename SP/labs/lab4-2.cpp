//Да се напише програма која ќе прочита два природни броја.
//Програмата треба да провери дали цифрите на непарна позиција од првиот број се на парна позиција во вториот број.
//Ако овој услов е исполнет, програмата печати DA, во спротивно печати NE
//Првата цифра се наоѓа на 0та позиција почнувајќи од лево.

//input                   output
//0123456 - pozicii
//1234567   654321        DA
//13579     97531         NE

#include <iostream>
using namespace std;
int main(){
    int a, b, tempA, tempB, brCifriA = 0, brCifriB = 0, cifraA0, delenje;
    cin >> a >> b;
    tempA = a; tempB = b;
    int flag = 1;
    
    while ( tempA != 0 ){
        tempA /= 10;
        brCifriA++;
    }
    while ( tempB != 0 ){
        tempB /= 10;
        brCifriB++;
    }

    for ( int i = 1; i < brCifriA ; i++ ){
        delenje *= 10;
    }
    cifraA0 = a / delenje;

    if (brCifriB % 2 == 0){
        while ( b != 0 ){
            flag = 1;
            b /= 10;
            if (cifraA0 == b % 10 ){
                flag = 0;
                break;
            }
            b /= 10;
        }
    }
    
    else if (brCifriB % 2 != 0){
        while ( b != 0 ){
            flag = 1;
            if (cifraA0 == b % 10 ){
                flag = 0;
                break;
            }
            b /= 100;
        }
    }
    

    if ( flag == 0 ){
        cout << "NE";
    }
    else {
        cout << "DA";
    }
    

    return 0;
}
