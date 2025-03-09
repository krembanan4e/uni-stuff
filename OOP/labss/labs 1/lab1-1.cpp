/* Да се напише програма во која од стандарден влез се внесува бројот N (бројот на трансакции), 
а потоа N трансакциски сметки и како резултат ги печати идентификацискиот број и вкупната сума (со провизија) на сите трансакции платени со кредитна картичка. 
Во случај да нема трансакција платена со кредитна картичка да се испечати "No credit card transaction".

Во структурата Трансакција (Transaction) треба да се чуваат следните информации:
- Идентификациски број (int)
- Платена сума (int)
- Провизија (int)
- Дали е платено со дебитна или кредитна картичка (0 - дебитна, 1 - кредитна)

Ограничување: 0 < N < 100
   
input
3
1 100 10 0
2 202 20 1
3 10 1 1
----------------
output
2 222
3 11

*/

#include <iostream>

using namespace std;

struct Transaction{
    int id_broj;
    int platena_suma;
    int provizija;
    int karticka;

    void print(){
        cout<<id_broj<<" "<<platena_suma+provizija<<endl;
    }
};

int main(){
    int N;
    cin>>N;
    if (N>100 || N<0){
        return -1;
    }
    Transaction tr[N];
    for (int i = 0; i < N; ++i) {
        cin>>tr[i].id_broj;
        cin>>tr[i].platena_suma;
        cin>>tr[i].provizija;
        cin>>tr[i].karticka;
    }

    bool flag=false;
    for (int i = 0; i < N; ++i) {
        if (tr[i].karticka == 1){
            tr[i].print();
            flag=true;
        }
    }

    if (!flag){
        cout<<"No credit card transaction"<<endl;
    }

    return 0;
}
