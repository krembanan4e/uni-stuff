// input
// testing this example using my array
// output
// gnitset this elpmaxe gnisu my yarra

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int main() {
    char niza[1000], zbor[1000];
    cin.getline(niza,1000);
    int i, j;

    for (i = 0, j=0; i <= strlen(niza); ++i) {
        
        //vo 'zbor' redi gi bukvite dur dojt do prazno mesto ili \0
        if (!isspace(niza[i]) && niza[i]!='\0'){
            zbor[j++]=niza[i];
        }
            
        //aku dojt do prazno mesto
        else{

            //zatvori ja nizata
            zbor[j]='\0';

            //aku dolzinata na zborot e neparna prevrti go zborot
            if (strlen(zbor) % 2 != 0){
                for (j= strlen(zbor); j>=0 ; j--) {
                    cout << zbor[j-1];
                }
            }

            //aku dolzinata na zborot e parna pecati go zborot
            else {
                for (j=0; j<= strlen(zbor) ; j++) {
                    cout << zbor[j];
                }
            }

            j=0;
        }
    }


    return 0;
}
