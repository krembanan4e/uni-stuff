/*
Да се креира структура SkiLift во која се чуваат податоци за името на ски лифтот (низа од 15 знаци), 
максимален број на корисници што може да опслужи на едно возење, дали е пуштен во функција.

Потоа да се креирa структура SkiCenter во која се чуваат податоци за името на скијачкиот центар, 
држава во која се наоѓа (низи од 20 знаци), низа од ски лифтови (макс 20) што ги има и број на ски лифтови.

Треба да се направи функција со потпис

void najgolemKapacitet(SkiCenter *sc, int n)
која што ќе го отпечати ски центарот што има најголем капацитет за опслужување скијачи 
(вкупниот број на скијачи кои може да се опслужуваат во еден момент вкупно на сите ски лифтови во центарот). 
Доколку два ски центри имаат ист капацитет, тогаш се печати оној кој има поголем број на ски лифтови. 
Притоа треба да се испечатат во посебен ред името, државата и капацитетот на ски центарот. 
Кога се пресметува капацитет на еден ски центар во предвид се земаат само ски лифтовите кои се поставени дека се во функција.

For example:

Input	
1
Mavrovo
Makedonija
6
Ednosed
30
1
Dvosed
60
1
Ciciban
10
1
Galicki
20
1
Belicki
36
0
Plavi
40
1

Output
Mavrovo
Makedonija
160
*/

#include<iostream>
#include <cstring>
using namespace std;

struct SkiLift{
    char ime[15];
    int br_korisnici;
    bool daliPushten;

};
struct SkiCenter{
    char ime[20];
    char drzava[20];
    SkiLift s[20];
    int br; //br na ski liftovi
};
void najgolemKapacitet(SkiCenter *sc, int n){
    int id=0;
    int max_suma_korisnici=0;
    for (int i = 0; i < n; ++i) {
        int suma=0;
        for (int j = 0; j < sc[i].br; ++j) {
            if (sc[i].s[j].daliPushten){
                suma+=sc[i].s[j].br_korisnici;
            }
        }
        if (suma > max_suma_korisnici){
            max_suma_korisnici=suma;
            id=i; //index na ski centarot
        }
        if (suma == max_suma_korisnici){
            if (sc[i].br > sc[id].br){
                id=i;
            }
        }
    }
    cout<<sc[id].ime<<endl;
    cout<<sc[id].drzava<<endl;
    cout<<max_suma_korisnici<<endl;
}

int main(){
    int n;
    cin>>n;
    SkiCenter sc[n];
    for (int i = 0; i < n; ++i) {
        cin>>sc[i].ime>>sc[i].drzava>>sc[i].br;
        for (int j = 0; j < sc[i].br; ++j) {
            cin>>sc[i].s[j].ime;
            cin>>sc[i].s[j].br_korisnici;
            cin>>sc[i].s[j].daliPushten;
        }
    }
    najgolemKapacitet(sc,n);

    return 0;
}
