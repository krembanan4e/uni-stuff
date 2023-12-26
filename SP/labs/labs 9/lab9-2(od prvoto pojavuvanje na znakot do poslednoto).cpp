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
    char str[500], nova[500], final[500];
    char c;
    int k=0,j=0;
    //cin.ignore();
    cin.getline(str, 500);
    cin>>c;

    for (int i = 0; i < strlen(str); ++i) { //prvoto pojavuvanje
        if (tolower(str[i])== tolower(c)){
            k=i;
            break;
        }
    }

    strcpy(nova, str+k);

    int length = strlen(nova);

    for (int i=length; i>=0; i--) {  //poslednoto pojavuvanje
        if (tolower(nova[i]) == tolower(c)){
            j=i+1;
            final[j]='\0';
            strncpy(final, nova, j);
            break;
        }
    }

    cout << final;

    return 0;
}
