//Да се напише програма која за матрица внесена од тастатура ќе ги замени
//елементите од главната дијагонала со разликата од максималниот и минималниот елемент во матрицата.
//Резултантната матрица да се испечати на екран.

// 1 1 1 1  --->  0 1 1 1
// 1 1 1 1        1 0 1 1 
// 1 1 1 1        1 1 0 1 
// 1 1 1 1        1 1 1 0

#include<iostream>

using namespace std;

int main() {
    int a[100][100], n, max, min;
    cin >> n; //redici koloni

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin >> a[i][j];
        }
    }
    max=min=a[0][0];

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if(a[i][j]>max){
                max=a[i][j];
            }
            if(a[i][j]<min){
                min=a[i][j];
            }
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if (i==j){
            a[i][j]=max-min;
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
