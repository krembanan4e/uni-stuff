/* Да се напише функција која во дадена текстуална низа ќе ги отстранува празните места на почетокот и крајот од низата.
 Пример
 За низата:  "   make trim   "  треба да се добие:  "make trim"
*/

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int transform(char * niza){
    char temp[500], final[500];
    int j=0, k=0;
    for (int i = 0; i < strlen(niza); ++i) {
        if (isalpha(niza[i])){
            j=i;
            strcpy(temp, niza+j);
            break;
        }
    }

    for (int i = strlen(temp); i > 0; i--) {
        if (isalpha(temp[i])){
            k=i+1;
            strncpy(final, temp, k);
            final[i+1]='\0';
            break;
        }
    }

    cout<<"["<<final<<"]";
}

int main(){
    char niza[500];
    cin.getline(niza, 500);
    transform(niza);

    return 0;
}
