//Елементите од главната дијагонала да се сменат во обратниот број ( - во +, + во - )
//Output-от да е со 3 места измеѓу бројките

//input               output
// 5                    -1   2   3   4   5
// 1 2 3 4 5             6  -7   8   9  10
// 6 7 8 9 10           11  12 -13  14  15
// 11 12 13 14 15       -1  -2  -3   4  -5
// -1 -2 -3 -4 -5       -6  -7  -8  -9   5
// -6 -7 -8 -9 -5

#include <iostream>
#include <iomanip>

using namespace std;

int main(){
    int n, a[100][100];
    cin>>n;

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if (i==j){
                a[i][j]*=-1;
            }
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cout<<setw(3)<<a[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}
