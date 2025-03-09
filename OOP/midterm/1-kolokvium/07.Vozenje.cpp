/*
Во програмскиот јазик С++ да се креира структура Vozenje за опишување на адреналински возења во забавен парк. Структурата треба да содржи: (5 поени)

Име на возењето ( низа од 100 знаци)
Времетраење во минути (цел број)
Цена (децимален број)
Дали има студентски попуст (1-да, 0-не)
Да се креира структура ZabavenPark, што содржи: (10 поени)

Име на забавниот парк (низа од 100 знаци)
Локација (низа од 100 знаци)
Низа од адреналински возења во паркот (низа од максимум 100 елементи од структурата Vozenje)
Број на елементи во низата (цел број)
Да се креира функција print за печатење на информациите за сите возења во забавниот парк во формат: (10 поени)

[Ime na parkot] [Lokacija]
[Ime1] [Vremetraenje1] [Cena1]
[Ime2] [Vremetraenje2] [Cena2]
[Ime3] [Vremetraenje3] [Cena3]
...
Да се креира функција najdobar_park, што прима низа од променливи од типот ZabavenPark и го печати името и локацијата на паркот кој е најефтин за посета од страна на студенти. 
Најефтин парк е оној што содржи најголем број возења со студентски попуст. Ако повеќе паркови ги делат овие карактеристики, да се испечати паркот со најголемото времетраење од сите возења.* (20 поени)*

Да се дополни функцијата main (5 поени).

For example:

Input	
2
Disneyland
Paris
2
BigThunderMountain
15
10
1
Shark
22
13
0
TivoliGardens
Copenhagen
3
Devil
16
11
1
FlyMountain
35
19
1
Nemo
8
7
0

Output
Disneyland Paris
BigThunderMountain 15 10.00
Shark 22 13.00
TivoliGardens Copenhagen
Devil 16 11.00
FlyMountain 35 19.00
Nemo 8 7.00
Najdobar park: TivoliGardens Copenhagen

*/

#include <iostream>
#include <iomanip>
#include <cstring>

using namespace std;

struct Vozenje{
    char ime[100];
    int min;
    float cena;
    bool popust;

    void print(){
        cout<<ime<<" "<<min<<" "<<fixed<<setprecision(2)<<cena<<endl;
    }
};

struct ZabavenPark{
    char ime[100];
    char lokacija[100];
    Vozenje vozenja[100];
    int n; //br na vozenja

    void print(){
        cout<<ime<<" "<<lokacija<<endl;
        for (int i = 0; i < n; ++i) {
            vozenja[i].print();
        }
    }

};

void najdobar_park(ZabavenPark p[], int np){ //np - broj na parkovi
    int max_za_popust=0;
    int max_za_vreme=0;
    int max_suma_minuti=0; //suma za minuti
    int id; //za toj so najgolemo vremetraenje 
    int idd; //za toj so najgolem broj vozenja so popust
    
    //ovde go barame toj so max vremetraenje
    for (int i = 0; i < np; ++i) {
        int suma_minuti=0;
        for (int j = 0; j < p[i].n; ++j) { //n - broj na vozenja
            suma_minuti+=p[i].vozenja[j].min; //suma za vremetraenje na vozenjata od toj park
        }
        if(suma_minuti>max_suma_minuti){
            max_suma_minuti=suma_minuti;
            id=i;
        }
    }

    //ovde toj so max vozenja so popust
    int flag=0;
    for (int i = 0; i < np; ++i) {
        int suma_popusti=0; //za kolku vozenja imet popust
        for (int j = 0; j < p[i].n; ++j) { //n - broj na vozenja
            if (p[i].vozenja[j].popust){ //aku imat popust
                suma_popusti+=1;
            }
        }
       if(suma_popusti>max_za_popust){
           max_za_popust=suma_popusti; //indexot na toj park so najmn popusti
           idd=i;
       }
        if(suma_popusti==max_za_popust){
            //cout << "Najdobar park: " << p[id].ime << " " << p[id].lokacija << endl;
            flag=1; //vlegol vo ifot
            break;
        }
    }
    if(!flag){
        cout << "Najdobar park: " << p[idd].ime << " " << p[idd].lokacija << endl;
    }
    else{
        cout << "Najdobar park: " << p[id].ime << " " << p[id].lokacija << endl;
    }

}

int main(){
    int n;
    cin>>n; //br na parkovi
    ZabavenPark zp[n];

    for (int i = 0; i < n; ++i) {
        cin>>zp[i].ime>>zp[i].lokacija>>zp[i].n;
        for (int j = 0; j < zp[i].n; ++j) {
            cin>>zp[i].vozenja[j].ime;
            cin>>zp[i].vozenja[j].min;
            cin>>zp[i].vozenja[j].cena;
            cin>>zp[i].vozenja[j].popust;
        }
    }

    for (int i = 0; i < n; ++i) {
        zp[i].print();
    }

    najdobar_park(zp, n);

    return 0;
}
