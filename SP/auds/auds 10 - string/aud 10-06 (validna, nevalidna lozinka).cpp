/* Да се напише функција која за дадена текстуална низа ќе одредува дали таа е доволно сложена за да биде лозинка.
 Секоја лозинка мора да содржи барем една буква, барем една цифра и барем еден специјален знак.
 Пример
 zdr@v0! е валидна лозинка.
 zdravo не е валидна лозинка.
*/

#include <iostream>
#include <cstring>
using namespace std;

int proveri(char * pasw){
    int brBukvi = 0, brCifri = 0, brZnaci = 0;
    for (int i = 0; i < strlen(pasw); ++i) {
        if (isalpha(pasw[i])){
            brBukvi++;
        }
        if (isdigit(pasw[i])){
            brCifri++;
        }
        if (ispunct(pasw[i])){
            brZnaci++;
        }
    }
    if (brBukvi>=1 && brCifri>=1 && brZnaci>=1){
        return 1;
    }
    else{
        return 0;
    }
}

int main(){
    char password[500];
    cin.getline(password, 500);
    if(proveri(password)){
        cout<<"Validna lozinka.";
    }
    else{
        cout<<"Nevalidna lozinka!";
    }

    return 0;
}
