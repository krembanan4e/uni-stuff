#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char niza[500];
    cin.getline(niza, 500);
    for (int i = 0; i <= strlen(niza); ++i) {
        switch (tolower(niza[i])) {
            case 'a': niza[i]= toupper(niza[i]); break;
            case 'e': niza[i]= toupper(niza[i]); break;
            case 'i': niza[i]= toupper(niza[i]); break;
            case 'o': niza[i]= toupper(niza[i]); break;
            case 'u': niza[i]= toupper(niza[i]); break;
            default: niza[i] = tolower(niza[i]);
        }
    }
    cout<<niza;

    return 0;
}
