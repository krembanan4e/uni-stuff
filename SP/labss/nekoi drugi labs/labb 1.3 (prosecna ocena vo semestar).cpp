//Да се напише програма која пресметува просечна оцена во семестар.
//Програмата чита 5 цели броја.
//Треба да се испечати реален број на две децимали, просек на прочитаните броеви.

#include <iostream>
using namespace std;
int main() {
    int n1, n2, n3, n4, n5;
    float prosek;
    cout << "Vnesi 5 oceni" << endl;
    cin >> n1 >> n2 >> n3 >> n4 >> n5;
    prosek = (n1 + n2 + n3 + n4 + n5) / 5.00;
    cout << prosek;
    return 0;
}
