/* Да се напише функција која ќе проверува дали дадена реченица е палиндром.
 При проверката да се игнорираат празните места, интерпункциските знаци,
 а соодветните мали и големи букви да се сметаат за еднакви (A == a, B == b, итн.).
 Примери за реченици - палиндроми
 Jadejne i pienje daj!
 A man, a plan, a canal, Panama.
 Never odd or even.
 Rise to vote sir!
*/

#include <iostream>
#include <cstring>
using namespace std;

int palindrom(char * niza){
    int n = strlen(niza);
    for (int i = 0; i < (n/2); ++i) {
        if (tolower(niza[i]) != tolower(niza[n-1-i])){
            return 0;
        }
    }
    return 1;
}

int main(){
    char niza[500], temp[100];
    cin.getline(niza, 500);
    int j=0;

    for (int i = 0; i < strlen(niza); ++i) {
        if (isalnum(niza[i])){
            temp[j++]=niza[i];
        }
    }

    temp[j]='\0';

    if (palindrom(temp)){
        cout<<"Palindrom e.";
    }
    else{
        cout<<"Ne e palindrom.";
    }

    return 0;
}
