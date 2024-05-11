/*
Да се креира структура Igrac во која се чуваат податоци за еден играч на компјутерската игра. За играчот се чуваат информации за корисничкото име на играчот (низа од 15 знаци), 
број на ниво до кој играчот е стигнат (цел број) и број на освоени поени (цел број) (10 поени).

Потоа да се креирa структура KompjuterskaIgra во која се чуваат податоци за името на играта (низа од 20 знаци), низа од играчи кои ја играат играта (најмногу 30) и бројот на играчи. (10 поени)

Треба да се направи функција со потпис (15 поени)

void najdobarIgrac(KompjuterskaIgra *lista, int n)
Оваа функција треба да го испечати името на најдобриот играч на онаа игра која има најголема популарност (ја играат наjголем број на играчи). 
Најдобар играч е играчот кој има најголем број на освоени поени. Ако има повеќе играчи со ист максимален број на освоени поени, најдобар е играчот кој има достигнато најголемо ниво.

Печатењето е во форматот: "Najdobar igrac e igracot so korisnicko ime XXXXX koj ja igra igrata YYYYYY". 
(XXXXXX е корисничкото име на најдобриот играч,а YYYYY е името на играта која ја играат најголем број на играчи)

(Забелешка: секогаш ќе има точно еден најдобар играч)

Функционалност на задачата и дополнување на main функцијата (10 поени)

Забелешка: Задачата да се реши во програмскиот јазик C+

For example:

Input	
2
Snake
2
user1 5 120
user2 4 120
Cars
3
koliubavi 5 130
fikjo 3 150
motor 4 140

Output
Najdobar igrac e igracot so korisnicko ime fikjo koj ja igra igrata Cars
*/

#include <iostream>
#include <cstring>

using namespace std;

struct Igrac{
    char ime[15];
    int nivo;
    int poeni;
};

struct KompjuterskaIgra{
    char ime[20];
    Igrac ig[20];
    int br_igraci;//n na igraci

};

void najdobarIgrac(KompjuterskaIgra *lista, int n){
    int id_max_igraci=0;

    //igrata so najmnogu igraci
    for (int i = 1; i < n; ++i) {
        if (lista[i].br_igraci > lista[id_max_igraci].br_igraci){ //ako i-tiot e pogolem od max-tiot
            id_max_igraci = i;
        }
    }

    KompjuterskaIgra najpopularna = lista[id_max_igraci]; //najpopularnata igra

    //sporedba dali i-tiot igrac > max-tiot igrac
    //igracot so max poeni (ako se isti poenite, so max nivo)
    int id_max=0;
    for (int i = 1; i < najpopularna.br_igraci; ++i) {
        if (najpopularna.ig[i].poeni > najpopularna.ig[id_max].poeni){
            id_max = i; //index na igracot so najmn poeni
        }
        else if(najpopularna.ig[i].poeni == najpopularna.ig[id_max].poeni){
            if(najpopularna.ig[i].nivo > najpopularna.ig[id_max].nivo){
                id_max = i; //update index na igracot so najgolemo nivo, ak se isti poenite
            }
        }
    }

    cout<<"Najdobar igrac e igracot so korisnicko ime "<<najpopularna.ig[id_max].ime<<" koj ja igra igrata "<<najpopularna.ime<<endl;

}

int main() {
    int n;
    cin>>n;
    KompjuterskaIgra k[n];
    for (int i = 0; i < n; ++i) {
        cin>>k[i].ime>>k[i].br_igraci;
        for (int j = 0; j < k[i].br_igraci; ++j) {
            cin>>k[i].ig[j].ime;
            cin>>k[i].ig[j].nivo;
            cin>>k[i].ig[j].poeni;
        }
    }

    najdobarIgrac(k, n);

    return 0;
}

