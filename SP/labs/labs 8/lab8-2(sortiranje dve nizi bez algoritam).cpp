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

//Најдолу е објаснато решениево

#include <iostream>
using namespace std;

int main(){
   int m, n, a[100], b[100], c[100];
   cin>>m;
   for (int i=0; i<m; i++){
       cin>>a[i];
   }
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>b[i];
    }

    if (m>n){ //aku prvata niza e podolga
        for (int i=0; i<n; i++){
            if (a[i]<b[i]){
                cout<<a[i]<<" "<<b[i]<<" ";
            }
            else {
                cout<<b[i]<<" "<<a[i]<<" ";
            }
        }
        for (int i=n; i<m; i++){
            cout<<a[i]<<" ";
        }
    }

    else if (n>m){ //aku vtorata niza e podolga
        for (int i=0; i<m; i++){
            if (a[i]<b[i]){
                cout<<a[i]<<" "<<b[i]<<" ";
            }
            else {
                cout<<b[i]<<" "<<a[i]<<" ";
            }
        }
        for (int i=m; i<n; i++){
            cout<<b[i]<<" ";
        }
    }

  else { //aku nizite se so ista dolzina
        for (int i=0; i<m; i++){
            if (a[i]<b[i]){
                cout<<a[i]<<" "<<b[i]<<" ";
            }
            else {
                cout<<b[i]<<" "<<a[i]<<" ";
            }
        }
    }


   return 0;
}


// m = 5   a = 1 4 6 9 15
// n = 4   b = 2 5 8 10
// se sporedvat eden element od prvata i eden od vtorata niza, se dur stignit do dolzinata na pokratkata niza
// m > n  --->  1<2 (pecati 1 2), 4<5 (pecati 4 5), 6<8 (pecati 6 8), 9<10 (pecati 9 10) 
// vtoriot for za elementite sho ostanaja vo podolgata niza da se ispecatet (pocvit od dolzinata na pokratkata, do dolzinata na podolgata, gi pecatit elementite)


