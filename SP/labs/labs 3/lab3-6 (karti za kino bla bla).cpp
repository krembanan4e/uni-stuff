//Марија и нејзините 3 другарки сакаат да одат во кино и купуваат билети. Иницијалната цена на еден билет за сите филмови е 200 денари, но доколку филмот е комедија се доплаќа 20, за акција се доплаќа 40, за романса 30.
//Освен картите кои сакаат да ги купат тие сакаат да купат и нешто за пиење и грицкање:
//Пијалоци:                                   Пуканки:
//Вода: 80ден                                 големина Ѕ: 100ден
//Fanta, CocaCola, Sprite: 100ден             големина М: 150ден
//IceTea: 120ден                              големина L: 200ден
//Да се пресмета која ќе биде вкупната цена што треба да ја платат Марија и нејзините другарки. Дополнително доколку тие одлучат да одат во Среда и да платат со VISA картичка, за вредноста од 2 билети ќе добијат 4 билети
//(односно добиваат 50% попуст на купените билети без разлика за кој филм станува збор)
//input                                    output
//action S 4 Fanta 3 Wednesday 1           1180
//comedy L 2 Sprite 2 Friday 1             1480

#include <iostream>
#include <cstring>
using namespace std;
int main() {
    string film, pijalok, den;
    char pukanki;
    int kolichinaPukanki, kolichinaPijalok, kartichka, cena = 4 * 200;
    cin >> film >> pukanki >> kolichinaPukanki >> pijalok >> kolichinaPijalok >> den >> kartichka;
    if ( film == "comedy" ){
        cena += 4 * 20;
    }
    else if ( film == "action" ){
        cena += 4 * 40;
    }
    else if ( film == "romance" ){
        cena += 4 * 30;
    }

    if ( den == "Wednesday" && kartichka == 1 ){
        cena -= cena * 0.5;
    }
    else {
        cena = cena;
    }

    if ( pukanki == 'S' ){
            cena += 100 * kolichinaPukanki;
        }
    else if ( pukanki == 'M' ){
            cena += 150 * kolichinaPukanki;
        }
    else if ( pukanki == 'L' ){
            cena += 200 * kolichinaPukanki;
        }

    if ( pijalok == "voda" ){
            cena += 80 * kolichinaPijalok;
        }
    else if ( pijalok == "Fanta" || pijalok == "CocaCola" || pijalok == "Sprite" ){
            cena += 100 * kolichinaPijalok;
        }
    else if ( pijalok == "IceTea" ){
            cena += 120 * kolichinaPijalok;
        }
    cout << cena;
    return 0;
}
