//Од тастатура се внесуваат должини на три отсечки во произволен редослед.
//Да се напише програма што ќе провери дали од отсечките може да се конструира триаголник,
//при што ако може, да се провери дали истиот е правоаголен и да се пресмета неговата плоштина.
//Во спротивно, треба да се испечатат соодветни пораки.

#include <iostream>
using namespace std;
int main() {
    float a, b, c, temp;
    int pravoagolen;
    cin >> a >> b >> c;
    if ( ( a + b <= c ) || ( a + c <= b ) || ( b + c <= a ) ){
        cout << "Ne moze da se konstruira triagolnik!" << endl;
    }
    else {
        if ( a >= b ){
            temp = a;
            a = b;
            b = temp;
        }
        if ( a >= c ){
            temp = a;
            a = c;
            c = temp;
        }
        if ( b >= c ){
            temp = b;
            b = c;
            c = temp;
        } //po ova najdolgata strana ke bide vo c

        if ( c * c == ( a * a ) + ( b * b ) ){
            cout <<"Pravoagolen e i ploshtinata mu e: " << a * b / 2 << endl;
        }
        else{
            cout <<"Ne e pravoagolen." << endl;
        }
    }



    return 0;
}
