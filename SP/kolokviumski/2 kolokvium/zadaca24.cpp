//Да се напише програма во која со помошна функција што користи покажувачи,
//елементите на низата ќе се променат така што секој елемент ќе биде еднаков на
//збирот од него самиот и неговиот претходник кој е изменет според истата логика.

// input         output
// 5             Vnesenata niza e:
// 1 2 3 4 5     1 2 3 4 5
//               Novata niza e:
//               1 3 6 10 15

#include <iostream>
using namespace std;

void transformirajNiza(int a[], int n){
    for (int i=1; i<n; i++){
        int *p=&a[i-1];  //pokazvit na a[0], pa na a[1], pa na a[2]...
        a[i] += *p;
    }
}

int main(){
   int n, a[100];
   cin>>n;

   for (int i=0; i<n; i++){
       cin>>a[i];
   }
   cout<<"Vnesenata niza e:"<<endl;
   for (int i=0; i<n; i++){
       cout<<a[i]<<" ";
   }
   cout<<endl;
   cout<<"Novata niza e:"<<endl;

   transformirajNiza(a,n);

   for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
   }

   return 0;
}
