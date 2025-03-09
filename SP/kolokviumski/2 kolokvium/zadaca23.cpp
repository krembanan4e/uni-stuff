//Да се напише рекурзивна функција преку која бројот ќе се трансформира на тој начин што секоја непарна цифра ќе се намали за 1, 
//а парните цифри ќе бидат заменети со нула. Функцијата треба да го врати трансформираниот број. Да се напише и главна програма која ќе ја тестира работата на функцијата.

//input            output
//93854            Brojot e 82040

#include <iostream>
using namespace std;

void transformirajBroj(int n){
    if (n==0)
        return;

    int cifra = n%10;

    if ( cifra%2 == 0 ){
        if ((n/10%10)%2==0){
            cout<<0;
            return;
        }
        else {
            transformirajBroj(n / 10);
            cout << 0;
        }
    }
    else {
        transformirajBroj(n/10);
        cout<<cifra-1;
    }
}


int main(){
   int n;
   cin>>n;
   cout<<"Brojot e ";
   transformirajBroj(n);

    return 0;
}
