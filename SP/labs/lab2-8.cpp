//input             output
//100               80
//200
//600
//1

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int gramJabolka, gramMalini, gramBanani, karticka;
    float cenaJabolka = 30, cenaMalini = 50, cenaBanani = 40;
    float sumaJabolka = 0, sumaMalini = 0, sumaBanani = 0, vkupnaSuma = 0;

    cin >> gramJabolka >> gramMalini >> gramBanani;
    cin >> karticka;


    if ( gramJabolka == 100 ) {
        vkupnaSuma += cenaJabolka;
    }
    else if ( gramJabolka > 100 ){

        if ( gramJabolka == 200 ){
            sumaJabolka = gramJabolka * 30 / 100;
            sumaJabolka -= sumaJabolka * 30 / 100;
        }

        else if ( gramJabolka >= 500 ){
            sumaJabolka = gramJabolka * 30 / 100;
            sumaJabolka -= sumaJabolka * 50 / 100;
        }
        else {
            sumaJabolka += (cenaJabolka * (gramJabolka / 100 ));
        }
        vkupnaSuma += sumaJabolka;
    }



    if ( gramMalini == 100 ) {
        vkupnaSuma += cenaMalini;
    }
    else if ( gramMalini > 100 ){

        if ( gramMalini == 200 ){
            sumaMalini = gramMalini * 50 / 100;
            sumaMalini -= sumaMalini * 30 / 100;
        }

        else if ( gramMalini >= 500 ){
            sumaMalini = gramMalini * 50 / 100;
            sumaMalini -= sumaMalini * 50 / 100;
        }

        else {
            sumaMalini+= ( cenaMalini * ( gramMalini / 100 ));
        }
        vkupnaSuma += sumaMalini;
    }



    if ( gramBanani == 100 ) {
        vkupnaSuma += cenaBanani;
    }
    else if ( gramBanani > 100 ){

        if ( gramBanani == 200 ){
            sumaBanani = gramBanani * 40 / 100;
            sumaBanani -= sumaBanani * 30 / 100;
        }

        else if ( gramBanani >= 500 ){
            sumaBanani = gramBanani * 40 / 100;
            sumaBanani -= sumaBanani * 50 / 100;
        }
        else {
            sumaBanani += (cenaBanani * (gramBanani / 100 ));
        }
        vkupnaSuma += sumaBanani;
    }
    cout << vkupnaSuma<< endl;

    if ( vkupnaSuma > 140 ){
        if ( karticka == 1 ){
            cout<<"sumataaaaaaaaa e:"<<vkupnaSuma<<endl;
            cout << vkupnaSuma - 140;

        }
        else{
            cout << "ne treba da doplati ";
        }
    }



    return 0;
}
