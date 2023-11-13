//Од стандарден влез се внесува даден број Х, а потоа се внесуваат броеви додека не се внесе нешто различно од број.
//За секој од броевите да се провери дали неговиот број на цифри е еднаков со бројот на цифри на Х,и доколку условот е исполет да се испечати.

//input               output
//1234                3745
//451                 6832
//3745
//121
//0
//6832
//#

#include <iostream>
using namespace std;
int main(){
    int x, brCifriX = 0, n, brCifriN = 0;
    cin >> x;
    while ( x != 0 ){
        x /= 10;
        brCifriX++;
    }
    while ( cin >> n ){
        brCifriN = 0;
        int temp = n;
        while ( temp != 0 ){
            temp /= 10;
            brCifriN++;
        }
        if ( brCifriN == brCifriX ){
            cout << n << endl;
        }
    }

    return 0;
}
