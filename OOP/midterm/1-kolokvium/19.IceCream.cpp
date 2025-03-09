/*
Да се дефинира класа IceCream во која се чуваат податоци за:

име (динамичка низа од знаци),
состав (низа од знаци, најмногу 100)
цена (децимален број),
попуст (цел број, изразен во проценти) иницијална вредност 0.
За потребите на класата да се имплементираат:

соодветни конструктори и деструктор (да се погледнат повиците во функцијата main)
оператор << за печатење на податоците за сладоледот во следниов формат:
име: состав цена [цена на попуст]

делот „цена на попуст“ се печати само ако за сладоледот се нуди попуст (вредноста на попустот е поголема од нула)

оператор ++ во префикс нотација за зголемување на попустот за 5
оператор + - за собирање на објект од класата IceCream со низа од знаци. 
Собирањето се реализира на начин што името на новиот сладолед се добива со спојување на името на сладоледот и низата од знаци одделени со „ + “. 
Цената на новиот сладолед се зголемува за 10, а попустот и составот на сладоледот остануваат исти.
метод void setDiscount(int discount) со кој може да се смени вредноста на попустот. Дозволените вредности на попустот се во интервалот [0,100]
метод void setName(char* name) со кој се менува името на сладоледот.
Да се креира класа IceCreamShop во која се чува:

име на продавницата (низа од знаци, најмногу 50)
динамички резервирано поле од објекти од класата IceCream
број на сладоледи во полето (цел број).
За оваа класа да се обезбедат:

соодветни конструктори и деструктор (погледнете ги повиците во main функцијата)
оператор += за додавање нов објект од класата IceCream во полето
оператор << за печатење на листа од сите сладоледи во продавницата. Прво се печати името на продавницата, а потоа се печатат податоците за сите сладоледи одделени со нов ред.
For example:

Input	Result
3
FINKI Ice Cream
3
Strawberry Ice Cream in Lemon Bowls
Strawberry ice cream, Lemons
100
Caramel Apple Delight
Caramel Delight ice cream, Apples
120
Dreyer’s Ice Cream Blueberry Pie
French Vanilla ice cream, Graham cracker pie crust, blueberries
60
====== TESTING IceCreamShop ======
CONSTRUCTOR
OPERATOR +=
FINKI Ice Cream
Strawberry Ice Cream in Lemon Bowls: Strawberry ice cream, Lemons 100 
Caramel Apple Delight: Caramel Delight ice cream, Apples 120 
Dreyer’s Ice Cream Blueberry Pie: French Vanilla ice cream, Graham cracker pie crust, blueberries 60
*/

#include <iostream>
#include <cstring>

using namespace std;

class IceCream{
private:
    char* ime;
    char sostav[100];
    float cena;
    int popust;
public:
    IceCream(){
        this->ime = new char[0];
        strcpy(this->sostav,"");
        this->cena = 0;
        this->popust = 0;
    }
    IceCream(char* ime, char* sostav, float cena){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        strcpy(this->sostav,sostav);
        this->cena = cena;
        this->popust = 0;
    }
    IceCream(const IceCream &i){
        this->ime = new char[strlen(i.ime)+1];
        strcpy(this->ime, i.ime);
        strcpy(this->sostav,i.sostav);
        this->cena = i.cena;
        this->popust = i.popust;
    }
    IceCream &operator=(const IceCream &i){
        if(this!=&i){
            delete []ime;
            this->ime = new char[strlen(i.ime)+1];
            strcpy(this->ime, i.ime);
            strcpy(this->sostav,i.sostav);
            this->cena = i.cena;
            this->popust = i.popust;
        }
        return *this;
    }
    friend ostream &operator<<(ostream &out, IceCream &i){
        out<<i.ime<<": "<<i.sostav<<" "<<i.cena;
        if(i.popust > 0){
            out<<" ("<<i.cena - (i.cena * i.popust / 100)<<") ";
        }
        //out<<endl;
        return out;
    }
    IceCream operator++(){
        this->popust = popust+5;
        return *this;
    }
    IceCream operator+(char *ime){
        IceCream nov(*this); //kopija
        delete []nov.ime;
        nov.ime = new char[strlen(this->ime) + strlen(ime) + 4];
        strcpy(nov.ime, this->ime);
        strcat(nov.ime, " + ");
        strcat(nov.ime, ime);
        nov.cena += 10;
        return nov;
    }
    void setDiscount(int popust){
        if(popust>0 && popust<100){
            this->popust = popust;
        }
    }
    void setName(char *name){
        delete []ime;
        this->ime = new char[strlen(name)+1];
        strcpy(this->ime, name);
    }
    ~IceCream(){
        delete []ime;
    }
};

class IceCreamShop {
private:
    char ime[50];
    IceCream *niza;
    int n;
public:
    IceCreamShop(){
        strcpy(this->ime, "");
        this->n = 0;
        this->niza = new IceCream[n];
    }
    IceCreamShop(char *ime){
        strcpy(this->ime, ime);
        this->n = 0;
        this->niza = new IceCream[n];
    }
    IceCreamShop(const IceCreamShop &ic){
        strcpy(this->ime, ic.ime);
        this->n = ic.n;
        this->niza = new IceCream[n];
        for (int i = 0; i < n; ++i) {
            this->niza[i] = ic.niza[i];
        }
    }
    IceCreamShop &operator=(const IceCreamShop &ic){
        if(this!=&ic){
            delete []niza;
            strcpy(this->ime, ic.ime);
            this->n = ic.n;
            this->niza = new IceCream[n];
            for (int i = 0; i < n; ++i) {
                this->niza[i] = ic.niza[i];
            }
        }
        return  *this;
    }
    IceCreamShop& operator+=(const IceCream &ic){
        IceCream *tmp = new IceCream[n+1];
        for (int i = 0; i < n; ++i) {
            tmp[i] = niza[i];
        }
        tmp[n++] = ic;
        delete []niza;
        niza = tmp;
        return *this;
    }
    friend ostream &operator<<(ostream &out, const IceCreamShop &ic){
        out<<ic.ime<<endl;
        for (int i = 0; i < ic.n; ++i) {
            out<<ic.niza[i]<<endl;
        }
        return out;
    }
    ~IceCreamShop(){
        delete []niza;
    }
};

int main() {
    char name[100];
    char ingr[100];
    float price;
    int discount;

    int testCase;

    cin >> testCase;
    cin.get();
    if(testCase == 1) {
        cout << "====== TESTING IceCream CLASS ======" << endl;
        cin.getline(name,100);
        cin.getline(ingr,100);
        cin >> price;
        cin >> discount;
        cout << "CONSTRUCTOR" << endl;
        IceCream ic1(name, ingr, price);
        ic1.setDiscount(discount);
        cin.get();
        cin.getline(name,100);
        cin.getline(ingr,100);
        cin >> price;
        cin >> discount;
        IceCream ic2(name, ingr, price);
        ic2.setDiscount(discount);
        cout << "OPERATOR <<" << endl;
        cout << ic1 << endl;
        cout << ic2 << endl;
        cout << "OPERATOR ++" << endl;
        ++ic1;
        cout << ic1 << endl;
        cout << "OPERATOR +" << endl;
        IceCream ic3 = ic2 + "chocolate";
        cout << ic3 << endl;
    } else if(testCase == 2) {
        cout << "====== TESTING IceCream CONSTRUCTORS ======" << endl;
        cin.getline(name,100);
        cin.getline(ingr,100);
        cin >> price;
        //cin >> discount;
        cout << "CONSTRUCTOR" << endl;
        IceCream ic1(name, ingr, price);
        cout << ic1 << endl;
        cout << "COPY CONSTRUCTOR" << endl;
        IceCream ic2(ic1);
        cin.get();
        cin.getline(name,100);
        ic2.setName(name);
        cout << ic1 << endl;
        cout << ic2 << endl;
        cout << "OPERATOR =" << endl;
        ic1 = ic2;
        cin.getline(name,100);
        ic2.setName(name);
        cout << ic1 << endl;
        cout << ic2 << endl;

        cin >> discount;
        ic1.setDiscount(discount);


    } else if(testCase == 3) {
        cout << "====== TESTING IceCreamShop ======" << endl;
        char icsName[50];
        cin.getline(icsName,100);
        cout << "CONSTRUCTOR" << endl;
        IceCreamShop ics(icsName);
        int n;
        cin >> n;
        cout << "OPERATOR +=" << endl;
        for(int i = 0; i < n; ++i) {
            cin.get();
            cin.getline(name,100);
            cin.getline(ingr,100);
            cin >> price;
            IceCream ic(name, ingr, price);
            ics += ic;
        }
        cout << ics;
    } else if(testCase == 4) {
        cout << "====== TESTING IceCreamShop CONSTRUCTORS ======" << endl;
        char icsName[50];
        cin.getline(icsName,100);
        IceCreamShop ics(icsName);
        int n;
        cin >> n;
        for(int i = 0; i < n; ++i) {
            cin.get();
            cin.getline(name,100);
            cin.getline(ingr,100);
            cin >> price;
            IceCream ic(name, ingr, price);
            ics += ic;
        }
        IceCream x("FINKI fruits", "strawberry ice cream, raspberry ice cream, blueberry ice cream", 60);
        IceCreamShop icp = ics;
        ics+=x;
        cout << ics << endl;
        cout << icp << endl;
    }


    return 0;
}
