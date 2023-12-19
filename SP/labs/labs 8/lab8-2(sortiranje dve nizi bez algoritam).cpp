//Од стандарден влез се читаат соодветно низа со М елементи и низа со N елементи.
//Ваша задача е да ги споите двете низи во трета сортирана низа по растечки редослед.
//Се внесува М па должината на првата низа, па N, па втората низа.
//Напомена: Елементите во двете низи кои се внесуваат се сортирани.
//Максималната должина на низите е 100. Не смеете да користите алгоритам за сортирање.

// input         output                         input                output
// 5             1 2 4 5 6 8 9 10 15            4                    1 3 4 5 7 8 9
// 1 4 6 9 15                                   1 3 7 9 
// 4                                            3 
// 2 5 8 10                                     4 5 8

#include <iostream>
using namespace std;

int main(){
    int n, m, a[100], b[100], c[100], k=0;

    cin>>n;
    for(int i=0; i<n; i++){
        cin>>a[i];
    }

    cin>>m;
    for(int i=0; i<m; i++){
        cin>>b[i];
    }

    int i, j;
    for(i=0, j=0; i<n;){
        if (a[i]<b[j]){
            c[k]=a[i];
            k++;
            i++;
        }
        else {
            c[k]=b[j];
            k++;
            j++;
        }
    }

    while(i<n){
        c[k]=a[i];
        k++;
    }

    while(i<m){
        c[k]=b[i];
        k++;
    }

    for(int i=0; i<n+m; i++){
        cout<<c[i]<<" ";
    }
    
    return 0;
}
