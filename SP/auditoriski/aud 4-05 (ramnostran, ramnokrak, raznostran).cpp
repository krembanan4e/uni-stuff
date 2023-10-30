//Од тастатура се внесуваат должини на три отсечки во произволен редослед. Да се провери дали од дадените отсечки може да се конструра триаголник.
//Ако може, да се испечати дали триаголникот е разностран, рамностран или рамнокрак и да му се пресмета плоштината.

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    float a, b, c, temp;
    int pravoagolen;
    cin >> a >> b >> c;
    float S = ( a + b + c ) / 2;
    float P = sqrt ( S * ( S - a ) * ( S - b ) * ( S - c ) );
    if ( ( a + b <= c ) || ( a + c <= b ) || ( b + c <= a ) ){
        cout << "Ne moze da se konstruira triagolnik!" << endl;
    }
    else {
        if ( a != b && b != c && a != c ){
            cout << "Raznostran so plostina " << P;
        }
        else if ( a == b && b == c ){
            cout << "Ramnostran so plostina " << P;
        }
        else {
            cout << "Ramnokrak so plostina " << P;
        }
    }



    return 0;
}
