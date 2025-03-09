//Од стандарден влез да се вчита број N и потоа да се вчитаат N елементи во една низа.
//Трансформирајте ја низата со удвојување на секој елемент и замена на секој негативен елемент со неговата апсолутна вредност.
//Трансформираната низа да се испечати, такашто елементите ќе се одвоени со празно место меѓу нив.

//input            output
//5                2 4 6 8 10
//1 -2 3 -4 5

#include <iostream>
#include <cmath>
using namespace std;

void transformirajNiza (int a[], int n){
    for (int i=0; i<n; i++){
        a[i]=2* abs(a[i]);
    }
}

int main(){
    int n, a[100];
    cin>>n;

    for (int i=0; i<n; i++){
        cin>>a[i];
    }

    transformirajNiza(a,n);

    for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
    }

    return 0;
}
