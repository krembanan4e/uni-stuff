/*Да се дефинира класа Account која претставува банкарска сметка на еден корисник. За класата Account се чуваат:
Име на корисникот (текстуална низа од 30 знаци)
Идентификациски број (цел број)
Тип на корисник (енумерациски тип, физичко или правно лице) 
салдо (децимален број)

Идентификацискиот број е единствен за секој корисник, неговата почетна вредност е 111110.  
Да се обезбеди секвенцијално генерирање на овој број, така што првата сметка ќе има идентификациски број 111111, втората 111112, третата 111113 итн. (5 поени)

За оваа класа да се обезбедат потребните конструктори, set и get методи. (5 поени)
Да се имплементира оператор за печатење << со кој ќе се печатат информациите за секој објект во формат: [идентификациски број]-[име] [тип на корисник] [салдо] (5 поени).
Да се имплементира оператор -= кој како аргумент ќе прима реален број, што ќе ја означува провизијата која треба да се плати кон банката, односно да се одземе од салдото на сметката. (5 поени)

Потоа, да се дефинира класа Bank во која се чуваат информации за:
Име на банка (текстуална низа од 20 знаци)
Листа од сметки (динамички алоцирана низа објекти од класата Account)
Број на сметки (број на елементи во низата од сметки, иницијално е 0)

За оваа класа да се дефинираат потребните конструктори, деструктор, set и get методи.  (5 поени).
Оператор за печатење << во формат [име] и сите сметки поединечно. (види формат во тест примерите). (5 поени)
Oператор += за додавање нова сметка во банката. Во банката сметките се менаџираат според нивниот идентификациски број кој е уникатен. 
Во банката не смее да се дозволи додавање нова сметка со идентификациски број кој веќе постои во банката (10 поени).
Оператор < кој споредува две банки според бројот на сметки во банката. (5 поени)

Да се дефинира метод void bankFee() - со кој банката наплатува месечна банкарска провизија за сите сметки на почеток на тековниот месец. 
Банкарската провизија се пресметува во зависност од тоа за каков тип на корисник се работи. За физички лица банкарската провизија изнесува 0.8% од парите кои се на сметката,
а за правни лица банкарската провизија е 1.5% од парите кои се на сметката. (10 поени)

Да се дефинира глобален метод leastLiquid() - кој прима низа од објекти од класатa Bank и бројот на банки, а ја враќа онаа банка која има најмал број на сметки. 
Доколку повеќе банки имаат ист број на сметки, се враќа онаа која е прва најдена. (5 поени)


input
1
output
TESTING ACCOUNT OPERATOR <<
111111 - Paul person 32000
111112 - Globex company 500000
111113 - Anna person 8700
TEST PASSED


input
4
output
TESTING BANK OPERATOR += and <<
Capital One Bank
111111 - Paul person 32000
111112 - Globex Industries company 500000
111113 - Anna person 8700
TEST PASSED

*/


#include <iostream>
#include <cstring>
using namespace std;

//YOUR CODE HERE:
enum tip{fizichko, pravno};

class Account{
private:
    char ime[30];
    int id;
    static int ID;
    tip kojtip;
    float saldo;
public:
    Account(){}
    Account(char* ime, int kojtip, float saldo){
        strcpy(this->ime, ime);
        this->kojtip=(tip)kojtip;
        this->saldo=saldo;
        Account::zgolemiID();
        this->id=ID;
    }
    friend ostream &operator<<(ostream &o, Account &a){
        o<<a.id<<" - "<<a.ime<<" ";
        switch (a.kojtip) {
            case 0: o<<"person "; break;
            case 1: o<<"company "; break;
        }
        o<<a.saldo<<endl;
        return o;
    }
    Account &operator-= (float br){
        this->saldo = saldo-br;
        return *this;
    }
    static int zgolemiID(){
        return ID++;
    }
    int getID(){
        return id;
    }
    tip getTip(){
        return kojtip;
    }
    float getSaldo(){
        return saldo;
    }
    void setSaldo(float novo){
        this->saldo = novo;
    }
    ~Account(){}
};
int Account::ID=111110;

class Bank{
private:
    char ime[20];
    Account *niza;
    int n;
public:
    Bank(){
        strcpy(this->ime,"");
        this->n=0;
        this->niza = new Account[n];
    }
    Bank(char *ime){
        strcpy(this->ime, ime);
        this->n=0;
        this->niza = new Account[n];
    }
    Bank(const Bank &b){
        strcpy(this->ime, b.ime);
        this->n=b.n;
        this->niza = new Account[n];
        for (int i = 0; i < n; ++i) {
            this->niza[i] = b.niza[i];
        }
    }
    Bank &operator=(const Bank &b){
        if(this!=&b){
            delete []niza;
            strcpy(this->ime, b.ime);
            this->n=b.n;
            this->niza = new Account[n];
            for (int i = 0; i < n; ++i) {
                this->niza[i] = b.niza[i];
            }
        }
        return *this;
    }
    friend ostream &operator<<(ostream &o, const Bank &b){
        o<<b.ime<<endl;
        for (int i = 0; i < b.n; ++i) {
            o<<b.niza[i];
        }
        return o;
    }
    Bank &operator+= (Account &a){
        int counter=0;
        for (int i = 0; i < n; ++i) {
            if(niza[i].getID() == a.getID()){
                return *this;
            }
        }
            Account *tmp=new Account[n+1];
            for (int i = 0; i < n; ++i) {
                tmp[i] = niza[i];
            }
            tmp[n++]=a;
            delete []niza;
            niza=tmp;

        return *this;
    }
    bool operator< (Bank &b){
        return this->n < b.n;
    }
    void bankFee(){
        for (int i = 0; i < n; ++i) {
            if (niza[i].getTip() == 0){
                float novoSaldo = niza[i].getSaldo() - (niza[i].getSaldo() * 0.8 /100);
                niza[i].setSaldo(novoSaldo);
            }
            else{
                float novoSaldo = niza[i].getSaldo() - (niza[i].getSaldo() * 1.5 /100);
                niza[i].setSaldo(novoSaldo);
            }
        }
    }
    int getN(){
        return n;
    }
    ~Bank(){
        delete []niza;
    }
};

Bank &leastLiquid(Bank *niza, int n){
    int id=0;
    for (int i = 1; i < n; ++i) {
        if(niza[i].getN() < niza[id].getN()){
            id=i;
        }
    }
    return niza[id];
}

int main() {
    int testCase;
    cin>>testCase;
    if(testCase==0)
    {
        cout<<"TESTING ACCOUNT CONSTRUCTOR"<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex",1,500000);
        Account account3("Anna",0,8700);
        cout<<"TEST PASSED"<<endl;
    }else if(testCase==1)
    {
        cout<<"TESTING ACCOUNT OPERATOR <<"<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex",1,500000);
        Account account3("Anna",0,8700);
        cout<<account1;
        cout<<account2;
        cout<<account3;
        cout<<"TEST PASSED"<<endl;
    } else if(testCase==2)
    {
        cout<<"TESTING ACCOUNT OPERATOR -="<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex Industries",1,500000);
        Account account3("Anna",0,8700);
        cout<<account1;
        cout<<account2;
        cout<<account3;
        account1-=350;
        account2-=20000;
        account3-=500;
        cout<<"===== DECREASE ====="<<endl;
        cout<<account1;
        cout<<account2;
        cout<<account3;
        cout<<"TEST PASSED"<<endl;
    }else if(testCase==3)
    {
        cout<<"TESTING BANK CONSTRUCTOR and <<"<<endl;
        Bank bank1("Capital One Bank");
        cout<<bank1;
        cout<<"TEST PASSED"<<endl;
    }else if(testCase==4)
    {
        cout<<"TESTING BANK OPERATOR += and <<"<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex Industries",1,500000);
        Account account3("Anna",0,8700);
        Bank bank1("Capital One Bank");
        bank1+=account1;
        bank1+=account2;
        bank1+=account3;
        cout<<bank1;
        cout<<"TEST PASSED"<<endl;
    }
    else if(testCase==5)
    {
        cout<<"TESTING BANK OPERATOR += and <<"<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex Industries",1,500000);
        Account account3("Anna",0,8700);
        Bank bank1("Capital One Bank");
        bank1+=account1;
        bank1+=account2;
        bank1+=account3;
        bank1+=account1;
        cout<<bank1;
        cout<<"TEST PASSED"<<endl;
    }
    else if(testCase==6)
    {
        cout<<"TESTING BANK COPY-CONSTRUCTOR and OPERATOR ="<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex Industries",1,500000);
        Account account3("Anna",0,8700);
        Account account4("Umbrella Corporation",1,300000);
        Account account5("Theo",0,15500);
        Bank bank1("Capital One Bank");
        bank1+=account1;
        bank1+=account2;
        bank1+=account3;
        Bank bank2(bank1);
        Bank bank4;
        {
            Bank bank3("First National Bank");
            bank3+=account4;
            bank3+=account5;
            bank4=bank3;
        }
        cout<<bank2;
        cout<<bank4;
        cout<<"TEST PASSED"<<endl;
    }else if(testCase==7)
    {
        cout<<"TESTING BANK OPERATOR < "<<endl;
        Account account1("Paul",0,32000);
        Account account2("Globex Industries",1,500000);
        Account account3("Anna",0,8700);
        Account account4("Umbrella Corporation",1,300000);
        Account account5("Theo",0,15500);
        Bank bank1("Capital One Bank");
        bank1+=account1;
        bank1+=account2;
        bank1+=account3;
        Bank bank3("First National Bank");
        bank3+=account4;
        bank3+=account5;
        if(bank1<bank3)
        {
            cout<<"TEST FAILED"<<endl;
        }
        else
        {
            cout<<"TEST PASSED"<<endl;
        }
    }else if(testCase==8)
    {
        cout<<"TESTING METHOD bankFee()"<<endl;
        char name[30],name1[30];
        int type, numberOfBanks, numberOfAccounts;
        float money;
        cin>>numberOfBanks;
        cin.ignore();
        Bank banks[10];
        for(int i=0;i<numberOfBanks;i++)
        {
            cin.getline(name,20);
            banks[i]=Bank(name);
            cin>>numberOfAccounts;
            cin.ignore();
            Account accounts[10];
            for(int j=0;j<numberOfAccounts;j++)
            {
                cin >> name1 >> type >> money;
                cin.ignore();
                accounts[j]=Account(name1,type,money);
                banks[i]+=accounts[j];
            }
        }
        for(int i=0;i<numberOfBanks;i++)
        {
            cout<<banks[i];
            cout<<"FEE-PAID"<<endl;
            banks[i].bankFee();
            cout<<banks[i];
        }
    }else if(testCase==9)
    {
        cout<<"TESTING METHOD leastLiquid()"<<endl;
        char name[30],name1[30];
        int type, numberOfBanks, numberOfAccounts;
        float money;
        cin>>numberOfBanks;
        cin.ignore();
        Bank banks[10];
        for(int i=0;i<numberOfBanks;i++)
        {
            cin.getline(name,20);
            banks[i]=Bank(name);
            cin>>numberOfAccounts;
            cin.ignore();
            Account accounts[10];
            for(int j=0;j<numberOfAccounts;j++)
            {
                cin >> name1 >> type >> money;
                cin.ignore();
                accounts[j]=Account(name1,type,money);
                banks[i]+=accounts[j];
            }
        }
        cout<<leastLiquid(banks,numberOfBanks);
    }
    return 0;
}
