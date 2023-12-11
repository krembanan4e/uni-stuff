//Од стандарден влез се вчитува квадратна матрица со n редици и колони. Прво се вчитува бројот n, па n*n елементите на матрицата.
//Вашата задача е да ги заменете сите парни елементи во матрицата со збирот на нивните индекси на редови и колони.

#include <iostream>
using namespace std;

int main(){
    int a[100][100], n;
    cin>>n;

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if(a[i][j]%2==0){
                a[i][j]=i+j;
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
