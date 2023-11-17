//sobiranje cifri na parni i na neparni pozicii
//ako pozicijata na najznacajnata cifra e 0.
//NAJZNACAJNA E NAJLEVO PRVATA CIFRA

//pozicii: 012345
//   broj: 151234

#include <iostream>
using namespace std;
int main(){
    int n, zbirCifri = 0, zbirParniPozicii = 0, zbirNeparniPozicii = 0;
    cin >> n;

    int temp = n;
    int prevrten = 0;
    while ( temp != 0 ){
        zbirCifri ++;
        prevrten = prevrten * 10 + temp%10;
        temp /= 10;
    }

    for ( int i = 0; i < zbirCifri; i++ ){
        int cifra = prevrten % 10;
        if ( i % 2 == 0 ){
            zbirParniPozicii += cifra;
        }
        else {
            zbirNeparniPozicii += cifra;
        }
        prevrten /= 10;
    }

    cout << "Zbirot na cifrite koi se na parna pozicija vo brojot " << n << " e " << zbirParniPozicii << endl;
    cout << "Zbirot na cifrite koi se na neparna pozicija vo brojot " << n << " e " << zbirNeparniPozicii << endl;


    return 0;
}
