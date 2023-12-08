//Да се напише програма која ќе провери дали дадена низа од n елементи која се чита од стандарден влез е строго растечка,
//строго опаѓачка или ниту строго растечка ниту строго опаѓачка. Резултатот да се испечати на екран.

#include<iostream>

using namespace std;

int main() {
    int a[100], n;
    int rastecka = 1, opagjacka = 1;
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>a[i];
    }
    for (int i=0; i<n-1; i++){ //check ractecka
        if (a[i]>=a[i+1]){
            rastecka=0;
            break;
        }
    }
    for (int i=0; i<n-1; i++){ //check opagjacka
        if (a[i]<=a[i+1]){
            opagjacka=0;
            break;
        }
    }

    if (rastecka==0 && opagjacka==0){
        cout<<"Nitu rastecka nitu opagjacka"<<endl;
    }
    else if (rastecka==1){
        cout<<"Nizata e strogo rastecka"<<endl;
    }
    else if (opagjacka==1){
        cout<<"Nizata e strogo opagjacka"<<endl;
    }

    return 0;
}
