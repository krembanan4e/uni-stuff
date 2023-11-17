//naogjanje na deliteli na broj
//zbir i counter na delitelite na broj

#include <iostream>
using namespace std;
int main(){
    int n, zbirDeliteli = 0, kolkuDeliteli = 0;
    cin >> n;
    cout << "Deliteli na " << n << " se: ";
    for ( int i = 1 ; i <= n/2; i++ ){
        if ( n % i == 0 ){
            cout << i << " ";
            zbirDeliteli += i;
            kolkuDeliteli++;
        }
    }
    cout << endl;
    cout << "Zbirot na delitelite na " << n << " e: " << zbirDeliteli << endl;
    cout << "Brojot " << n << " ima " << kolkuDeliteli << " deliteli." << endl;

    return 0;
}
