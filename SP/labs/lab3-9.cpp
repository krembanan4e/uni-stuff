//За еден студент се читаат освоени поени од 5 активности за еден предмет. Услов за еден предмет да биде положен е да се имаат над 50 освоени поени. 
//Ако студентот има 0-50 поени не го положил предметот, ако има 51-60 го положил со 6, 61-70 го положил со 7, 71-80 го положил со 8, 81-90 го положил со 9 и над 90 го положил со 10.
//Да се испечати оценката која ја имал студентот,неговите поени и да се испечати 1 доколку има услов да добие повисока оценка, а во спротивно 0. 
//Услов за повисока оценка има само ако недостига 1 поен за добивање на повисока оценка.

//input                           output
//30 40 5 10 3                    Ocenka: 9, poeni: 88
//                                Nema uslov za povisoka ocenka


#include <iostream>
using namespace std;
int main() {

    int p1, p2, p3, p4, p5, poeni = 0 ;
    cin >> p1 >> p2 >> p3 >> p4 >> p5;
    poeni = p1 + p2 + p3 + p4 + p5;
    if ( poeni <= 50 ){
        cout << "Predmetot ne e polozen";
    }
    else {
        if ( poeni <= 60 ) {
            cout << "Ocenka: 6, poeni: " << poeni << endl;
            if ( poeni == 60 ) cout << "Ima uslov za povisoka ocenka";
            else cout << "Nema uslov za povisoka ocenka";
        }
        else if ( poeni <= 70 ) {
            cout << "Ocenka: 7, poeni: " << poeni << endl;
            if ( poeni == 70 ) cout << "Ima uslov za povisoka ocenka";
            else cout << "Nema uslov za povisoka ocenka";
        }
        else if ( poeni <= 80 ) {
            cout << "Ocenka: 8, poeni: " << poeni << endl;
            if ( poeni == 80 ) cout << "Ima uslov za povisoka ocenka";
            else cout << "Nema uslov za povisoka ocenka";
        }
        else if ( poeni <= 90 ) {
            cout << "Ocenka: 9, poeni: " << poeni << endl;
            if ( poeni == 90 ) cout << "Ima uslov za povisoka ocenka";
            else cout << "Nema uslov za povisoka ocenka";
        }
        else if ( poeni <= 100 ) {
            cout << "Ocenka: 10, poeni: " << poeni << endl;

        }

    }



    return 0;
}
