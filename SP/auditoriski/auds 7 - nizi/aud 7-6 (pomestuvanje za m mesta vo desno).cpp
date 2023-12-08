//Да се напише програма за ротирање на елементите на една низа за m местa во десно.
//На крај, да се испечати на екран ротираната низа. Елементите од низата и бројот на ротирања се читаат од стандарден влез.

#include<iostream>

using namespace std;

int main() {
    int a[100], n, m;

    cin>>n; //broj na elementi
    for (int i=0; i<n; i++){
        cin>>a[i];
    }

    cin>>m; //broj na pomestuvanja
                                        //pr za m = 3
    for (int j=0; j<m; j++){            //1 2 3 4 5 ---> 5 1 2 3 4
        int temp = a[n-1];              //5 1 2 3 4 ---> 4 5 1 2 3
        for (int i=n-1; i>0; i--){      //4 5 1 2 3 ---> 3 4 5 1 2
            a[i]=a[i-1];
        }
        a[0]=temp;
    }

    for (int i=0; i<n; i++){
        cout<<a[i]<<" ";
    }

    return 0;
}
