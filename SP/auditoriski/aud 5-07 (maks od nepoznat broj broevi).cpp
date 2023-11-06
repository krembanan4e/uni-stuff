//Да се напише програма што од непознат број на цели броеви што се внесуваат од тастатура
//ќе го определи бројот со максимална вредност. Програмата завршува ако се внесе невалидна репрезентација на број.

#include <iostream>
using namespace std;
int main() {
    int n, maks;
    if ( cin >> maks ){           //ako vnesis broj (int) ke go zachuvat ko maks
        while ( cin >> n ){       //se dur vnesvis broevi ke provervit dali brojot e pogolem od maks
            if ( n > maks ){      //ako e pogolem, maks = n;
                maks = n;
            }
        }
        cout << maks;
    }
    else {
        cout << "Nevalidna reprezentacija na broj";
    }

    return 0;
}
