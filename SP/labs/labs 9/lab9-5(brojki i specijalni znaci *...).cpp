// brojki i specijalni znaci da se smenat so *
// bukvite na parna pozicija da se golemi, na neparna pozicija mali

// input
// anA3b8?Zdr$#
// output
// AnA*B**zDr**

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int main() {
    char niza[1000];
    cin.getline(niza, 1000);
    for (int i = 0; i < strlen(niza); ++i) {
        if (isdigit(niza[i])|| ispunct(niza[i])){
            niza[i]='*';
        }
        if (isalpha(niza[i])){
            if (i%2==0){
                niza[i]= toupper(niza[i]);
            }
            else{
                niza[i]= tolower(niza[i]);
            }
        }
    }

    for (int i = 0; i < strlen(niza); ++i) {
        cout<<niza[i];
    }


    return 0;
}
