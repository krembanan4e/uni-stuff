/*
2.Да се дефинира класа Vozac во која се чуваат информации за:
име (низа од максимум 100 знаци)
возраст (цел број)
број на трки (цел број)
дали е ветеран (да/не).
Да се преоптоварат:
операторот << за печатење кој ќе ги печати името, возраст, бројот на трки и дали е ветеран (се печати VETERAN)
операторот == за споредување на два возачи според заработувачката по трка.
Од оваа класа да се изведат две нови класи Avtomobilist и Motociklist.
За автомобилистот дополнително се чува: цена на автомобилот (децимален број).
За мотоциклистот дополнително се чува: моќност на мотор (цел број).
Заработувачката по трка на возачите се пресметува како:
за автомобилостот заработувачката по трка е cena_na_avtomobil/5
за мотоциклистот заработувачката по трка е mokjnost*20
Секој автомобилист плаќа данок на заработка. Да се напишат соодветни методи за пресметување данок:
- за автомобилисти: ако бројот на трки е поголем од 10 стапката на данок е 15% од заработката, инаку 10% од заработката.
- за мотоциклисти: ако е ветеран стапката на данок е 25% од заработката, инаку 20% од заработката.
Да се напше надворешна функција soIstaZarabotuvachka која како аргументи прима низа од покажувачи од класата Vocac, нивниот број, како и покажувач кон ојбект од возач 
и враќа како резултат бројот на возачи кои имаат иста заработувачка по трка со проследениот возач.

For example:
input
5
1
Hamilton 30 95 0 55000
Vetel 26 88 1 800
Barrichello 38 198 0 810
Rossi 32 130 1 800
Lorenzo 24 45 0 900
VozacX 38 198 1 800

output
=== DANOK ===
Hamilton
30
95
1650
Vetel
26
88
VETERAN
4000
Barrichello
38
198
3240
Rossi
32
130
VETERAN
4000
Lorenzo
24
45
3600
=== VOZAC X ===
VozacX
38
198
VETERAN
=== SO ISTA ZARABOTUVACKA KAKO VOZAC X ===
2

*/

#include <iostream>
#include <cstring>

using namespace std;

// vashiot kod ovde

class Vozac{
protected:
    char ime[100];
    int vozrast;
    int brTrki;
    bool daliVeteran;
public:
    Vozac(){}
    Vozac(char* ime, int vozrast, int brTrki, bool daliVeteran){
        strcpy(this->ime, ime);
        this->vozrast = vozrast;
        this->brTrki = brTrki;
        this->daliVeteran = daliVeteran;
    }
    friend ostream &operator<<(ostream &o, Vozac &v){
        o<<v.ime<<endl;
        o<<v.vozrast<<endl;
        o<<v.brTrki<<endl;
        if(v.daliVeteran){
            o<<"VETERAN"<<endl;
        }
        return o;
    }
    virtual float zarabotuvacka() = 0;
    virtual float danok() = 0;
    bool operator==(Vozac &v){
        return this->zarabotuvacka() == v.zarabotuvacka();
    }
    virtual ~Vozac(){}
};

class Avtomobilist : public Vozac{
private:
    float cena;
public:
    Avtomobilist() : Vozac(){}
    Avtomobilist(char* ime, int vozrast, int brTrki, bool daliVeteran,
                 float cena) : Vozac(ime, vozrast, brTrki, daliVeteran){
        this->cena = cena;
    }
    float zarabotuvacka(){
        return cena/5.;
    }
    float danok(){
        if(brTrki>10){
            return zarabotuvacka()*0.15;
        }
        else{
            return zarabotuvacka()*0.10;
        }
    }
    ~Avtomobilist(){}
};

class Motociklist : public Vozac{
private:
    int mokjnost;
public:
    Motociklist() : Vozac(){};
    Motociklist(char* ime, int vozrast, int brTrki, bool daliVeteran,
                int mokjnost) : Vozac(ime, vozrast, brTrki, daliVeteran) {
        this->mokjnost=mokjnost;
    }
    float zarabotuvacka(){
        return mokjnost*20;
    }
    float danok(){
        if(daliVeteran){
            return zarabotuvacka()*0.25;
        }
        else{
            return zarabotuvacka()*0.20;
        }
    }
    ~Motociklist(){}
};

int soIstaZarabotuvachka(Vozac **v, int n, Vozac *vozac){
    int counter=0;
    for (int i = 0; i < n; ++i) {
        if (v[i]->operator==(*vozac)){
            counter++;
        }
    }
    return counter;
}

int main() {
    int n, x;
    cin >> n >> x;
    Vozac **v = new Vozac*[n];
    char ime[100];
    int vozrast;
    int trki;
    bool vet;
    for(int i = 0; i < n; ++i) {
        cin >> ime >> vozrast >> trki >> vet;
        if(i < x) {
            float cena_avto;
            cin >> cena_avto;
            v[i] = new Avtomobilist(ime, vozrast, trki, vet, cena_avto);
        } else {
            int mokjnost;
            cin >> mokjnost;
            v[i] = new Motociklist(ime, vozrast, trki, vet, mokjnost);
        }
    }
    cout << "=== DANOK ===" << endl;
    for(int i = 0; i < n; ++i) {
        cout << *v[i];
        cout << v[i]->danok() << endl;
    }
    cin >> ime >> vozrast >> trki >> vet;
    int mokjnost;
    cin >> mokjnost;
    Vozac *vx = new Motociklist(ime, vozrast, trki, vet, mokjnost);
    cout << "=== VOZAC X ===" << endl;
    cout << *vx;
    cout << "=== SO ISTA ZARABOTUVACKA KAKO VOZAC X ===" << endl;
    cout << soIstaZarabotuvachka(v, n, vx);
    for(int i = 0; i < n; ++i) {
        delete v[i];
    }
    delete [] v;
    delete vx;
    return 0;
}
