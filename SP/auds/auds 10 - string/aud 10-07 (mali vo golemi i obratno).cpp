/* Да се напише функција која во стринг што и се предава како влезен параметар
 ќе ги промени малите букви во големи и обратно, и ќе ги отстрани сите цифри и специјални знаци.
 Пример
 За низата: 0v@ePr1m3R  треба да се добие: VEpRMr
*/

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int transform(char * niza){
    char temp[500];
    int j=0;
    for (int i = 0; i < strlen(niza); ++i) {
        if(isalpha(niza[i])){
            if (islower(niza[i])){
                temp[j++] = toupper(niza[i]);
            }
            else {
                temp[j++] = tolower(niza[i]);
            }
        }
    }
    temp[j]='\0';
    cout<<temp;
}

int main(){
    char niza[500];
    cin.getline(niza, 500);
    transform(niza);

    return 0;
}
