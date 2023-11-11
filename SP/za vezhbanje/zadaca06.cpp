//Да се напише програма во која од стандарден влез прво се внесува еден позитивен цел број z, а потоа последователно се внесуваат парови цели броеви (a, b). 
//Внесувањето на парови цели броеви треба да заврши кога корисникот ќе го внесе парот (0, 0). 
//Треба да се пресмета колку пати z е еднаков на збирот на секој внесен пар броеви a и b, како и колкав процент од вкупниот број внесени парови (a, b) даваат збир z 
//(ЗАБЕЛЕШКА: парот (0, 0) не се зема во предвид при извршувањето на пресметките!).

//input                 output
//100                   Vnesovte 2 parovi od broevi chij zbir e 100
//50 50                 Procentot na parovi so zbir 100 e 50%
//-50 -50
//-99 199
//32 98
//0 0

#include <iostream>
using namespace std;
int main (){
    int z, a, b, zbir = 0, counter = 0, vkupno = 0;
    float procent;
    cin >> z;
    while ( cin >> a >> b ){
        if ( a == 0 && b == 0 ){
            break;
        }
        else {
            vkupno++;    //se zgolemvit brojot na vneseni parovi
            zbir = a + b;  //update na zbirot
            if ( zbir == z ){
                counter++;     //se zgolemvit brojot na parovi chij zbir = z
            }
            procent = (100 / (float) vkupno ) * counter;
        }
    }
    cout << "Vnesovte " << counter << " parovi od broevi chij zbir e " << z << endl;
    cout << "Procentot na parovi so zbir " << z << " e " << procent<<"%";;

    return 0;
}
