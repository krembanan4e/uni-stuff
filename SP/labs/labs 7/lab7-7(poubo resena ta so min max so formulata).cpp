//Да се изврши min-max нормализатија на секоја колона од матрицата, односно секој елемент во секоја колона
//да се замени со вредноста x-min / max-min кадешто х е елементо во некоја колона, а max и min се
//соодветно најголемиот и најмалиот елемент во соодветната колона. 

//input                output
// 5 5                 0.00 0.00 0.00 0.00 0.00
// 1 2 3 4 5           0.25 0.25 0.25 0.25 0.25 
// 6 7 8 9 10          0.50 0.50 0.50 0.50 0.50 
// 11 12 13 14 15      0.75 0.75 0.75 0.75 0.75 
// 16 17 18 19 20      1.00 1.00 1.00 1.00 1.00 
// 21 22 23 24 25

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
