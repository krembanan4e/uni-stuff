//Да се напише програма која прима три цели едноцифрени броеви од стандардниот влез, каде (a,b,c>0 && a,b,c<10) 
//Вашата задача е да ги комбинирате овие броеви за да генерирате еден нов троцифрен број.
//Напомена: Комбинирањето на броевите се врши математички
//Дополнително: Потребно е во нов ред да се испечати разликата на секој од внесените броеви и генерираниот број

#include <iostream>
using namespace std;
int main() {

    int a,b,c,trBr;
    cin >> a >> b >> c;
    if ( a > 0 && a < 10 )
    {
        if ( b > 0 && b < 10 )
        {
            if ( c > 0 && c < 10 )
            {
                trBr = a * 100 + b * 10 + c;
                cout << trBr << endl;
            }
        }
    }
    cout << trBr - a << " " << trBr - b << " " << trBr - c;
    return 0;
}
