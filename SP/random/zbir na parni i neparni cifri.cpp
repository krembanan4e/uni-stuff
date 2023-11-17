//zbir na parni cifri i zbir na neparni cifri od broj

#include <iostream>
using namespace std;
int main(){
    int a, zbirParni = 0, zbirNeparni = 0;
    cin >> a;
    int temp = a;
    while ( temp != 0 ){
        int cifra = temp % 10;
        if ( cifra % 2 == 0 ){
            zbirParni += cifra;
        }
        else {
            zbirNeparni += cifra;
        }
        temp /= 10;
    }
    cout << "Zbirot na parnite cifri od brojot " << a << " e " << zbirParni << endl;
    cout << "Zbirot na neparnite cifri od brojot " << a << " e " << zbirNeparni << endl;

    
    return 0;
}
