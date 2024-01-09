/*
Prvata zadacha beshe rekurzija. Vnesuvash n i posle n elementi. 
I za sekoj element treba da mu se presmetaat negovite cifri shto se pomali od 5. 
Primer 192856 brojot kje se presmetaat 1+2 zatoa shto se pomali od 5. 
I posle na kraj treba da se ispechati brojot so vakov najgolem zbir
*/

#include <iostream>

using namespace std;

int sumaPomaliOd5 (int n){
    if (n==0){
        return 0;
    }
    if (n%10 < 5){
        return n%10 + sumaPomaliOd5(n/10);
    }
    else {
        return sumaPomaliOd5(n/10);
    }
}

int main() {
    int br, n;
    cin>>br;
    int maxBr, maxSuma, flag=1;
    while(br!=0){

        cin>>n;

        if (flag){
            if (sumaPomaliOd5(n)){
                maxBr = n;
                maxSuma = sumaPomaliOd5(n);
                flag=0;
            }
        }

        else{
            if (sumaPomaliOd5(n) > maxSuma){
                maxBr = n;
                maxSuma = sumaPomaliOd5(n);
            }
        }

        br--;
    }

    cout << maxBr;

    return 0;
}
