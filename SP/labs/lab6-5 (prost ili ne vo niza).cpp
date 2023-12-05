//Да се напише програма која за низа од N броеви ќе проверува дали парот кој се наоѓа еден до друг е прост број.
//НАПОМЕНА: низата е составена од цифри од 0 до 9

//input                       output
//11                          brojot 17 e prost
//1 7 4 0 2 1 8 1 1 3 7       brojot 40 NE e prost
//                            brojot 21 NE e prost
//                            brojot 81 NE e prost
//                            brojot 13 e prost
//                            brojot 7 e prost

#include <iostream>

using namespace std;

void proveriNiza(int a[], int n){
    for (int i=0; i<n; i+=2){
        int br;
        if (i==n-1){
            br=a[i];
        }
        else{
            br=a[i]*10+a[i+1];
        }
        for (int j=2; j<=br/2; j++){
            if(br%j==0){
                cout<<"brojot "<<br<<" NE e prost"<<endl;
                break;
            }
            else if(j==br/2 && br%j!=0){
                cout<<"brojot "<<br<<" e prost"<<endl;
            }
        }
    }
}

int main() {
    int N, a[100];
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    proveriNiza(a, N);

    return 0;
}
