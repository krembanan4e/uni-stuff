/*Да се имплементира класа Flight во која се чува:

кодот на летот(низа од најмногу 40 знаци)
градот на заминување(низа од најмногу 100 знаци)
градот на пристигнување(низа од најмногу 100 знаци)
цена на лет(децимален број)
цена на багаж(децимален број)
За оваа класа да се имплементираат следните методи:

функција calculateTotalPrice() што ја враќа збир од цената на летот и цената на багажот
функција displayInfo() за печатење на летот во формат:
[ Код Од До Цена]

Да се имплементира класа EconomyFlight во која покрај основните информации за летот дополнително се чува:

број на седиште(низа од најмногу 4 карактери)
Во оваа класа да се препокрие соодветно функцијата calculateTotalPrice() така што на основната цена на летот ќе се пресмета LOYALTY_DISCOUNT што е статичка променлива во класата 
која изнесува 20% попуст. Дополнително доколку првата буква од кодот на седиштето е C или F цената на летот се зголемува 30% затоа што седиштето е до прозорецот.
Доколку при пресметувањето на цената првата буква од кодот на седиштето не е A, B, C, D, E, F да се фрли исклучок InvalidSeatNumberException кој ќе ја печати пораката 
"Invalid Seat Number Exception". LOYALTY_DISCOUNT е статичка променлива и може да ја промени само авио компанијата. 

Соодветно во класата исто така да се препокрие функцијата displayInfo која ќе печати во формат:

[ Код Од До Седиште

Total price: Вкупната Цена ]

Дополнително во класите да се имплементираат соодветно сите потребни работи.

For example:

Input	
1
5
W775 Skopje Vienna 120 50 C25
G667 Rome Paris 100 25 A18
A556 Istanbul Amsterdam 200 0 B05
S449 Skopje Berlin 80 45 E14
K119 Porto Madrid 95 30 F18

Output
===== Testiranje na klasite ======
W775 Skopje-Vienna C25
Total Price: $176.8
G667 Rome-Paris A18
Total Price: $100
A556 Istanbul-Amsterdam B05
Total Price: $160
S449 Skopje-Berlin E14
Total Price: $100
K119 Porto-Madrid F18
Total Price: $130
*/

#include <iostream>
#include <cstring>
#include <string>

using namespace std;

class InvalidSeatNumberException{
private:
    string msg;
public:
    InvalidSeatNumberException(string msg){
        this->msg=msg;
    }
    void message(){
        cout<<msg<<endl;
    }
};

class Flight{
protected:
    char kod[40];
    char zaminuvanje[100];
    char pristignuvanje[100];
    float cenaLet;
    float cenaBagaz;
public:
    Flight(){}
    Flight(char *kod, char *zaminuvanje, char *pristignuvanje, float cenaLet, float cenaBagaz){
        strcpy(this->kod,kod);
        strcpy(this->zaminuvanje,zaminuvanje);
        strcpy(this->pristignuvanje,pristignuvanje);
        this->cenaLet=cenaLet;
        this->cenaBagaz=cenaBagaz;
    }
    virtual float calculateTotalPrice(){
        return cenaLet+cenaBagaz;
    }
    virtual void displayInfo(){
        cout<<kod<<" "<<zaminuvanje<<"-"<<pristignuvanje<<" "<<calculateTotalPrice()<<endl;
    }
    virtual ~Flight(){}
};

class EconomyFlight : public Flight{
private:
    char sediste[4];
    static float LOYALTY_DISCOUNT;
public:
    EconomyFlight():Flight(){}
    EconomyFlight(Flight &f, char* sediste):Flight(f){
        for (int i = 0; i < 4; ++i) {
            this->sediste[i]=sediste[i];
        }
    }
    static void setLoyaltyDiscount(float l){
        LOYALTY_DISCOUNT=l;
    }
    float calculateTotalPrice(){
        float osnovna=Flight::calculateTotalPrice();
        osnovna*=(1-LOYALTY_DISCOUNT/100);
        if(sediste[0]=='C' || sediste[0]=='F'){
            osnovna*=1.3;
        }
        if (sediste[0]!='A' && sediste[0]!='B' && sediste[0]!='C' && sediste[0]!='D' && sediste[0]!='E' && sediste[0]!='F'){
            throw InvalidSeatNumberException("Invalid Seat Number Exception");
        }
        return osnovna;
    }
    void displayInfo(){
        cout<<kod<<" "<<zaminuvanje<<"-"<<pristignuvanje<<" "<<sediste<<endl;
        if (sediste[0]!='A' && sediste[0]!='B' && sediste[0]!='C' && sediste[0]!='D' && sediste[0]!='E' && sediste[0]!='F'){
            throw InvalidSeatNumberException("Invalid Seat Number Exception");
        }
        cout<<"Total Price: $"<<calculateTotalPrice()<<endl;
    }
    ~EconomyFlight(){}
};
float EconomyFlight::LOYALTY_DISCOUNT=20;

int main() {
    int testCase;
    cin>>testCase;
    char code[100];
    char from[100];
    char to[100];
    double price;
    double baggagePrice;
    char seatNumber[4];

    if(testCase == 1){
        cout << "===== Testiranje na klasite ======" << endl;
        int n;
        cin>>n;
        for(int i=0; i<n;i++){
            cin>>code>>from>>to>>price>>baggagePrice>>seatNumber;
            Flight f = Flight(code, from, to, price, baggagePrice);
            try {
                EconomyFlight ec = EconomyFlight(f, seatNumber);
                ec.displayInfo();
            }
            catch (InvalidSeatNumberException &e){
                e.message();
            }
        }
    }
    if(testCase == 2){
        cout << "===== Testiranje na isklucoci ======" << endl;
        int n;
        cin>>n;
        for(int i=0; i<n;i++){
            cin>>code>>from>>to>>price>>baggagePrice>>seatNumber;
            Flight f = Flight(code, from, to, price, baggagePrice);
            try {
                EconomyFlight ec = EconomyFlight(f, seatNumber);
                ec.displayInfo();
            }
            catch (InvalidSeatNumberException &e){
                e.message();
            }
        }
    }
    if(testCase == 3){
        cout << "===== Testiranje na static clenovi ======" << endl;
        cin>>code>>from>>to>>price>>baggagePrice>>seatNumber;
        Flight f = Flight(code, from, to, price, baggagePrice);
        try {
            EconomyFlight ec = EconomyFlight(f, seatNumber);
            ec.displayInfo();
            EconomyFlight::setLoyaltyDiscount(50);
            ec.displayInfo();
        }
        catch (InvalidSeatNumberException &e){
            e.message();
        }
    }

    return 0;
}
