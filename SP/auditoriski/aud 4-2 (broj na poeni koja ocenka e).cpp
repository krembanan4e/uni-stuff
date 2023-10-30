//Да се напише програма што за внесен број на поени од испит ќе генерира соодветна оценка според следната табела:
// 0-50   5ka
// 51-60  6ka
// 61-70  7ka
// 71-80  8ka
// 81-90  9ka
// 91-100 10ka

#include <iostream>
using namespace std;
int main() {
    int poeni;
    cin >> poeni;
    if ( poeni >= 0 && poeni <=100 ){
        if ( poeni <= 50 ){
            cout << "5ka" << endl;
        }
        else if ( poeni <= 60 ){
            cout << "6ka" << endl;
        }
        else if ( poeni <= 70 ){
            cout << "7ka" << endl;
        }
        else if ( poeni <= 80 ){
            cout << "8ka" << endl;
        }
        else if ( poeni <= 90 ){
            cout << "9ka" << endl;
        }
        else if ( poeni <= 100 ){
            cout << "10ka" << endl;
        }

    }
    else {
        cout << "Nevaliden broj poeni!" << endl;
    }



    return 0;
}
