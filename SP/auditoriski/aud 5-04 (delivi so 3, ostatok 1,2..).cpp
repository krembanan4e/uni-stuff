//Да се напише програма што од n броеви (внесени од тастатура) ќе го определи
//бројот на броеви што се деливи со 3, при делењето со 3 имаат остаток 1, односно 2.
//Задачата да се реши со while, do-while и for

#include <iostream>
using namespace std;
int main() {
    int n, broj, ost0 = 0, ost1 = 0, ost2 = 0;
    cin >> n;
    for ( int i = 1; i <= n; i++ ){
        cin >> broj;
        if ( broj % 3 == 0 ){
            ost0 ++;
        }
        if ( broj % 3 == 1 ){
            ost1 ++;
        }
        if ( broj % 3 == 2 ){
            ost2 ++;
        }
    }
    cout << "Delivi so 3: " << ost0 <<endl;
    cout << "Delivi so 3 so ostatok 1: " << ost1 << endl;
    cout << "Delivi so 3 so ostatok 2: " << ost2 << endl;
    return 0;
}
