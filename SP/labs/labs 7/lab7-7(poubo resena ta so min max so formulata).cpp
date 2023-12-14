#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    float a[100][100], n, m, max, min;
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    for (int j = 0; j < m; j++) {
        max=a[0][j];
        min=a[0][j];
        for (int i = 1; i < n; i++) {
            if (a[i][j] > max) {
                max = a[i][j];
            }
            if (a[i][j] < min) {
                min = a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            a[i][j]=(float) (a[i][j] - min) / (max - min);
        }
    }


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout<<fixed<<setprecision(2)<<a[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}
