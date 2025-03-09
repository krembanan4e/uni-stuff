//Од стандарден влез се чита број N, а потоа низа на N цели броеви.
//Да се дефинира функција int isInteresting(int number) која што ќе врати 1 доколку е интересен број,
//односно доколку цифрите на бројот се парна-непарна цифра, наизменично.
//Во спротивно враќа 0. Да се дефинира функција void printArray(int numbers[], int n) која што ќе ги испринта сите броеви во низата кои што се интересни.
//Пример интересни броеви: 1634, 678, 141858
//За се освојат сите поени од вежбата, потребно е функцијата printArray да биде рекурзивна.

//input       output
//5           325
//123         6789
//6789        123
//111
//5325
//325

#include<iostream>
using namespace std;

int isInteresting(int n) {
    int interesen;
    if (n<=9){
        return 0;
    }
    if (n<=99){
        if (((n%10)%2==0 && (n/10%10)%2!=0) || ((n%10)%2!=0 && (n/10%10)%2==0)){
            return 1;
        }
        else {
            return 0;
        }
    }
    while (n>99){
        int c0, c1, c2;
        c0=n%10;
        c1=n/10%10;
        c2=n/100%10;

        if ((c0%2==0 && c1%2!=0 && c2%2==0) || (c0%2!=0 && c1%2==0 && c2%2!=0)){
            interesen=1;
        }
        else {
            interesen=0;
            break;
        }
        n/=10;
    }

    if (interesen){
        return 1;
    }
    else {
        return 0;
    }
}

void printArray(int numbers[], int n){
    if (n==0)
        return;
    if (isInteresting(numbers[n-1])){
        cout<<numbers[n-1]<<endl;
        printArray(numbers, n-1);
    }
    else{
        return printArray(numbers, n-1);
    }
}

int main(){
    int N, a[100];
    cin>>N;
    for (int i=0; i<N; i++){
       cin>>a[i];
    }
    printArray(a,N);


    return 0;
}
