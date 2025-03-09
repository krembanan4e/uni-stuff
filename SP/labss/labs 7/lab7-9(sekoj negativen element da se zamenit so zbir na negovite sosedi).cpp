//Секој негативен елемент да се заменит со збирот на неговите соседи (голе долу лево десно од него)

// a[i][j+1] - desno
// a[i][j-1] - levo
// a[i+1][j] - dolu
// a[i-1][j] - gore

// 5
// 1 2 -3 4 5  ------>  -3 = 4+2+2 = 8      ------>  1 2 8 4 5
// -2 1 2 3 2  ------>  -2 = 1+1+1 = 3      ------>  3 1 2 3 2
// 1 2 3 -4 5  ------>  -4 = 3+3+5+6 = 17   ------>  1 2 3 17 5
// 3 4 2 6 -2  ------>  -2 = 5+6+9 = 20     ------>  3 4 2 6 20
// 1 2 3 -1 9  ------>  -2 = 3+6+9 = 18     ------>  1 2 3 18 9

#include <iostream>

using namespace std;

int main(){
    int n, a[100][100];
    cin>>n;

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if (a[i][j]<0){
                if (i==0){ //aku elementot e vo prva redica
                    int suma=0;
                    suma = a[i][j-1] + a[i][j+1] + a[i+1][j];
                    a[i][j] = suma;
                }
                else if (i==n){  //aku elementot e vo n-ta redica
                    int suma=0;
                    suma = a[i][j-1] + a[i][j+1] + a[i-1][j];
                    a[i][j] = suma;
                }
                else if (j==0){  //aku elementot e vo prva kolona
                    int suma=0;
                    suma = a[i][j+1] + a[i+1][j] + a[i-1][j];
                    a[i][j] = suma;
                }
                else if (j==n){  //aku elementot e vo n-ta kolona
                    int suma=0;
                    suma = a[i][j-1] + a[i+1][j] + a[i-1][j];
                    a[i][j] = suma;
                }
                else { //aku elementot e negde na sredina
                    int suma=0;
                    suma = a[i][j-1] + a[i][j+1] + a[i+1][j] + a[i-1][j];
                    a[i][j] = suma;
                }
            }
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }


    return 0;
}
