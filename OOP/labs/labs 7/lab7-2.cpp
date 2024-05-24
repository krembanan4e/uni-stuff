/*Да се креира хиерархиjа на класи за репрезентациjа на жичани инструменти. 
  За потребите на оваа хиерархиjа да се дефинира класа ZicanInstrument од коjа ќе бидат изведени двете класи Mandolina и Violina.

Во класата ZicanInstrument се чуваат податоци за:

името на инструментот (низа од 20 знаци)
броjот на жици
основната цена на инструментот.
За класата Mandolina дополнително се чува неjзината форма (низа од 20 знаци).

За класата Violina дополнително се чува неjзината големина (децимален броj).

За секоjа изведените класи треба да се дефинираат соодветните конструктори и следните методи:

cena() за пресметување на цената на инструментот
основната цена на мандолината се зголемува за 15% доколку таа има форма во Неаполитански стил (вредноста на променливата форма е “Neapolitan”)
основната цена на виолината се зголемува за 10% ако неjзината големина има вредност 1/4 (0.25), односно за 20% ако неjзината големина има вредност 1 (1.00)
проптоварување на операторот ==, коj ги споредува жичаните инструменти според броjот на жици што го имаат
преоптоварување на операторот << за печатење на сите податоци за жичаните инструменти.
Да се напише функциjа pecatiInstrumenti(ZicanInstrument &zi, ZicanInstrument **i, int n) 
коjа на влез прима жичан инструмент, низа од покажувачи кон жичани инструменти и броj на елементи во низата. 
Функциjата jа печати цената на сите жичани инструменти од низата кои имаат ист броj на жици како и инструментот проследен како прв аргумент на функциjата.


input
Mandolina_1 10 5000 Nepoznata
2
Mandolina_2 5 3000 Prava
Mandolina_3 10 8000 Neapolitan
Violina_1 10 4000 0.25
Violina_2 10 6000 0.8

output
9200
4400
6000
--------------------------------------
input
Mandolina_1 10 5000 Nepoznata
3
Mandolina_2 10 3000 Prava
Mandolina_3 10 8000 Neapolitan
Mandolina_4 10 6000 Prva
Violina_1 5 4000 0.25
Violina_2 5 6000 0.8
Violina_3 5 8000 0.3

output
3000
9200
6000

*/

#include <iostream>
#include <cstring>

using namespace std;

//Vasiot kod ovde:

class ZicanInstrument{
protected:
    char ime[20];
    int brZici;
    int osnovnaCena;
public:
    ZicanInstrument(){}
    ZicanInstrument(char* ime, int brZici, int osnovnaCena){
        strcpy(this->ime, ime);
        this->brZici=brZici;
        this->osnovnaCena=osnovnaCena;
    }
    bool operator==(ZicanInstrument &z){
        return this->brZici==z.brZici;
    }
    friend ostream &operator<<(ostream &o, ZicanInstrument &z){
        o<<z.ime<<" "<<z.brZici<<" "<<z.osnovnaCena<<endl;
        return o;
    }
    virtual double cena() = 0;
    ~ZicanInstrument(){}
};

class Mandolina : public ZicanInstrument{
private:
    char forma[20];
public:
    Mandolina() : ZicanInstrument(){}
    Mandolina(char* ime, int brZici, int osnovnaCena,
              char* forma) : ZicanInstrument(ime, brZici, osnovnaCena){
        strcpy(this->forma,forma);
    }
    double cena(){
        int osnovna = ZicanInstrument::osnovnaCena;
        if (strcmp(forma, "Neapolitan")==0){
            return osnovna*1.15;
        }
        else{
            return osnovna;
        }
    }
    friend ostream &operator<<(ostream &o, Mandolina &m){
        //o<<m.ime<<" "<<m.brZici<<" "<<m.osnovnaCena<<" "<<m.forma<<endl;
        o<<m.cena()<<endl;
        return o;
    }
    ~Mandolina(){}
};

class Violina : public ZicanInstrument{
private:
    float golemina;
public:
    Violina() : ZicanInstrument(){}
    Violina(char* ime, int brZici, int osnovnaCena,
              float golemina) : ZicanInstrument(ime, brZici, osnovnaCena){
        this->golemina = golemina;
    }
    double cena(){
        int osnovna = ZicanInstrument::osnovnaCena;
        if(golemina==0.25){
            return osnovna*1.10;
        }
        else if(golemina==1.00){
            return osnovna*1.20;
        }
        else{
            return osnovna;
        }
    }
    friend ostream &operator<<(ostream &o, Violina &v){
        //o<<v.ime<<" "<<v.brZici<<" "<<v.osnovnaCena<<" "<<v.golemina<<endl;
        o<<v.cena()<<endl;
        return o;
    }
    ~Violina(){}
};

void pecatiInstrumenti(ZicanInstrument &zi, ZicanInstrument **i, int n){
    for (int j = 0; j < n; ++j) {
        if(i[j]->operator==(zi)){
            cout<<i[j]->cena()<<endl;
        }
    }
}

int main() {
    char ime[20];
    int brojZici;
    float cena;
    char forma[20];
    cin >> ime >> brojZici >> cena >> forma;
    Mandolina m(ime, brojZici, cena, forma);
    int n;
    cin >> n;
    ZicanInstrument **zi = new ZicanInstrument*[2 * n];
    for(int i = 0; i < n; ++i) {
        cin >> ime >> brojZici >> cena >> forma;
        zi[i] = new Mandolina(ime, brojZici, cena, forma);
    }
    for(int i = 0; i < n; ++i) {
        float golemina;
        cin >> ime >> brojZici >> cena >> golemina;
        zi[n + i] = new Violina(ime, brojZici, cena, golemina);
    }
    pecatiInstrumenti(m, zi, 2 * n);
    for(int i = 0; i < 2 * n; ++i) {
        delete zi[i];
    }
    delete [] zi;
    return 0;
}
