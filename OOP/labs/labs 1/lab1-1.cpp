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
