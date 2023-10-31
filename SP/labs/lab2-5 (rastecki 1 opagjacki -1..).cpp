//Да се напише програма во која се внесуваат три цели броеви. Доколку внесените броеви се во растечки редослед
//да се испечати 1, а ако се во опаѓачки да се испечати -1, во спротивно да се испечати 0.

//input             output
//10 15 20          1
//100 10 1          -1


#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int a, b, c;
    cin >> a >> b >> c;
    if ( a < b && b < c ){
        cout << "1";
    }
    else if ( a > b && b > c ){
        cout << "-1";
    }
    else{
        cout << "0";
    }


    return 0;
}
