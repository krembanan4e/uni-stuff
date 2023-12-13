//Во секоја редица посебно да се најдит мин и мах, мах да се заменит со 1, мин со 0
//аку имат појке исти минимуми или исти максимуми да се сменат со 0 и 1 и тие

// 5
// 55 4 3 9 8   ---->  max 55 min 3  ---->  1 4 0 9 8
// 9 7 43 2 6   ---->  max 43 min 2  ---->  9 7 1 0 6
// 8 7 7 22 20  ---->  max 22 min 7  ---->  8 0 0 1 20
// 10 2 2 2 2   ---->  max 10 min 2   ----> 1 0 0 0 0
// 6 7 8 18 2   ---->  max 18 min 2  ---->  6 7 8 1 0

#include <iostream>

using namespace std;

int main(){
    int n, a[100][100],max,min;
    cin>>n;

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    for (int i=0; i<n; i++){
        max=a[i][0];
        min=a[i][0];
        for (int j=1; j<n; j++){
            if (a[i][j]>max){
                max=a[i][j];
            }
            if (a[i][j]<min){
                min=a[i][j];
            }
        }
        for (int j=0; j<n; j++){
            if (a[i][j]==max){
                a[i][j]=1;
            }
            if (a[i][j]==min){
                a[i][j]=0;
            }
        }
    }

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }


    return 0;
}
