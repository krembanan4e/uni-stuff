/* Да се напише програма во која од стандарден влез се внесува бројот N (бројот на фудбалски тимови) и информациите за N-те фудбалски тимови.

Една структура за Фудбалски тим (FootballTeam) треба да ги чува следните информации:
- Името на тимот (низа од карактери)
- Низа од играчи (претставени преку структурата FootballPlayer, при што еден тим секогаш ќе има 11 играчи)

Во структурата Фудбалски играч (FootballPlayer) треба да се чуваат следните информации:
- Името на играчот (низа од карактери)
- Број на дресот (int)
- Број на дадени голови (int)

Ограничување: 0 < N < 100

Ваша задача е да направите функција void bestTeam(FootballTeam * teams, int n) која ќе го печати тимот со најмногу дадени голови
(во случај да има повеќе тима со ист број на голови треба да се печати првиот што е внесен).
Внесувањето на податоците да се направи во main-от, при што редоследот на влезните податоци ќе е следниот:

N
team_name_1
player_name_1 number_1 goals_1
...
player_name_11 number_11 goals_11
team_name_2
player_name_1 number_1 goals_1
...
player_name_11 number_11 goals_11

...

team_name_n
player_name_1 number_1 goals_1
...
player_name_11 number_11 goals_11


input 
2
Arsenal
Baro 14 1
Lubomir 16 4
Lubomir 1 3
Paul 35 8
Jakov 22 8
Jovan 7 3
Kristijan 18 4
Nikola 14 8
Mile 24 9
Vlatko 27 8
Ivan 43 0
PSG
Paul 49 11
Sasho 33 7
Ivo 35 4
Maksim 28 7
Bojan 25 2
Goran 32 8
Andrej 13 3
Mile 30 6
Jakov 31 1
Jovan 35 6
Ivan 37 4
---------------
output
Najdobar tim e: PSG

*/

#include <iostream>

using namespace std;

struct FootballPlayer{
    char ime[15];
    int br_dres;
    int golovi;

    void print(){
        cout<<ime<<" "<<br_dres<<endl;
    }
};

struct FootballTeam{
    char ime[20];
    FootballPlayer p[11];

};

void bestTeam(FootballTeam *teams, int n){
    int max=0, tim_id;
    for (int i = 0; i < n; ++i) {
        int suma=0;
        for (int j = 0; j < 11; ++j) {
            suma+=teams[i].p[j].golovi;
        }
        if (suma>max){
            max=suma;
            tim_id=i;
        }
    }

    cout<<"Najdobar tim e: "<<teams[tim_id].ime;
}

int main(){
    int N;
    cin>>N;
    if (N>100 || N<0){
        return -1;
    }
    FootballTeam t[N];
    for (int i = 0; i < N; ++i) {
        cin>>t[i].ime;
        for (int j = 0; j < 11; ++j) {
            cin>>t[i].p[j].ime;
            cin>>t[i].p[j].br_dres;
            cin>>t[i].p[j].golovi;
        }
    }

    bestTeam(t, N);
    return 0;
}
