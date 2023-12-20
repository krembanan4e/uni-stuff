//Од стандарден влез се внесуваат број на елементи на низа и самата низа. Ваша задача е да најдете најголем и најмал елемент на низата,
//како и да ја трансформирате низата така што секој елемент ќе се зголеми за разликата помеѓу најголемиот и најмалиот елемент
//и на крајот да ги испечатите најголемиот, најмалиот елемент и трансформираната низата.

// input         output
// 5             MAX -> 5
// 2 4 5 1 3     MIN -> 1
//               6 8 9 5 7

#include <iostream>
#include <climits>
using namespace std;


int main(){
   int n, a[100];
   cin>>n;
   for (int i=0; i<n; i++){
       cin>>a[i];
   }

   max=min=a[0];

   for (int i=0; i<n; i++){
        if (a[i]>max){
            max=a[i];
        }
        else if (a[i]<min){
            min=a[i];
        }
   }

   cout<<"MAX -> "<<max<<endl;
   cout<<"MIN -> "<<min<<endl;

   for (int i=0; i<n; i++){
        a[i]=a[i]+(max-min);
        cout<<a[i]<<" ";
   }

   return 0;
}
