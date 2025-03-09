//Да се наише програма која за дадена сума на пари,
//ќе испечати со колку најмалку банкноти и монети може да се исплати.
//На влез се чита еден цел број. На излез се печатат 9 редови,
//по колку банкноти или монети од секој апоен ни се потребни за да ја исплатиме сумата.
//Пример 1583 денари, најдобро е да се исплати како:
//0*5000   1*1000   1*500   0*100   1*50   3*10   0*5   1*2   1*1

#include <iostream>
using namespace std;
int main() {
    int suma, a, b, c, d, e, f, g, h, i, sum;
    a = b = c = d = e = f = g = h = i = 0;
    cout << "Vnesi suma na pari" << endl;
    cin >> suma;
    sum = suma;
    a = ( suma / 5000 ); suma -= ( a * 5000 );
    b = ( suma / 1000 ); suma -= ( b * 1000 );
    c = ( suma / 500 ); suma -= ( c * 500 );
    d = ( suma / 100 ); suma -= ( d * 100 );
    e = ( suma / 50 ); suma -= ( e * 50 );
    f = ( suma / 10 ); suma -= ( f * 10 );
    g = ( suma / 5 ); suma -= ( g * 5 );
    h = ( suma / 2 ); suma -= ( h * 2 );
    i = ( suma / 1 ); suma -= ( i * 1 );
    cout << sum << " denari, najdobro e da se ispechati kako: " << endl;
    cout << a << "*5000\n" ;
    cout << b << "*1000\n" ;
    cout << c << "*500\n" ;
    cout << d << "*100\n" ;
    cout << e << "*50\n" ;
    cout << f << "*10\n" ;
    cout << g << "*5\n" ;
    cout << h << "*2\n" ;
    cout << i << "*1" ;

    return 0;
}
