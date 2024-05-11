/*
Да се креира структура Воз во која се чуваат податоци за релацијата по која се движи возот (низа од најмногу 50 знаци), 
предвиден бројот на километри што треба да се поминат (реален број), како и бројот на патници во возот (цел број).

Потоа да се креирa структура ZeleznickaStanica во која се чуваат податоци за градот во кој се наоѓа (низа од 20 знаци), 
низа од возови што поаѓаат од станицата (најмногу 30) и бројот на возови (цел број).

Треба да се направи функција со потпис

void najkratkaRelacija(ZeleznickaStanica* zs, int n, char* grad)
во која се печати релацијата и бројот на километри на возот што поминува најкратка релација (најмалку километри), 
а поаѓа од железничката станица од градот што се проследува како влезен аргумент. 
Ако има повеќе возови со ист најмал број на километри, да се испечати релацијата на последниот таков.

Забелешка: Задачата да се реши во програмскиот јазик C++

For example:

Input	
1
Dresden
2
Dresden-Berlin 192 200
Dresden-Lajpcig 115 90
Dresden

Output
Najkratka relacija: Dresden-Lajpcig (115 km)
*/

#include<iostream>
#include <cstring>
using namespace std;

struct Voz{
    char relacija[50];
    float km;
    int br_patnici;
};

struct ZeleznickaStanica{
    char grad[20];
    Voz v[30];
    int br_v;
};

void najkratkaRelacija(ZeleznickaStanica* zs, int n, char* grad){
    int voz_id=0, zs_id=0;
    for (int i = 0; i < n; ++i) {
        if (strcmp(zs[i].grad, grad)==0){
            zs_id = i;
        }
    }

    //ta zeleznicka stanica so toj grad
    ZeleznickaStanica stanica = zs[zs_id];

    //indeksot na vozot so najmalku km
    for (int i = 0; i < stanica.br_v; ++i) {
        if(stanica.v[i].km <= stanica.v[voz_id].km){
            voz_id = i;
        }
    }

    cout<<"Najkratka relacija: "<<stanica.v[voz_id].relacija<<" ("<<stanica.v[voz_id].km<<" km)"<<endl;
}

int main(){

    int n;
    cin>>n; //se cita brojot na zelezlnichki stanici

    ZeleznickaStanica zStanica[100];
    for (int i=0;i<n;i++){
        //se citaat infomracii za n zelezlnichkite stanici i se zacuvuvaat vo poleto zStanica
        cin>>zStanica[i].grad>>zStanica[i].br_v;
        for (int j = 0; j < zStanica[i].br_v; ++j) {
            cin>>zStanica[i].v[j].relacija;
            cin>>zStanica[i].v[j].km;
            cin>>zStanica[i].v[j].br_patnici;
        }
    }

    char grad[25];
    cin>>grad;

    najkratkaRelacija(zStanica,n,grad);
    return 0;
}
