//Да се напише програма која ќе го одреди резултатот на студентот по еден предмет. Програмата да ги изврши следниве работи:
// 1. Програмата бара внес на следниве податоци за студентот:
//    - поени на испитот (цел број од 0 до 100)
//    - присуство на студентот ( број на часови посетени во однос на вкупниот број на часови во курсот)
// 2. Проверете дали внесените податоци се валидни. Поените од испитот треба да се во опсег од 0 до 100, а присуството на часови да е позитивен број
// 3. Ваша задача е да го пресметате резултатот на студентот со следниве критериуми:
//    - ако бројот на поени на испитот е поголем или еднаков на 60 и присуството е 80% или повеќе од часовите, студентот добива "Odlichna ocenka"
//    - ако бројот на поени на испитот е поголем или еднаков на 50 и присуството е 70% или повеќе од часовите, студентот добива "Zadovolitelna ocenka"
//    - во сите други случаи, студентот добива оценка "Prosechen rezultat"
// 4. Прикажете го на екран резултатот од студентот (неговата оценка)

//input               output
//60  0.9             Odlichna ocenka
//52  0.8             Zadovolitelna ocenka
//50  -1              Nevalidni vlezni podatoci
//102  0.9            Nevalidni vlezni podatoci

#include <iostream>
using namespace std;
int main(){
    int poeni;
    float prisustvo;
    cin >> poeni >> prisustvo;
    if ( ( poeni < 1 || poeni > 100 ) || ( prisustvo < 0 ) ){
        cout << "Nevalidni vlezni podatoci" << endl;
    }
    else {
        if ( poeni >= 60 && prisustvo*100 >= 80 ){
            cout << "Odlichna ocenka" << endl;
        }
        else if ( poeni >= 50 && prisustvo*100 >= 70 ){
            cout << "Zadovolitelna ocenka" << endl;
        }
        else {
            cout << "Prosechna ocenka" << endl;
        }
    }

    return 0;
}
