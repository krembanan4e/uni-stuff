/*
Да се дефинира класата Pesna во која се чуваат информации за (5 поени):
име на песна (динамички алоцирано поле од знаци)
времетраење на песната во минути
тип на песна кој може да биде: поп, рап или рок (енумерација tip)
Да се обезбедат сите потребни методи за класата за правилно функционирање на програмата. (10 поени)
Дополнително за оваа класа да се дефинира методот:
pecati() - функција во која ќе се печатат одделени со цртичка(-): името на песната во наводници и времетраењето на песната со постфикс min. (5 поени)
Да се креира класата CD во која се чуваат информации за (5 поени):
низа од песни снимени на CD-то (Поле од најмногу 10 објекти од класата Pesna )
број на песни снимени на CD-то
максимално времетраење на песните на CD-то (во минути)
Да се обезбедат сите потребни методи за класата за правилно функционирање на програмата. (5 поени)
Дополнително за оваа класа да се дефинираат методите:
dodadiPesna (Pesna p) - со кој се додава песната p на CDто, но само ако има доволно преостанато место (земајќи го предвид максималното времетраење на песните на CDто и времетраењата на песните на CD-то) и ако има помалку од 10 песни на CD-то. (10 поени)
pecatiPesniPoTip(tip t) – со кој се печатат информациите за сите песни од тип t (поп, рап или рок). (10 поени)
Комплетна функционалност (5 поени).

input
3
4
Happy 5 0
Layla 8 2
Stan 4 1
Revolution 7 2

output
===== Testiranje na metodot dodadiPesna() od klasata CD ======
"Happy"-5min
"Layla"-8min
"Stan"-4min
*/

#include <iostream>
#include <cstring>

using namespace std;

enum tip{pop, rap, rok};

class Pesna{
private:
    char* ime;
    int min;
    tip kojtip;
public:
    Pesna(){
        this->ime = new char[0];
        this->min = 0;
        this->kojtip = pop;
    }
    Pesna(char* ime, int min, tip kojtip){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->min = min;
        this->kojtip = kojtip;
    }
    Pesna(const Pesna &p){
        this->ime = new char[strlen(p.ime)+1];
        strcpy(this->ime, p.ime);
        this->min = p.min;
        this->kojtip = p.kojtip;
    }
    Pesna &operator=(const Pesna &p){
        if(this!=&p){
            delete []ime;
            this->ime = new char[strlen(p.ime)+1];
            strcpy(this->ime, p.ime);
            this->min = p.min;
            this->kojtip = p.kojtip;
        }
        return *this;
    }
    void pecati(){
        cout<<"\""<<ime<<"\"-"<<min<<"min"<<endl;
    }
    tip getTip(){
        return kojtip;
    }
    int getMin(){
        return min;
    }
    ~Pesna(){
        delete []ime;
    }
};

class CD{
private:
    Pesna p[10];
    int n; //br na pesni
    int maxVremetraenje;
public:
    CD(){
        this->n = 0;
        this->maxVremetraenje = 0;
    }
    CD(int maxVremetraenje){
        this->n = 0;
        this->maxVremetraenje = maxVremetraenje;
    }
    CD(const CD &c){
        this->n = c.n;
        for (int i = 0; i < n; ++i) {
            this->p[i] = c.p[i];
        }
        this->maxVremetraenje = c.maxVremetraenje;
    }
    CD &operator=(const CD &c){
        if(this!=&c){
            this->n = c.n;
            for (int i = 0; i < n; ++i) {
                this->p[i] = c.p[i];
            }
            this->maxVremetraenje = c.maxVremetraenje;
        }
        return *this;
    }
    int getBroj(){
        return n;
    }
    Pesna getPesna(int id){
        return p[id];
    }

    int vremetraenjaNaPesnite(){
        int suma=0;
        for (int i = 0; i < n; ++i) {
            suma+=p[i].getMin();
        }
        return  suma;
    }

    void dodadiPesna(Pesna &pesna){
        if (n<10){
            //aku vkupnoto vreme od site pesni na cd-to + vremeto na novata pesna e pomalo od max kapacitet na cd-to togas dodaj
            if ((vremetraenjaNaPesnite() + pesna.getMin()) < maxVremetraenje){
                p[n] = pesna;
                this->n = n+1; //prvo dodaj pa zgolemi!!!!!!!!!
            }
        }
    }

    void pecatiPesniPoTip(tip kojtip){
        for (int i = 0; i < n; ++i) {
            if((int)p[i].getTip() == (int)kojtip){
                p[i].pecati();
            }
        }
    }

    ~CD(){}
};

int main() {
    // se testira zadacata modularno
    int testCase;
    cin >> testCase;

    int n, minuti, kojtip;
    char ime[50];

    if(testCase == 1) {
        cout << "===== Testiranje na klasata Pesna ======" << endl;
        cin >> ime;
        cin >> minuti;
        cin >> kojtip; //se vnesuva 0 za POP,1 za RAP i 2 za ROK
        Pesna p(ime,minuti,(tip)kojtip);
        p.pecati();
    }
    else if(testCase == 2) {
        cout << "===== Testiranje na klasata CD ======" << endl;
        CD omileno(20);
        cin>>n;
        for (int i=0;i<n;i++){
            cin >> ime;
            cin >> minuti;
            cin >> kojtip; //se vnesuva 0 za POP,1 za RAP i 2 za ROK
            Pesna p(ime,minuti,(tip)kojtip);
            omileno.dodadiPesna(p);
        }
        for (int i=0; i<n; i++)
            (omileno.getPesna(i)).pecati();
    }
    else if(testCase == 3) {
        cout << "===== Testiranje na metodot dodadiPesna() od klasata CD ======" << endl;
        CD omileno(20);
        cin>>n;
        for (int i=0;i<n;i++){
            cin >> ime;
            cin >> minuti;
            cin >> kojtip; //se vnesuva 0 za POP,1 za RAP i 2 za ROK
            Pesna p(ime,minuti,(tip)kojtip);
            omileno.dodadiPesna(p);
        }
        for (int i=0; i<omileno.getBroj(); i++)
            (omileno.getPesna(i)).pecati();
    }
    else if(testCase == 4) {
        cout << "===== Testiranje na metodot pecatiPesniPoTip() od klasata CD ======" << endl;
        CD omileno(20);
        cin>>n;
        for (int i=0;i<n;i++){
            cin >> ime;
            cin >> minuti;
            cin >> kojtip; //se vnesuva 0 za POP,1 za RAP i 2 za ROK
            Pesna p(ime,minuti,(tip)kojtip);
            omileno.dodadiPesna(p);
        }
        cin>>kojtip;
        omileno.pecatiPesniPoTip((tip)kojtip);

    }
    else if(testCase == 5) {
        cout << "===== Testiranje na metodot pecatiPesniPoTip() od klasata CD ======" << endl;
        CD omileno(20);
        cin>>n;
        for (int i=0;i<n;i++){
            cin >> ime;
            cin >> minuti;
            cin >> kojtip; //se vnesuva 0 za POP,1 za RAP i 2 za ROK
            Pesna p(ime,minuti,(tip)kojtip);
            omileno.dodadiPesna(p);
        }
        cin>>kojtip;
        omileno.pecatiPesniPoTip((tip)kojtip);

    }

    return 0;
}
