//Да се напише програма со која корисникот на влез треба да внесе три позитивни броја, а на излез треба да се отпечати кој од броевите има најмала вредност. 
//Доколку сите три броја имаат иста вредност треба да се отпечати порака дека станува збор за три исти броја. 

//input           output
//1 2 1           Najmala vrednost ima brojot 1
//5 3 2           Najmala vrednost ima brojot 2
//3 3 3           Site tri broja imaat ista vrednost
//10 6 54         Najmala vrednost ima brojot 6

#include <iostream>
using namespace std;
int main() {
    int n1, n2, n3;
    cin >> n1 >> n2 >> n3;
    if ( n1 == n2 && n1 == n3 && n2 == n3 ){
        cout << "Site tri broja imaat ista vrednost";
    }
    else {
        if ( n1 <= n2 && n1 <= n3 ){
            cout << "Najmala vrednost ima brojot " << n1;
        }
        else if ( n2 <= n1 && n2 <= n3 ){
            cout << "Najmala vrednost ima brojot " << n2;
        }
        else if ( n3 <= n1 && n3 <= n2 ){
            cout << "Najmala vrednost ima brojot " << n3;
        }
    }


    return 0;
}
