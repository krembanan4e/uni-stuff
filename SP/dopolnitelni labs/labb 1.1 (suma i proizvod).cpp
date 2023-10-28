//Да се прочитаат два цели броеви од тастатура и на екран да се испечаат нивните сума и производ.

#include <iostream>
using namespace std;
int main() {

    int n1, n2;
    cout << "Vnesi 2 broja" << endl;
    cin >> n1 >> n2;
    cout << "Sumata e " << n1 + n2 << ", a proizvodot e " << n1 * n2;
    return 0;
}
