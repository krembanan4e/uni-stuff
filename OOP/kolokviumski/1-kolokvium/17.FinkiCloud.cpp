/*
Фирмата FINKI Cloud има потреба од решение за управување со image датотеките од различните оперативни системи кои ги користат при сетирање на нови сервери. За таа цел потребно е да се дефинираат следниве класи:

OperativenSistem
Во класата OperativenSistem треба да се чуваат следниве податоци:

име на оперативниот систем (динамички алоцирана низа од знаци)
верзија (float)
тип (енумерација со можни вредности LINUX, UNIX, WINDOWS)
големина (во GB) (float)
Дополнително, во рамките на класата потребно е да се дефинира:

конструктори со и без параметри
copy constructor
destructor
преоптоварување на операторот =
метод за печатење на информациите - void pecati() (видете го излезот од тест примерите за структурата)
метод за проверка на еднаквост помеѓу два оперативни системи (два оперативни системи се еднакви ако имаат исто име, верзија, тип и големина) - bool ednakviSe(const OperativenSistem &os)
метод за споредба на верзии помеѓу два оперативни система - int sporediVerzija(const OperativenSistem &os), кој ќе враќа 0 доколку верзиите се исти, -1 доколку верзијата на оперативниот систем од аргументот е поголема и 1 во преостанатиот случај.
метод за проверка дали два оперативни системи се од иста фамилија. Два оперативни системи се од иста фамилија доколку имаат исто име и се од ист тип. bool istaFamilija(const OperativenSistem &sporedba)
Repozitorium
Во класата Repozitorium треба да се чуваат следниве податоци:

име на репозиториумот (низа од 20 знака)
динамички алоцирана низа од OperativenSistem
број на оперативни системи кои моментално се наоѓаат во репозиториумот (int)
Дополнително, во рамките на класата потребно е да се дефинира:

конструктор Repozitorium(const char *ime)
деструктор
метод void pecatiOperativniSistemi() кој ќе ги печати сите оперативни системи кои се дел од репозиториумот
метод void izbrishi(const OperativenSistem &operativenSistem) кој ќе го избрише оперативниот систем проследен како аргумент, доколку тој се наоѓа во репозиториумот. Да се користи методот ednakviSe за споредба на два оперативни система.
метод за додавање на оперативен систем (void dodadi(const OperativenSistem &nov)) кој ќе го има следново однесување:
Доколку веќе постои оперативен систем од иста фамилија (да се користи методот за проверка на фамилија) кој е постар од проследениот оперативен систем, тогаш постоечкиот оперативен систем се заменува со новиот.
Во секој друг случај, проследениот оперативен систем се додава како дополнителен во репозиториумот.
For example:

Input	
FINKICloud
2
Ubuntu
17.04
1
2.25
Ubuntu
16.04
1
1.25
Ubuntu
14.04
1
1.25

Output
Repozitorium: FINKICloud
Ime: Ubuntu Verzija: 17.04 Tip: 1 Golemina:2.25GB
Ime: Ubuntu Verzija: 16.04 Tip: 1 Golemina:1.25GB
=====Brishenje na operativen sistem=====
Repozitorium: FINKICloud
Ime: Ubuntu Verzija: 17.04 Tip: 1 Golemina:2.25GB
Ime: Ubuntu Verzija: 16.04 Tip: 1 Golemina:1.25GB

*/

#include <iostream>
#include <cstring>

using namespace std;

enum Tip{LINUX, UNIX, WINDOWS};

class OperativenSistem{
private:
    char *ime;
    float verzija;
    Tip kojtip;
    float gb;
public:
    OperativenSistem(){
        this->ime=new char[0];
        this->verzija = 0;
        this->kojtip = LINUX;
        this->gb = 0;
    }
    OperativenSistem(char* ime, float verzija, Tip kojtip, float gb){
        this->ime=new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->verzija = verzija;
        this->kojtip = kojtip;
        this->gb = gb;
    }
    OperativenSistem(const OperativenSistem &o){
        this->ime=new char[strlen(o.ime)+1];
        strcpy(this->ime, o.ime);
        this->verzija = o.verzija;
        this->kojtip = o.kojtip;
        this->gb = o.gb;
    }
    OperativenSistem &operator=(const OperativenSistem &o){
        if (this!=&o){
            delete []ime;
            this->ime=new char[strlen(o.ime)+1];
            strcpy(this->ime, o.ime);
            this->verzija = o.verzija;
            this->kojtip = o.kojtip;
            this->gb = o.gb;
        }
        return *this;
    }
    void pecati(){
        cout<<"Ime: "<<ime<<" Verzija: "<<verzija<<" Tip: "<<kojtip<<" Golemina:"<<gb<<"GB";
    }
    bool ednakviSe(const OperativenSistem &os){
        return (strcmp(this->ime, os.ime)==0 && this->verzija==os.verzija && this->kojtip==os.kojtip && this->gb==os.gb);
    }

    //0-isti, -1-od argumentot e pogolema verzijata, 1-od this e pogolema
    int sporediVerzija(const OperativenSistem &os){
        if (this->verzija > os.verzija){
            return 1;
        }
        else if(os.verzija > this->verzija){
            return -1;
        }
        else{
            return 0;
        }
    }
    bool istaFamilija(const OperativenSistem &sporedba){
        return (strcmp(this->ime, sporedba.ime)==0 && this->kojtip==sporedba.kojtip);
    }
    ~OperativenSistem(){
        delete []ime;
    }
};

class Repozitorium{
private:
    char repName[20];
    OperativenSistem *nizaOS;
    int n; //br na op sistemi
public:
    Repozitorium(){
        strcpy(this->repName, "");
        this->n = 0;
        this->nizaOS = new OperativenSistem[0];
    }
    Repozitorium(const char* repName){
        strcpy(this->repName, repName);
        this->n = 0;
        this->nizaOS = new OperativenSistem[n];
    }
//    Repozitorium(const Repozitorium &r){
//        strcpy(this->repName, r.repName);
//        this->n = r.n;
//        this->nizaOS = new OperativenSistem[n];
//        for (int i = 0; i < n; ++i) {
//            this->nizaOS[i] = r.nizaOS[i];
//        }
//    }
//    Repozitorium &operator=(const Repozitorium &r){
//        if(this!=&r){
//            delete []nizaOS;
//            strcpy(this->repName, r.repName);
//            this->n = r.n;
//            this->nizaOS = new OperativenSistem[n];
//            for (int i = 0; i < n; ++i) {
//                this->nizaOS[i] = r.nizaOS[i];
//            }
//        }
//        return *this;
//    }
    void pecatiOperativniSistemi(){
        cout << "Repozitorium: " << repName << endl;
        for (int i = 0; i < n; ++i) {
            nizaOS[i].pecati();
            cout<<endl;
        }
    }

    void izbrishi(const OperativenSistem &operativenSistem){

        OperativenSistem *tmp = new OperativenSistem[n];
        int j=0; //brojac za tmp

        for (int i = 0; i < n; ++i) {
            if (!this->nizaOS[i].ednakviSe(operativenSistem)){
                tmp[j++] = nizaOS[i];
            }
        }
        n=j;
        delete []nizaOS;
        nizaOS = tmp;
    }

    void dodadi(const OperativenSistem &nov){
        bool najde=false;
        for (int i = 0; i < n; ++i) {
            if (this->nizaOS[i].istaFamilija(nov)){
                if (this->nizaOS[i].sporediVerzija(nov)==-1){
                    nizaOS[i] = nov;
                    najde=true;
                }
            }
        }
        if (!najde){
            OperativenSistem *tmp = new OperativenSistem[n+1];
            //int j=0; //brojac za tmp

            for (int i = 0; i < n; ++i) {
                tmp[i] = nizaOS[i];
            }
            tmp[n] = nov;
            delete []nizaOS;
            nizaOS = tmp;
            n++;
        }
    }

    ~Repozitorium(){
        delete []nizaOS;
    }
};

int main() {
    char repoName[20];
    cin>>repoName;
    Repozitorium repozitorium=Repozitorium(repoName);
    int brojOperativniSistemi = 0;
    cin>>brojOperativniSistemi;
    char ime[20];
    float verzija;
    int tip;
    float golemina;
    for (int i = 0; i<brojOperativniSistemi; i++){
        cin>>ime;
        cin>>verzija;
        cin>>tip;
        cin>>golemina;
        OperativenSistem os = OperativenSistem(ime, verzija, (Tip)tip, golemina);
        repozitorium.dodadi(os);
    }

    repozitorium.pecatiOperativniSistemi();
    cin>>ime;
    cin>>verzija;
    cin>>tip;
    cin>>golemina;
    OperativenSistem os = OperativenSistem(ime, verzija, (Tip)tip, golemina);
    cout<<"=====Brishenje na operativen sistem====="<<endl;
    repozitorium.izbrishi(os);
    repozitorium.pecatiOperativniSistemi();
    return 0;
}
