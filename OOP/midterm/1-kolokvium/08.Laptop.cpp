/*
Во програмскиот јазик C++ да се креира структура Laptop за опишување на спецификациите на даден преносен компјутер. Структурата треба да содржи: (5 поени)

Фирма која го произведува ( низа од 100 знаци)
Големина на монитор во инчи (реален број)
Дали е со touch или не (булова променлива)
Цена (цел број)
Да се креира структура ITStore, што содржи: (5 поени)

Име на продавницата (низа од 100 знаци)
Локација (низа од 100 знаци)
Низа од достапни лаптопи (низа од максимум 100 елементи од структурата Laptop)
Број на елементи во низата (цел број)
Да се креира функција print за печатење на информациите за сите лаптопи во една продавница во формат: (10 поени)

[Ime na prodavnicata] [Lokacija]
[Marka1] [dim_monitor1] [Cena1]
[Marka2] [dim_monitor2] [Cena2]
[Marka3] [dim_monitor3] [Cena3]
...
Да се креира функција najeftina_ponuda, што прима низа од променливи од типот ITStore и го печати името и локацијата на онаа продавница која нуди најевтин преносен компјутер и неговата цена. 
Најефтин преносен компјутер е оној што има најниска цена и плус опција за touch. Ако има повеќе такви продавници, се печати прво најдената.* (15 поени)*

Да се дополни функцијата main (10 поени).

Од тастатура се внесува бројот на продавници, па потоа за секоја продавница се внесуваат името и локацијата, а потоа бројот на компјутери, па за секој од компјутерите фирма која го произведува, 
големина на монитор, дали има touch и цена. Потоа се печатат сите внесени продавници и најевтината понуда.

For example:

Input	
2
AMC
Skopje
3
dell
13.1
1
32500
asus
15.0
0
20200
hp
13.1
1
42000
Anhoch
Skopje
1
asus
13.3
1
32000

Output
AMC Skopje
dell 13.1 32500
asus 15 20200
hp 13.1 42000
Anhoch Skopje
asus 13.3 32000
Najeftina ponuda ima prodavnicata: 
Anhoch Skopje
Najniskata cena iznesuva: 32000
*/

#include <iostream>
#include <cstring>
#include <climits>

using namespace std;

struct Laptop{
    char firma[100];
    float inchi;
    bool daliTouch;
    int cena;

    void print(){
        cout<<firma<<" "<<inchi<<" "<<cena<<endl;
    }
};

struct ITStore{
    char ime[100];
    char lokacija[100];
    Laptop l[100];
    int br_l;

    void print(){
        cout<<ime<<" "<<lokacija<<endl;
        for (int i = 0; i < br_l; ++i) {
            l[i].print();
        }
    }
};

void najeftina_ponuda(ITStore it[], int n){
    int it_id, l_id;
    int min=INT_MAX;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < it[i].br_l; ++j) {
            if (it[i].l[j].daliTouch){
                if(it[i].l[j].cena<min){
                    min=it[i].l[j].cena;
                    it_id=i;
                    l_id=j;
                }
            }
        }
    }

    cout<<"Najeftina ponuda ima prodavnicata:"<<endl;
    cout<<it[it_id].ime<<" "<<it[it_id].lokacija<<endl;
    cout<<"Najniskata cena iznesuva: "<<it[it_id].l[l_id].cena<<endl;
}

int main() {
    ITStore s[100];
    int n;
    scanf("%d",&n); //broj na IT prodavnici
    
    //vnesuvanje na prodavnicite edna po edna, zaedno so raspolozlivite laptopvi vo niv
    
    for (int i = 0; i < n; ++i) {
        cin >> s[i].ime >> s[i].lokacija >> s[i].br_l;
        for (int j = 0; j < s[i].br_l; ++j) {
            cin >> s[i].l[j].firma;
            cin >> s[i].l[j].inchi;
            cin >> s[i].l[j].daliTouch;
            cin >> s[i].l[j].cena;
        }
    }
    
    //pecatenje na site prodavnici
    
    for (int i = 0; i < n; ++i) {
        s[i].print();
    }
    
    //povik na glavnata metoda
    najeftina_ponuda(s, n);

    return 0;
}
