//Да се напише програма што проверува дали дадена година што се вчитува од тастатура е престапна или не
//и на екран печати соодветна порака.
//Примери за престапни години: 1976, 2000, 2004, 2008, 2012…
//ПОМОШ: Годината е престапна ако е делива со 4 но не е делива со 100, или пак ако е делива со 400.

#include <iostream>
using namespace std;
int main() {
    int godina;
    cin >> godina;
    if ( ( godina % 4 == 0 && godina % 100 != 0 ) || godina % 400 == 0 ){
        cout << "Godinata e prestapna";
    }
    else{
        cout << "Godinata ne e prestapna";
    }


    return 0;
}
