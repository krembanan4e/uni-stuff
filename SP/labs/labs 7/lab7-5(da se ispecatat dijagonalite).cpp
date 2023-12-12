//input               output
// 3                  1
// 3                  2 4
// 1 2 3              3 5 7
// 4 5 6
// 7 8 9

#include <iostream>
using namespace std;

int main(){
    int a[100][100], n, m;
    cin>>n>>m;

    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            cin>>a[i][j];
        }
    }

    int k=0;
    while (k<n){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (i+j==k){
                    cout<<a[i][j]<<" ";
                }
            }
        }
        cout<<endl;
        k++;
    }

    return 0;
}
