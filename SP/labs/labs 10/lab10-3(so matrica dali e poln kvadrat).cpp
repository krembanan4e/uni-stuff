/*
A tretata beshe kvadratna matrica.
I gledash prviot elemen na glavnata i sporednata dali koga kje se soberat kje pravat broj shto e poln kvadrat pr.
Ako prvite elementi se 1 i 8 koga kje gi soberesh se dobiva 9 t.e.
3*3 i taka do kraj site elementi na dijagonalite da gi proveri
*/

#include <iostream>
#include <cstring>
#include <cctype>
#include <cmath>
using namespace std;

int main() {
    int n, matrix[100][100], glavna[100], sporedna[100];
    cin>>n;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin>>matrix[i][j];
        }
    }

    int k=0, z=0; //brojaci za dijagonalite

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if(i==j){
                glavna[k++]=matrix[i][j];
            }
        }
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i+j==n-1){
                sporedna[z++]=matrix[i][j];
            }
        }
    }

    for (int i = 0; i < k; ++i) {
       int suma=0;
       suma = glavna[i] + sporedna[i];
       int koren = sqrt(suma);
       if ( pow(koren, 2) == suma ){
           cout<<suma<<" e poln kvadrat."<<endl;
       }
       else{
           cout<<suma<<" ne e poln kvadrat."<<endl;
       }
    }

    return 0;
}
