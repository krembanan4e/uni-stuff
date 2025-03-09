//Да се напише програма која за матрица внесена од тастатура ќе ја пресмета
//разликата на збирот на елементите на непарните колони и збирот на елементите на парните редици.
//Матрицата не мора да биде квадратна.

#include<iostream>

using namespace std;

int main() {
    int a[100][100], n, m, zbirNeparniKoloni=0, zbirParniRedici=0;
    cin >> n >> m; //redici koloni

    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            cin >> a[i][j];
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            if (j%2!=0){
                zbirNeparniKoloni+=a[i][j];
            }
            if (i%2==0){
                zbirParniRedici+=a[i][j];
            }
        }
    }

    cout<<"Zbir neparni koloni: "<<zbirNeparniKoloni<<endl;
    cout<<"Zbir parni redici: "<<zbirParniRedici<<endl;
    cout<<"Razlikata e: "<<zbirNeparniKoloni-zbirParniRedici<<endl;

    return 0;
}
