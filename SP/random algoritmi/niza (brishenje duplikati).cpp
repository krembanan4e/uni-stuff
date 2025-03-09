//БРИШЕЊЕ ДУПЛИКАТИ ВО НИЗА

// 2 3 4 1 2 2 3 3 3 4 5 1
// 2 3 4 1 5

#include<iostream>

using namespace std;

void brishiElement (int a[], int n, int index){
    for (int i=index; i<n-1; i++){
        a[i]=a[i+1];
    }
}

int main() {
    int a[100], n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
                                              // i stojt kaj prviot j shetat, i se pomestvit za 1 j shetat, i se pomestvit za 1 j shetat....
    for (int i=0; i<n-1; i++){                // i
        for (int j=i+1; j<n; j++){            //   j
            if (a[i]==a[j]){                  // 2 3 4 1 2 2 3 3 3 4 5 1
                brishiElement(a,n,j);         
                n--;  //brishit element i ja namalvit goleminata na nizata za 1
                j--;  //aku imat pojke duplikati edno do drugo, ojt napred j i se vrakjat pak da proverit
            }
        }
    }

    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }

    return 0;
}
