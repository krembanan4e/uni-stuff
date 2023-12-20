//Oд стандарден влез се читаат броеви се додека не се прочита нешто што не е број. 
//За сите броеви кои што се палиндроми на екран да се испечати сума на цифри од кои што е составен бројот, 
//за броевите кои што не се палиндроми потребно е на екран да се испечати од колку цифри е составен бројот. 
//Проверка дали бројот е палиндром, колкава е сумата на цифри или од колку цифри е составен бројот да се реализираат со посебни функции.
//Дополнително функцијата за броење на цифри на број направете ја рекурзивна.

// input      output
// 1221       6
// 123        3
// 717        15
// 8258       4
// 28         2
// .

#include <iostream>
using namespace std;

int daliPalindrom (int n){
    int obraten = 0;
    int temp=n;
    while (n!=0){
        obraten = obraten * 10 + n%10;
        n/=10;
    }
    if (obraten==temp){
        return 1;
    }
    else {
        return 0;
    }
}

int sumaCifri (int n){
    if (n==0)
        return 0;
    return n%10 + sumaCifri(n/10);
}

int kolkuCifri (int n)
{
    int br=0;
    while (n!=0){
        br++;
        n/=10;
    }
    return br;
}

int main(){
   int n;
   while (cin>>n){
       if (daliPalindrom(n)==1){
           cout<<sumaCifri(n)<<endl;
       }
       else {
           cout<<kolkuCifri(n)<<endl;
       }
   }

    return 0;
}
