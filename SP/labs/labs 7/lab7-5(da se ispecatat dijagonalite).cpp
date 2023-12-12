#include <iostream>
using namespace std;

int main(){
    int a[100][100], n;
    cin>>n;

    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cin>>a[i][j];
        }
    }

    cout<<"Glavna dijagonala: ";
    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if(i==j){
                cout<<a[i][j]<<" ";
            }
        }
    }
    
    cout<<endl;
    
    cout<<"Sporedna dijagonala: ";
    for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            if(i+j==n-1){
                cout<<a[i][j]<<" ";
            }
        }
    }


    return 0;
}
