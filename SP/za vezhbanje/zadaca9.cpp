//Од стандарден влез се читаат непознат број на хексадецимални цифри се додека не се внесе точка (.). 
//Ваша задача е да го пресметате декадниот збир на внесените хексадецимални цифри. Доколку добиениот декаден збир е делив со 16 се печати Pogodok. 
//Доколку истиот тој збир покрај што е делив со 16 плус завршува на 16 (последните цифри му се 1 и 6), се печати Poln pogodok инаку се печати самиот збир.
//Пример:
//влез: A 7 F 2 0 c A 5             излез: 61
//(61 = 10 + 7 + 15 + 2 + 0 + 12 + 10 + 5, бројот не е делив со 16, ниту пак последните цифри му се 1,6)

#include <iostream>
using namespace std;
int main(){
    char c;
    int zbir = 0;
    while ( cin >> c ){
        if ( c >= 'A' && c <= 'F'){       //pretvaranje od golema vo mala bukva
            c = (char)( c + ('a' - 'A'));
        }
        if ( c == '.' ){
            break;
        }
        switch (c){
            case 'a': zbir += 10; break;
            case 'b': zbir += 11; break;
            case 'c': zbir += 12; break;
            case 'd': zbir += 13; break;
            case 'e': zbir += 14; break;
            case 'f': zbir += 15; break;
            default: zbir += (int)( c - '0'); break;
            //pretvaranje od char brij vo int broj
        }
    }
    
    if ( zbir % 16 == 0 && zbir % 100 == 16 ){
        cout << "Poln pogodok";
    }
    else if ( zbir % 16 == 0 ){
        cout << "Pogodok";
    }
    else {
        cout << zbir;
    }


    return 0;
}
