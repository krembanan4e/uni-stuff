//Да се напише програма за пресметување на возраста на едно куче во човечки години. Кучешката возраст се чита од стандарден влез.
//Доколку се внесе негативен број за возраста, да се испечати следната порака: “Vozrasta mora da bide pozitiven broj”.
//Забелешка: За првите две години, една кучешка година е еднаква на 10,5 човечки години. После тоа, секоја кучешка година е еднаква на 4 човечки години.

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int kuceskaVozrast, coveckaVozrast;
    cin >> kuceskaVozrast;
    if ( kuceskaVozrast < 0 ){
        cout << "Vozrasta mora da bide pozitiven broj";
    }
    else{
        if ( kuceskaVozrast <=2 ){
            coveckaVozrast = kuceskaVozrast * 10.5;
        }
        else {
            coveckaVozrast = 2 * 10.5 + ( kuceskaVozrast - 2 ) * 4; 
            // pr. za 5 godini, se dodavet tie prvite 2 * 10.5, a od vnesenite kuceski godini se odzemet prvite 2, i ostanatite se mnozat so 4
        }
        cout << "Chovechka vozrast na kucheto e " << coveckaVozrast << endl;
    }


    return 0;
}
