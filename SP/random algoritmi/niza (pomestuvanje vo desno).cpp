//ПОМЕСТУВАЊЕ ВО ДЕСНО

// 1 2 3 4 5
// 5 1 2 3 4

#include<iostream>

using namespace std;

void shiftniNizaVoDesno (int a[], int n){
    int temp = a[n-1];
    for (int i=n-1; i>0; i--){
        a[i]=a[i-1];
    }
    a[0]=temp;
}

int main() {
    int a[100], n;
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>a[i];
    }

    shiftniNizaVoDesno(a,n);

    cout << "Nizata shiftnata vo desno za edno mesto e"<<endl;
    for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
    }

    return 0;
}
