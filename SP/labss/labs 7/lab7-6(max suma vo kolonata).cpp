// ДА се најдит максимална сума во колона и да се заменат елементите од колоната + сумата
// input          output
// 3 3            1 2 21
// 1 2 3          4 5 24
// 4 5 6          7 8 27
// 7 8 9

#include <iostream>
#include <climits>
using namespace std;

int main(){
    int a[100][100], n, m, kolona, maxSuma=INT_MIN;
    cin>>n>>m;

    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            cin>>a[i][j];
        }
    }

    for (int j=0; j<m; j++){  //naogjanje na max suma
        int suma=0;
        for (int i=0; i<n; i++){
            suma+=a[i][j];
        }
        if (suma>maxSuma){
            maxSuma=suma;
            kolona=j;
        }
    }

    for (int i=0; i<n; i++){  //zamena na elementite od kolonata so max suma
        for (int j=0; j<m; j++){
            if (j==kolona){
                a[i][j]+=maxSuma;
            }
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }


    return 0;
}
