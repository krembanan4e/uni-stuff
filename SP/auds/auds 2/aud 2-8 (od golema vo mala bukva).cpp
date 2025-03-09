//Да се напише програма која чита голема буква
//од стандарден влез и ја печати истата како мала буква.
//Напомена: Секој знак се претставува со ASCII број.

#include <iostream>
using namespace std;
int main() {
    char bukva;
    cout << "Vnesi golema bukva " << endl;
    cin >> bukva;

    //razlikata od A do a vo ASCII e 32 i na ta razlika se dodavat bukvata
    cout << "Ovaa bukva mala se pishuva: " << char ( bukva + ('a' - 'A')) << endl;
    return 0;
}
