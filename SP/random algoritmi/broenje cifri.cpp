//broenje na cifri

#include <iostream>
using namespace std;
int main(){
    int n, brCifri = 0;
    cin >> n;
    int temp = n;
    while ( temp != 0 ){
        brCifri++;
        temp /= 10;
    }
    cout << "Brojot " << n << " ima " << brCifri << " cifri";

    return 0;
}
