//Од стандарден влез се вчитува квадратна матрица со n редици и колони. Прво се внесува n, па n x n  елементите на матрицата.
//Напишете програма којa определува дали дадена матрица е магичен квадрат. Магичен квадрат е квадратна матрица каде што
//збирот на елементите во секој ред и колона е ист. Доколку матрицата е „Магичен квадрат“ испечати "True", и да се променат
//елементите од главната и споредната дијагонала со збирот од елемените што е ист за секоја редица и колона. Во спротивно печати "False"

#include <iostream>
using namespace std;

int main(){
    int a[100][100], n, suma, sumaR, sumaK;
    int daliMagicen=1;
    cin>>n;

    for (int i=0; i<n; i++){  //vnesi matrica
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    for (int i=0; i<1; i++){  //edna pocetna suma od prvata redica
        suma=0;
        for (int j=0; j<n; j++){
            suma+=a[i][j];
        }
    }
 
    for (int i=0; i<1; i++){  //proverka dali sumata e ista so site sumi na site redici
        daliMagicen=1;
        sumaR=0;
        for (int j=0; j<n; j++){
            sumaR+=a[i][j];
        }
        if (suma!=sumaR){
            daliMagicen=0;
            break;
        }
    }

    for (int j=0; j<1; j++){  //proverka dali sumata e ista so site sumi na site koloni
        daliMagicen=1;
        sumaK=0;
        for (int i=0; i<n; i++){
            sumaK+=a[i][j];
        }
        if (suma!=sumaK){
            daliMagicen=0;
            break;
        }
    }

    if (daliMagicen==0){  //aku ne e magicen kvadrat
        cout<<"False"<<endl;
    }
    else{            
        cout<<"True"<<endl;    //aku e magicen kvadrat
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if ((i==j)|| (i+j==n-1)){  //zamena na elementi od glavna i sporedna dijagonala
                    a[i][j]=suma;
                }
                cout<<a[i][j]<<" ";
            }
            cout<<endl;
        }
    }


    return 0;
}
