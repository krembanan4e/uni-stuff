/*
Да се дефинира класа Пица за која ќе се чуваат податоци за:

име на пицата (низа од 15 знаци)
цена (цел број)
состојки (динамички алоцирана низа од знаци)
намалување на цената во проценти (цел број) - ако пицата не е на промоција намалувањето има вредност нула, во спротивно, вредност поголема од нула и не поголема од 100.
За потребите на оваа класа да се креираат потребните конструктори и да се напише соодветен деструктор. Дополнително за оваа класа да се дефинира функцијата:

pecati() - функција во која ќе се печатат податоците за пицата во следниот формат: име - состојки, цена.
istiSe(Pica p) - функција за споредба на две пици според состојките :
Да се дефинира класа Picerija во која се чуваат:

име (низа од максимум 15 знаци)
динмички алоцирана низа од објекти од класата Pica
број на пици (цел број)
За потребите на оваа класа да се дефинираат потребните конструктори и да се напише соодветен деструктор. Да се имплементираат и следниве методи:

dodadi(Pica P) - за додавање нова пица во пицеријата, но само ако не постои иста во низата (нема пица со исти состојки со пицата што треба да се додаде).
void piciNaPromocija() - се печатат сите пици од пицеријата што се на промоција во формат : име - состојки, цена, цена со попуст.
For example:

Input	
FINKI-Pica
4
Margarita
200
Domaten sos, kaskaval, maslinovo maslo
0
Napolitana 
210
Domaten sos, kaskaval, svezi sampinjoni, maslinovo maslo
0
Kapricioza 
210
Domaten sos, kaskaval, sunka, svezi sampinjoni
30
Vegetarijana
230
Domaten sos, kaskaval, tikvici, svezi sampinjoni, piperka, domat, maslinki, rukola, pcenka
20
Pica-FINKI
Vegetarijana
230
Domaten sos, kaskaval, tikvici, svezi sampinjoni, piperka, domat, maslinki, rukola, pcenka
20

Output
FINKI-Pica
Pici na promocija:
Kapricioza  - Domaten sos, kaskaval, sunka, svezi sampinjoni, 210 147
Vegetarijana - Domaten sos, kaskaval, tikvici, svezi sampinjoni, piperka, domat, maslinki, rukola, pcenka, 230 184
Pica-FINKI
Pici na promocija:
Kapricioza  - Domaten sos, kaskaval, sunka, svezi sampinjoni, 210 147
Vegetarijana - Domaten sos, kaskaval, tikvici, svezi sampinjoni, piperka, domat, maslinki, rukola, pcenka, 230 184
*/

#include <iostream>
#include <cstring>

using namespace std;

class Pica{
private:
    char ime[15];
    int cena;
    char *sostojki;
    int namaluvanje;
public:
    Pica(char* ime="", int cena=0, char* sostojki="", int namaluvanje=0){
        strcpy(this->ime, ime);
        this->cena = cena;
        this->sostojki = new char[strlen(sostojki)+1];
        strcpy(this->sostojki, sostojki);
        this->namaluvanje = namaluvanje;
    }
    Pica(const Pica &p){
        strcpy(this->ime, p.ime);
        this->cena = p.cena;
        this->sostojki = new char[strlen(p.sostojki)+1];
        strcpy(this->sostojki, p.sostojki);
        this->namaluvanje = p.namaluvanje;
    }
    Pica &operator=(const Pica &p){
        if (this!=&p){
            strcpy(this->ime, p.ime);
            this->cena = p.cena;
            delete []sostojki;
            this->sostojki = new char[strlen(p.sostojki)+1];
            strcpy(this->sostojki, p.sostojki);
            this->namaluvanje = p.namaluvanje;
        }
        return *this;
    }
    ~Pica(){
        delete []sostojki;
    }
    void pecati(){
        cout<<ime<<" - "<<sostojki<<", "<<cena;
    }
    bool istiSe(Pica &p){
        return (strcmp(sostojki, p.sostojki)==0); //0 ak se isti, 1 ak ne se isti
    }
    int getNamaluvanje(){
        return namaluvanje;
    }
    int getCena(){
        return cena;
    }
};

class Picerija{
private:
    char ime[15];
    Pica *pici;
    int n;
public:
    Picerija(char* ime=""){
        strcpy(this->ime, ime);
        this->pici = new Pica[0]; //ko ke iame gore broj n togas e [0]???
        this->n = 0;
    }
    Picerija(const Picerija &p){
        strcpy(this->ime, p.ime);
        this->n = p.n;
        this->pici = new Pica[n];
        for (int i = 0; i < n; ++i) {
            this->pici[i] = p.pici[i];
        }
    }
    Picerija &operator=(const Picerija &p){
        if (this!=&p){
            strcpy(this->ime, p.ime);
            this->n = p.n;
            delete []pici;
            this->pici = new Pica[n];
            for (int i = 0; i < n; ++i) {
                this->pici[i] = p.pici[i];
            }
        }
        return *this;
    }
    ~Picerija(){
        delete []pici;
    }
    void setIme(char* ime){
        strcpy(this->ime, ime);
    }
    char* getIme(){
        return ime;
    }
    Picerija &operator+=(Pica &p){
        bool imaIsta= false;
        for (int i = 0; i < n; ++i) {
            if(pici[i].istiSe(p)){ //ako i-tata pica e ista so p-tata
                imaIsta=true; //najde ista pica
            }
        }
        if(!imaIsta){
            Pica *tmp = new Pica[n+1];
            for (int i = 0; i < n; ++i) {
                tmp[i] = pici[i];
            }
            tmp[n++]=p;
            delete []pici; //izbirisi ja starata niza od pici
            pici = tmp;
        }
        return *this;
    }
    void piciNaPromocija(){
        //cout<<ime<<endl;
        //cout<<"Pici na promocija:"<<endl;
        for (int i = 0; i < n; ++i) {
            if(pici[i].getNamaluvanje()!=0){ //ako namaluvanjeto ne e 0 togas e na promocija
                pici[i].pecati(); //ime, sostojki, cena
                cout<<" "<<pici[i].getCena() * (1 - pici[i].getNamaluvanje() / 100.0)<<endl;
            }
        }
    }
};

int main() {

    int n;
    char ime[15];
    cin >> ime;
    cin >> n;

    Picerija p1(ime);
    for (int i = 0; i < n; i++){
        char imp[100];
        cin.get();
        cin.getline(imp, 100);
        int cena;
        cin >> cena;
        char sostojki[100];
        cin.get();
        cin.getline(sostojki, 100);
        int popust;
        cin >> popust;
        Pica p(imp, cena, sostojki, popust);
        p1+=p;
    }

    Picerija p2 = p1;
    cin >> ime;
    p2.setIme(ime);
    char imp[100];
    cin.get();
    cin.getline(imp, 100);
    int cena;
    cin >> cena;
    char sostojki[100];
    cin.get();
    cin.getline(sostojki, 100);
    int popust;
    cin >> popust;
    Pica p(imp, cena, sostojki, popust);
    p2+=p;

    cout << p1.getIme() << endl;
    cout << "Pici na promocija:" << endl;
    p1.piciNaPromocija();

    cout << p2.getIme() << endl;
    cout << "Pici na promocija:" << endl;
    p2.piciNaPromocija();

    return 0;
}
