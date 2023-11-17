//prevrtuvanje na broj

#include <iostream>
using namespace std;
int main(){
    int a;
    cin >> a;
    int temp = a;
    int prevrten = 0;
    while ( temp != 0 ){
        prevrten = prevrten * 10 + temp%10;
        temp /= 10;
    }
    cout << "Brojot " << a << " prevrten e: " << prevrten << endl;


    return 0;
}
