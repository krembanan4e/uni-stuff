/* Од тастатура се вчитува текстуална низа дадена во еден ред (низата може да има најмногу 500 знаци).
 По вчитувањето на низата се влитува еден знак. На екран да се испечати поднизата која почнува од првото појавување
 на знакот до последното појавување на знакот, Да се игнорира големината на буквите.

 пр. Zdravo kako si?    ----- >    avo ka
     a
*/

#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char niza[500], nova[500], final[500];
    char c;
    cin.getline(niza, 500);
    cin>>c;
    int k=0, j=0;

    for (int i = 0; i < strlen(niza); ++i) {
        if (tolower(niza[i])== tolower(c)){
            k=i;
            strcpy(nova, niza+k);
            break;
        }
    }

    for (int i = strlen(nova); i >0 ; i--) {
        if (tolower(nova[i])== tolower(c)){
            j=i+1;
            final[j]='\0';
            strncpy(final, nova, j);
            break;
        }
    }
    cout<<final;

    return 0;
}
