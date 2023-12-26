/* Да се напише функција која ќе проверува дали дадена текстуална низа е палиндром.
 Една текстуална низа е палиндром ако таа се чита исто од лево на десно и од десно на лево.
 Примери за палиндроми  dovod, ana, kalabalak
*/

#include <iostream>
#include <cstring>
using namespace std;

int palindrom(char * niza){
    int n = strlen(niza);
    for (int i = 0; i < (n/2); ++i) {
        if (niza[i] != niza[n-1-i]){
            return 0;
        }
    }
    return 1;
}

int main(){
    char niza[500];
    cin.getline(niza, 500);
    if (palindrom(niza)){
        cout<<"Palindrom e.";
    }
    else{
        cout<<"Ne e palindrom.";
    }

    return 0;
}
