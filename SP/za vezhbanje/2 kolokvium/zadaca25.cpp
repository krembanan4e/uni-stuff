//Од тастатура се чита број n а потоа и низа од n елементи. \
//Потребно е низата да се трансформира така што максималниот и минималниот елемент
//ќе си ги заменат местата, а на останатите елементи ќе им се додаде разликата
//меѓу максималниот и минималниот елемент.
//Самата трансформација треба да се изврши во функцијата void transform(int *arr, int n)

// input         output
// 4             4 5 6 1
// 1 2 3 4


#include <iostream>
using namespace std;

void transform(int *arr, int n){
    int max, min;
    max=min=arr[0];
    for (int i=0; i<n; i++){
        if (arr[i]>max){
            max=arr[i];
        }
        if (arr[i]<min){
            min=arr[i];
        }
    }
    for (int i=0; i<n; i++){
        if (arr[i]==max){
           arr[i]=min;
            continue;
        }
        if (arr[i]==min){
            arr[i]=max;
            continue;
        }
        arr[i]+=max-min;
    }
}

int main(){
   int n, a[100];
   cin>>n;

   for (int i=0; i<n; i++){
       cin>>a[i];
   }

   transform(a, n);

   for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
   }

   return 0;
}
