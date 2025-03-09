//Да се напише програма која ќе го пресмета скаларниот производ на два вектори со по n координати.
//Бројот на координати n, како и координатите на векторите се внесуваат од стандарден влез.
//Резултатот да се испечати на екран.

//Скаларен производ на вектори: 1*2 + 2*7 + 5*9 + 3*1 + 4*5
// [1, 2, 5, 3, 4]
// [2, 7, 9, 1, 5]

#include<iostream>

using namespace std;

int main() {
    int a1[100], a2[100], n, skalarenProizvod = 0; //0 zsh e suma od proizvodi
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>a1[i];
    }
    for (int i=0; i<n; i++){
        cin>>a2[i];
    }
    for (int i=0; i<n; i++){
        skalarenProizvod+=(a1[i]*a2[i]);
    }
    cout<<"Skalarniot proizvod e: "<<skalarenProizvod<<endl;
    return 0;
}
