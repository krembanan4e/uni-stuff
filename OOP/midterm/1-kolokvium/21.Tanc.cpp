/*
Да се креира структура Tanc во која се чуваат податоци за името на танцот и земја на потекло (низи од 15 знаци) .

Потоа да се креирa структура Tancer во која се чуваат податоци за име и презиме (низи од максимум 20 знаци), низа од 5 танци (структура Tanc) кои дадениот танчер може да ги игра. 
Дополнително, за оваа структура да се обезбеди функција со потпис : void tancuvanje(Tancer *t, int n, char *zemja)
што ќе ги испечати во посебен ред името и презимето на танчерите што знаат да играат барем по еден танц од земјата која е проследена како аргумент на функцијата, 
како и името на танцот во формат: Име Презиме, Име на танц

For example:

Input	
4
Aleks
Aleksov
samba
brazil
salsa
kuba
merengue
dominikana
Marko
Markov
tango
argentina
flamenco
spanija
samba
brazil
Nikola
Nikolov
chacha
kuba
samba
brazil
vienski
avstrija
Marta
Martovska
samba
brazil
samba1
brazil
bachata
dominikana
brazil

Output
Aleks Aleksov, samba
Marko Markov, samba
Nikola Nikolov, samba
Marta Martovska, samba

*/

#include<iostream>
#include <cstring>
using namespace std;

struct Tanc{
    char ime[15];
    char zemja[15];
};
struct Tancer{
    char ime[20];
    char prezime[20];
    Tanc tanc[5];
    //int br; //br na tanci
};

void tancuvanje(Tancer *t, int n, char *zemja){
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 3; ++j) {
            if(strcmp(t[i].tanc[j].zemja, zemja)==0){
                cout<<t[i].ime<<" "<<t[i].prezime<<", "<<t[i].tanc[j].ime<<endl;
                break;
            }
        }
    }
}


int main(){
    int n;
    cin>>n;
    Tancer t[n];
    for (int i = 0; i < n; ++i) {
        cin>>t[i].ime>>t[i].prezime;
        for (int j = 0; j < 3; ++j) {
            cin>>t[i].tanc[j].ime;
            cin>>t[i].tanc[j].zemja;
        }
    }
    char zemja[15];
    cin>>zemja;
    tancuvanje(t, n, zemja);

    return 0;
}

