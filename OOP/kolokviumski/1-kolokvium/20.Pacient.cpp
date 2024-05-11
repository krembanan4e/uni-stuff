/*
Во програмскиот јазик C++ да се креира структура Pacient и истата треба да содржи: (5 поени)

Име и презиме на пациентот ( низа од макс. 100 знаци)
Дали е здраствено осигуран (1-да, 0-не)
Број на прегледи во текот на последниот месец (цел број)
Да се креира структура MaticenDoktor, која во себе содржи: (5 поени)

Име на докторот (низа од 100 знаци)
Број на пациенти (цел број)
Листа од пациенти (низа од максимум 200 елементи од структурата Pacient)
Цена на преглед (децимален број)
Да се креираат метода najuspesen_doktor, која прима низа од променливи од типот MaticenDoktor и нивниот број; и го печати името, 
заработената сума и бројот на прегледи на оној доктор кој заработил најголема сума од пациенти кои ги прегледувал приватно (не се здраствено осигурани) (10 поени). 
Доколку два или повеќе доктори имаат иста сума, тогаш се печати оној доктор кој има направено најголем број на прегледи вкупно во текот на последниот месец. (20 поени)

Функционалност (5 поени).

For example:

Input	
3
Д-р.Јованка_Јовановска
3
300.00
Јованова_Ивана 1 2
Боцевска_Ивана 0 3
Илиевска_Ангела 1 0
Д-р.Петко_Петковски
1
50.00
Ивановска_Цветанка 0 18
Д-р.Трајче_Трајчев
3
300.00
Крстевски_Филип 1 0
Цветановски_Иван 1 10
Ивановска_Цветанка 0 3

Output
Д-р.Петко_Петковски 900.00 18

*/

#include<iostream>
#include <iomanip>
using namespace std;

struct Pacient{
    char ime_prezime[100];
    bool daliOsiguran;
    int br_pregledi;
};
struct MaticenDoktor{
    char ime[100];
    int br_pacienti;
    Pacient p[200];
    float cena;
};
void najuspesen_doktor(MaticenDoktor *md, int n){
    int id=0;
    float max_suma=0;
    float max_pregledi=0;
    for (int i = 0; i < n; ++i) {
        float suma=0;
        for (int j = 0; j < md[i].br_pacienti; ++j) {
            if(!md[i].p[j].daliOsiguran){
                suma += (md[i].cena * md[i].p[j].br_pregledi);
            }
        }
        if(suma > max_suma){
            max_suma = suma;
            id = i;
        }
        if (suma == max_suma){
            float suma_pregledi=0;
            for (int j = 0; j < md[i].br_pacienti; ++j) {
                suma_pregledi += md[i].p[j].br_pregledi;
            }
            if (suma_pregledi > max_pregledi){
                max_pregledi = suma_pregledi;
                id=i;
            }
        }
    }
    cout<<md[id].ime<<" "<<(fixed)<<setprecision(2)<<max_suma<<" ";
    cout<<(fixed)<<setprecision(0)<<max_pregledi<<endl;
}

int main(){
    int n;
    cin>>n;
    MaticenDoktor md[n];
    for (int i = 0; i < n; ++i) {
        cin>>md[i].ime>>md[i].br_pacienti>>md[i].cena;
        for (int j = 0; j < md[i].br_pacienti; ++j) {
            cin>>md[i].p[j].ime_prezime;
            cin>>md[i].p[j].daliOsiguran;
            cin>>md[i].p[j].br_pregledi;
        }
    }
    najuspesen_doktor(md, n);


    return 0;
}



