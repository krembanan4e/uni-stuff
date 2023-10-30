//Од тастатура се внесуваат координати на една точка од рамнина.
//Да се напише програма со која ќе се испечати на кој квадрант припаѓа внесената точка.

#include <iostream>
using namespace std;
int main() {
    int x, y;
    cin >> x >> y;
    if ( x > 0 && y > 0 ){
        cout << "Prv kvadrant";
    }
    else if ( x < 0 && y > 0 ){
        cout << "Vtor kvadrant";
    }
    else if ( x < 0 && y < 0 ){
        cout << "Tret kvadrant";
    }
    else if ( x > 0 && y < 0 ){
        cout << "Chetvrti kvadrant";
    }
    else if ( x == 0 && y > 0 ){
        cout << "Tochkata lezhi na pozitivnata y oska";
    }
    else if ( x == 0 && y < 0 ){
        cout << "Tochkata lezhi na negativnata y oska";
    }
    else if ( x > 0 && y == 0 ){
        cout << "Tochkata lezhi na pozitivnata x oska";
    }
    else if ( x < 0 && y == 0 ){
        cout << "Tochkata lezhi na negativnata x oska";
    }
    else{
        cout << "Koordinaten pochetok!";
    }


    return 0;
}
