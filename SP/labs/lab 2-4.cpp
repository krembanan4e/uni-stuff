//За еден студент се читаат освоени поени од 5 активности за еден предмет. Услов за еден предмет да биде положен е да се имаат над 50 освоени поени.
//Ако студентот има 0-50 поени не го положул предметот, ако има 51-60 го положил со 6, 61-70 го положил со 7, 71-80 го положил со 8, 81-90 го положил со 9 и над 90 го положил со 10.
//Да се испечати оценката која ја имал студентот, неговите поени и да се испечати Ima uslov za povisoka ocenka доколку има услов да се добие повисока оценка, а во спротивно да се испечати Nema uslov za povisoka ocenka
//Услов за повисока оценка има само ако недостига 1 поен за добивање повисока оценка.

//input               output
//10 2 3 5 6          Predmetot ne e polozen
//30 40 5 10 3        Ocenka: 9, poeni: 88
//                    Nema uslov za povisoka ocenka
//10 30 11 20 9       Ocenka: 8, poeni: 80
//                    Ima uslov za povisoka ocenka


#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int p1, p2, p3, p4, p5, sumP=0;
    cin >> p1 >> p2 >> p3 >> p4 >> p5;
    sumP = p1 + p2 + p3 + p4 + p5;
    if ( sumP <= 50 ){
        cout << "Predmetot ne e polozen" << endl;
    }
    else{
        if ( sumP <= 60 ){
            cout << "Ocenka: 6, poeni: " << sumP << endl;
        }
        else if ( sumP <= 70 ){
            cout << "Ocenka: 7, poeni: " << sumP << endl;
        }
        else if ( sumP <= 80 ){
            cout << "Ocenka: 8, poeni: " << sumP << endl;
        }
        else if ( sumP <= 90 ){
            cout << "Ocenka: 9, poeni: " << sumP << endl;
        }
        else {
            cout << "Ocenka: 10, poeni: " << sumP << endl;
        }

        if ( sumP == 60 || sumP == 70 || sumP == 80 || sumP == 90 ){
            cout << "Ima uslov za povisoka ocenka";
        }
        else{
            cout << "Nema uslov za povisoka ocenka";
        }

    }


    return 0;
}
