//На ФИНКИ е време за упис на нови студенти.
//За студент да се упиши, треба да пристигне на факултетот пред 9 часот и да чека ред за да биде услужен од студентска служба.
//Студентска служба почнува со работа од 9 часот, работи 2 часа, прави пауза 30 минути, работи 1 час, прави пауза 30 минути, работи 2 часа
//и нејзиното работно време завршува. На студентска служба и е потребно точно 5 минути за да услужи 1 студент
//Ваша задача е, ако знаете кој по ред е одреден студент во редица за чекање, да го испечатите времето на часови и минути кое тој го чека за да биде
//услужен или да испечати доколку студентот не е услужен

#include <iostream>
using namespace std;
int main() {
    int student, vreme = 0;
    cin >> student;
    //rabotno vreme 9 - 11,  11.30 - 12.30,  13 - 15
    //za 1 sat mojt da usluzhit 12 studenti
    //a za celo rabotno vreme max 60 studenti

    //od 9 do 11 se 2 sati (24 studenti max)
    if ( student <= 24 ){
        vreme = ( student - 1 ) * 5;
        //prviot ne chekat zato e "student - 1"
    }

    //od 11.30 do 12.30 e 1 sat (12 studenti max)
    else if ( student >= 25 && student <= 36 ){
        vreme = ( student - 1 ) * 5 + 30;
    }

    //od 13 do 15 se 2 sati (24 studenti max)
    else if ( student >= 37 && student <= 60 ){
        vreme = ( student - 1 ) * 5 + 60;
    }

    //zavrshvit rabotnoto vreme
    else {
        cout << "Ne e usluzhen!";
    }

    if ( student <= 60 ){
        cout << "Hours: " << vreme / 60 << ", minutes: " << vreme % 60;
    }


    return 0;
}
