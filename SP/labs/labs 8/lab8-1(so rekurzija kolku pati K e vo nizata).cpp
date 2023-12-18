//Да се напише рекурзивна функција која на излез ќе испечати број на појавувања на даден број К во низа од N елементи
//N се чита од тастатура, како и низата. Доколку низата го нема елементот К, да се испечати 0

// input         output        input            output
// 5             2             7                3
// 1 2 3 1 4                   2 7 1 8 2 8 8
// 1                           8


#include <iostream>
using namespace std;

int kolkuPati(int a[], int n, int k){
    if (n==-1)
        return 0;
    else{
        if (a[n-1]==k){
            return 1 + kolkuPati(a, n-1, k);
        }
        else {
            return kolkuPati(a,n-1,k);
        }
    }
}

int main(){
   int n, k, a[100];
   cin>>n;
   for (int i=0; i<n; i++){
       cin>>a[i];
   }
   cin>>k;

   cout<<kolkuPati(a,n,k);

   return 0;
}
