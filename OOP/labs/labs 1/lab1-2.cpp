/* Да се креира структура Engine во која што ќе се чуваат податоци за коњска сила / horsepower (int) и вртежен момент / torque (int).
Потоа, да се креира структура Car во која што ќе  се чуваат податоци името на производителот (char array) ,
која година е произведена колата (int) и кој мотор / engine (Engine) која што го користи/
На почетокот се внесува број N што озналува колку коли ќе се читаат од влез.

Да се направи функцијата: void printCars(...)
која што ќе ги земе двете коли кои имаат најмала коњска сила, и од нив две, ќе ја испечати колата што има поголем вртежен момент.

input
3
Opel
1999
577 
516
Audi
2000
591
590
Citroen
2020
220
321
----------------
output
Manufacturer: Opel
Horsepower: 577
Torque: 516

*/

#include <iostream>

using namespace std;

struct Engine{
    int k_sila;
    int v_moment;
};

struct Car{
    char proizvoditel[30];
    int godina;
    Engine motor;

};

void printCars(Car *c, int N){
    int max_ks = c[0].motor.k_sila;
    int id_1=0;
    for (int i = 1; i < N; ++i) {
        if (c[i].motor.k_sila < max_ks){
            max_ks=c[i].motor.k_sila;
            id_1=i;
        }
    }

    int max_ks2 = c[0].motor.k_sila;
    int id_2=0;
    for (int i = 1; i < N; ++i) {
        if (c[i].motor.k_sila < max_ks2 && c[i].motor.k_sila > max_ks){
            max_ks2=c[i].motor.k_sila;
            id_2=i;
        }
    }

    if (c[id_1].motor.v_moment > c[id_2].motor.v_moment){
        cout<<"Manufacturer: "<<c[id_1].proizvoditel<<endl;
        cout<<"Horsepower: "<<c[id_1].motor.k_sila<<endl;
        cout<<"Torque: "<<c[id_1].motor.v_moment<<endl;
    }
    else{
        cout<<"Manufacturer: "<<c[id_2].proizvoditel<<endl;
        cout<<"Horsepower: "<<c[id_2].motor.k_sila<<endl;
        cout<<"Torque: "<<c[id_2].motor.v_moment<<endl;
    }
}

int main(){
    int N;
    cin>>N;
    Car c[N];
    for (int i = 0; i < N; ++i) {
        cin>>c[i].proizvoditel;
        cin>>c[i].godina;
        cin>>c[i].motor.k_sila;
        cin>>c[i].motor.v_moment;
    }

    printCars(c, N);

    return 0;
}
