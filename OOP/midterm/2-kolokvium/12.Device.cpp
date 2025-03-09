/*
12.
Да се креира класа за опишување на еден сервис за мобилни уреди. За секој мобилен телефон се чуваат податоци за модел (низа од 100 знаци), 
тип на уред (смартфон или компјутер), потребни часови за основна проверка (децимален број), година на производство (цел број). (5 поени)

Сите уреди имаат исто времетраење за основна проверка и истата изнесува 1 час. Оваа вредност може да се смени со одлука на сервисот. 
Дополнително, уредите кои се понови од 2015 година имаат потреба од дополнителени 1.5 часа за проверка. 
При проверка, лаптопите имаат потреба од дополнителни 2 часа за софтверска дијагностика (5 поени).

За оваа класа да се имплементира оператор << за печатење на уред во формат:

[modelnauredotl]
[tipnaured] [casovizaproverka]

Каде часовите за проверка се оние од основната проверка+ дополнителни 2 часа доколку уредот е понов од 2015 + 2 часа доколу уредот е лаптоп (5 поени)

Да се креира класа MobileServis во која се чува адреса (низа од 100 знаци), низа од уреди (динамички алоцирана низа) и број на уреди.(5 поени)

За класата да се обезбедат:

operatoror+= за додавање на нов уред во сервисот.(5 поени) Не смее да се дозволи годината на производство на уредот да биде поголема од 2019 или помала од 2000. 
Ако се направи обид за додавање на уред со невалидна година, треба да се генерира исклучок InvalidProductionDate. (10 поени)

Функција pecatiUredi со која се печатат сите уреди со времето потребно за нивната проверка во сервисот (5 поени).
Да се обезбедат сите дополнителни методи потребни за правилно функционирање на програмата. (5 поени)

For example:

Input	
3
TelService
6
iPhone
0
2020
Samsung
0
1999
Huawei
0
1990
Toshiba
1
2016
OnePlus
0
2009
Fujitsu
1
2010

Output
===== Testiranje na isklucoci ======
Невалидна година на производство
Невалидна година на производство
Невалидна година на производство
Ime: TelService
Toshiba
Laptop 5
OnePlus
Mobilen 1
Fujitsu
Laptop 3
*/

#include <iostream>
#include <cstring>

using namespace std;

enum tip{SMARTPHONE, COMPUTER};

class InvalidProductionDate{
private:
    char* msg;
public:
    InvalidProductionDate(){this->msg=new char[0];}
    InvalidProductionDate(const char* msg){
        this->msg=new char[strlen(msg)+1];
        strcpy(this->msg, msg);
    }
    void message(){
        cout<<msg<<endl;
    }
    ~InvalidProductionDate(){delete []msg;}
};

class Device{
private:
    char model[100];
    tip t;
    static float VREME_PROVERKA;
    int godina;
public:
    Device(){
        this->t=SMARTPHONE;
    }
    Device(char* model, tip t, int godina){
        strcpy(this->model, model);
        this->t=t;
        this->godina=godina;
    }
    Device(const Device &d){
        strcpy(this->model, d.model);
        this->t=d.t;
        this->godina=d.godina;
    }
    Device &operator=(const Device &d){
        if(this!=&d){
            strcpy(this->model, d.model);
            this->t=d.t;
            this->godina=d.godina;
        }
        return *this;
    }
    static void setPocetniCasovi(float casovi){
        VREME_PROVERKA=casovi;
    }
    float proverka(){
        float suma=0;
        if (this->godina > 2015){
            suma += 2;
        }
        if (this->t == COMPUTER){
            suma += 2;
        }
        return Device::VREME_PROVERKA+suma;
    }
    friend ostream &operator<<(ostream &o, Device &d){
        o<<d.model<<endl;
        switch (d.t) {
            case SMARTPHONE: o<<"Mobilen "; break;
            case COMPUTER: o<<"Laptop "; break;
        }
        o<<d.proverka()<<endl;
        return o;
    }
    int getGodina(){
        return godina;
    }
    ~Device(){}
};
float Device::VREME_PROVERKA=1;

class MobileServis{
private:
    char adresa[100];
    Device *d;
    int n; //broj na uredi
public:
    MobileServis(){
        this->n=0;
        this->d=new Device[0];
    }
    MobileServis(char *adresa){
        this->n=0;
        this->d=new Device[0];
        strcpy(this->adresa,adresa);
    }
    MobileServis(const MobileServis &m){
        this->n=m.n;
        this->d=new Device[n];
        for (int i = 0; i < n; ++i) {
            this->d[i]=m.d[i];
        }
        strcpy(this->adresa,m.adresa);
    }
    MobileServis &operator=(const MobileServis &m){
        if(this!=&m){
            delete []d;
            strcpy(this->adresa,m.adresa);
            this->n=m.n;
            this->d=new Device[n];
            for (int i = 0; i < n; ++i) {
                this->d[i]=m.d[i];
            }
        }
        return *this;
    }
    MobileServis &operator+=(Device &dev){
        if (dev.getGodina() > 2019 || dev.getGodina() < 2000){
            throw InvalidProductionDate("Невалидна година на производство");
        }

        Device *tmp=new Device[n+1];
        for (int i = 0; i < n; ++i) {
            tmp[i]=d[i];
        }
        tmp[n++]=dev;
        delete []d;
        d=tmp;
        return *this;
    }
    void pecatiCasovi(){
        cout<<"Ime: "<<adresa<<endl;
        for (int i = 0; i < n; ++i) {
            cout<<d[i];
        }
    }
    ~MobileServis(){
        delete []d;
    }
};

int main()
{
    int testCase;
    cin >> testCase;
    char ime[100];
    int tipDevice;
    int godina;
    int n;
    Device devices[50];
    if (testCase == 1){
        cout << "===== Testiranje na klasite ======" << endl;
        cin >> ime;
        cin >> tipDevice;
        cin >> godina;
        Device ig(ime,(tip)tipDevice,godina);
        cin>>ime;
        MobileServis t(ime);
        cout<<ig;
    }
    if (testCase == 2){
        cout << "===== Testiranje na operatorot += ======" << endl;
        cin>>ime;
        cin >> n;
        MobileServis t(ime);
        for(int i=0;i<n;i++)
        {
            cin >> ime;
            cin >> tipDevice;
            cin >> godina;
            try {
                Device tmp(ime, (tip) tipDevice, godina);
                t += tmp;
            }
            catch (InvalidProductionDate &i){
                i.message();
            }
        }
        t.pecatiCasovi();
    }
    if (testCase == 3){
        cout << "===== Testiranje na isklucoci ======" << endl;
        cin>>ime;
        cin >> n;
        MobileServis t(ime);
        for(int i=0;i<n;i++)
        {
            cin >> ime;
            cin >> tipDevice;
            cin >> godina;
            try {
                Device tmp(ime, (tip) tipDevice, godina);
                t += tmp;
            }
            catch (InvalidProductionDate &i){
                i.message();
            }
        }
        t.pecatiCasovi();
    }
    if (testCase == 4){
        cout <<"===== Testiranje na konstruktori ======"<<endl;
        cin>>ime;
        cin >> n;
        MobileServis t(ime);
        for(int i=0;i<n;i++)
        {
            cin >> ime;
            cin >> tipDevice;
            cin >> godina;
            try {
                Device tmp(ime, (tip) tipDevice, godina);
                t += tmp;
            }
            catch (InvalidProductionDate &i){
                i.message();
            }
        }
        MobileServis t2 = t;
        t2.pecatiCasovi();
    }
    if (testCase == 5){
        cout << "===== Testiranje na static clenovi ======" << endl;
        cin>>ime;
        cin >> n;
        MobileServis t(ime);
        for(int i=0;i<n;i++)
        {
            cin >> ime;
            cin >> tipDevice;
            cin >> godina;
            try {
                Device tmp(ime, (tip) tipDevice, godina);
                t += tmp;
            }
            catch (InvalidProductionDate &i){
                i.message();
            }
        }
        t.pecatiCasovi();
        cout << "===== Promena na static clenovi ======" << endl;
        Device::setPocetniCasovi(2);
        t.pecatiCasovi();
    }

    if (testCase == 6){
        cout << "===== Testiranje na kompletna funkcionalnost ======" << endl;
        cin>>ime;
        cin >> n;
        MobileServis t(ime);
        for(int i=0;i<n;i++)
        {
            cin >> ime;
            cin >> tipDevice;
            cin >> godina;
            try {
                Device tmp(ime, (tip) tipDevice, godina);
                t += tmp;
            }
            catch (InvalidProductionDate &i){
                i.message();
            }
        }
        Device::setPocetniCasovi(3);
        MobileServis t2 = t;
        t2.pecatiCasovi();
    }

    return 0;

}
