//Да се напише програма која за две низи кои се внесуваат од тастатура ќе провери дали се еднакви или не.
//На екран да се испачати резултатот од споредбата. Максимална големина на низите е 100.

#include<iostream>

using namespace std;

int main() {
    int a1[100], a2[100], n1, n2, i;

    cin >> n1;
    for (int i = 0; i < n1; i++) {
        cin >> a1[i];
    }

    cin >> n2;
    for (int i = 0; i < n2; i++) {
        cin >> a2[i];
    }

    if (n1 != n2) {
        cout << "NE SE ISTI" << endl;
    }

    else {
        for (i = 0; i < n1; i++) {
            if (a1[i] != a2[i]) {
                break;
            }
        }

        if (i == n1) {
            cout << "ISTI" << endl;
        }
        else {
            cout << "NE SE ISTI"<<endl;
        }
    }
    
    return 0;
}
