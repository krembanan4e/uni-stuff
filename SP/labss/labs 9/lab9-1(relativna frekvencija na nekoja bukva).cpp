/* Да се напише функција lettersFrequency(char * text, char letter), што за даден letter ќе испечати информација
 која е релативната фреквенција на појавување на таа буква во текстуалната низа text (како мала и како голема буква).
 Текстот е ограничен на максимум 1000 карактери. Релативна фреквенција на буква се пресметува како количник од
 бројот на појавувања на таа мака буква и вкупниот број на букви во текстот */

#include <iostream>
#include <cstring>
using namespace std;

float lettersFrequency(char * text, char letter){
    int length = strlen(text);
    int br = 0;
    for (int i = 0; i < length; ++i) {
        if (tolower(text[i])== tolower(letter)){
            br++;
        }
    }
    return (float)br/length;
}

int main(){
    char text[1000];
    char letter;
    cin.ignore();
    cin.getline(text, 1000);
    cin>>letter;
    cout<<lettersFrequency(text, letter);

    return 0;
}
