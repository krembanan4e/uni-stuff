//ПОМЕСТУВАЊЕ ВО ЛЕВО

// 1 2 3 4 5
// 2 3 4 5 1

#include<iostream>

using namespace std;

void shiftniNizaVoLevo (int a[], int n){
    int temp = a[0];
    for (int i=0; i<n-1; i++){
        a[i]=a[i+1];
    }
    a[n-1]=temp;
}

int main() {
    int a[100], n;
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>a[i];
    }

    shiftniNizaVoLevo(a,n);

    cout << "Nizata shiftnata vo levo za edno mesto e"<<endl;
    for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
    }

    return 0;
}
