// input               output
// 5 5                 0.00 0.00 0.00 0.00 0.00
// 1 2 3 4 5           0.25 0.25 0.25 0.25 0.25
// 6 7 8 9 10          0.50 0.50 0.50 0.50 0.50
// 11 12 13 14 15      0.75 0.75 0.75 0.75 0.75
// 16 17 18 19 20      1.00 1.00 1.00 1.00 1.00
// 21 22 23 24 25 

#include <iostream>
#include <climits>
#include <iomanip>

using namespace std;

int main() {
    int a[100][100], n, m;
    float b[100][100];
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    int s = 0;
    int k = n;
    while (k != 0) {
        int max = INT_MIN, min = INT_MAX;
        for (int j=s ; j < s+1; j++) {  //max i min element
            for (int i = 0; i < n; i++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
                if (a[i][j] < min) {
                    min = a[i][j];
                }
            }
        }
        for (int j = s; j < s+1; j++) {  //zamena na elementite
            for (int i = 0; i < n; i++) {
                b[i][j]=(float) (a[i][j] - min) / (max - min);
            }
            k--;
        }
        s++;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout<<fixed<<setprecision(2)<<b[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}
