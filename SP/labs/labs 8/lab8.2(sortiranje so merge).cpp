//Од стандарден влез се читаат соодветно низа со М елементи и низа со N елементи.
//Ваша задача е да ги споите двете низи во трета сортирана низа по растечки редослед.
//Се внесува М па должината на првата низа, па N, па втората низа.
//Напомена: Елементите во двете низи кои се внесуваат се сортирани.
//Максималната должина на низите е 100. Не смеете да користите алгоритам за сортирање.

// input         output
// 5             1 2 4 5 6 8 9 10 15
// 1 4 6 9 15
// 4
// 2 5 8 10

#include <iostream>
using namespace std;

int main(){
    int m, n, a[100], b[100], c[100], j=0;

    cin>>m;
    for (int i=0; i<m; i++){
        cin>>a[i];
    }

    cin>>n;
    for (int i=0; i<n; i++){
        cin>>b[i];
    }

    int i;
    for (i=0; i<m && i<n; i++){
        if (a[i]<b[i]){
            c[j]=a[i];
            j++;
            c[j]=b[i];
            j++;
        }
        else {
            c[j]=b[i];
            j++;
            c[j]=a[i];
            j++;
        }
    }

    while (i<m){
        c[j]=a[i];
        j++;
        i++;
    }

    while (i<n){
        c[j]=b[i];
        j++;
        i++;
    }

    for (int i=0; i<j; i++){
        cout<<c[i]<<" ";
    }


    return 0;
}
