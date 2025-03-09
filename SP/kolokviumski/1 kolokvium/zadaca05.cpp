//Од тастатура се читаат 2 позитивни цели броеви. Доколку се внесе барем еден негативен број или 0 треба да се печати „Invalid input“.
//Треба да се определи дали помалиот број “е парен еквивалент” од поголемиот број.
//Еден број “е парен еквивалент” на друг број, ако и само ако неговите цифри се наоѓаат на парните позиции од другиот број, во истиот редослед.
//Соодветно да се испечатат пораки „PAREN“ и „NE“.
//Позициите треба да се сметаат оддесно-налево (најмалку значајната цифра е на позиција 1)

//input                    output
//12345678 1357            PAREN

#include <iostream>
using namespace std;
int main() {
    int a, b, pomalBroj, pogolemBroj;
    int cifra, novBroj = 0, x = 0, y, m = 10;
    cin >> a >> b;
    if ( a <= 0 || b <= 0 ){
        cout << "Invalid input";
    }

    if ( a > b ){
        pogolemBroj = a;
    }
    else {
        pogolemBroj = b;
    }

    x = pogolemBroj / 10 % 10;

    while ( pogolemBroj > 0 ){
        cifra = pogolemBroj / 1000 % 10;
        y = cifra * m + x;
        x = y;
        pogolemBroj = pogolemBroj / 100;
        m = m * 10;
    }

    pomalBroj = x;

    if ( pomalBroj == b ){
        cout << "PAREN";
    }
    else {
        cout << "NE";
    }

return 0;
}

