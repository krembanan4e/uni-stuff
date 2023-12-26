/* Да се напише програма која ќе ја отпечати поднизата на дадена текстуална низа (што се внесува од тастатура)
 определена со позицијата и должината, што како параметри се внесуваат од тастатура.
 Поднизата започнува од знакот што се наоѓа на соодветната позиција во текстуалната низа, броејќи од лево.
 Пример Ако од тастатура се внесе: banana, позиција: 2, должина: 4, тогаш програмата треба да отпечати: nana
*/

#include <iostream>
#include <cstring>
using namespace std;

void substr (char * str, int poz, int dolzina){
    char substr[100];
    for (int i = poz, j=0; i <= poz+dolzina; ++i) {
        if (i==poz+dolzina){
            substr[j]='\0';
            break;
        }
        substr[j++]=str[i];
    }
    cout<<substr;
}

int main(){
    char str[100];
    int poz, dolzina;
    cin.getline(str, 100);
    cin>>poz>>dolzina;
    substr(str, poz, dolzina);

    return 0;
}
