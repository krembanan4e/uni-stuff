//sobiranje cifri na parni i na neparni pozicii
//ako pozicijata na najmalku znacajnata cifra e 0.
//NAJMALKU ZNACAJNA E NAJDESNO NA POZICIJA EDINICI

//pozicii:  543210
//   broj:  214129

#include <iostream>
using namespace std;
int main(){
    int n, zbirCifri = 0, zbirParniPozicii = 0, zbirNeparniPozicii = 0;
    cin >> n;
    
    int temp = n;
    while ( temp != 0 ){
        zbirCifri ++;
        temp /= 10;
    }
    
    int broj = n;
    for ( int i = 0; i < zbirCifri; i++ ){
        int cifra = broj % 10;
        if ( i % 2 == 0 ){
            zbirParniPozicii += cifra;
        }
        else {
            zbirNeparniPozicii += cifra;
        }
        broj /= 10;
    }
    
    cout << "Zbirot na cifrite koi se na parna pozicija vo brojot " << n << " e " << zbirParniPozicii << endl;
    cout << "Zbirot na cifrite koi se na neparna pozicija vo brojot " << n << " e " << zbirNeparniPozicii << endl;

    return 0;
}
