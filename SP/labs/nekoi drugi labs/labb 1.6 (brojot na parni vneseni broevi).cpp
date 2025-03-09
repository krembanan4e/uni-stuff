//Од тастатура се внесуваат 5 позитивни цели броеви едно по друго.
//Да се испечати бројот на парни броеви кој што се внесени.

#include <iostream>
using namespace std;
int main() {
    int n1, n2, n3, n4, n5, brojac = 0;
    cout << "Vnesi 5 broevi" << endl;
    cin >> n1 >> n2 >> n3 >> n4 >> n5;
    brojac += ( n1 % 2 == 0 );
    brojac += ( n2 % 2 == 0 );
    brojac += ( n3 % 2 == 0 );
    brojac += ( n4 % 2 == 0 );
    brojac += ( n5 % 2 == 0 );
    cout << "Brojot na parni broevi koj shto se vneseni e: " << brojac;
    return 0;
}
