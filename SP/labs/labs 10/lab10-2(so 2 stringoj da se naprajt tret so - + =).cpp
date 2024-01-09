/*
Vtorata zadacha beshe so string. Vnesuvash 2 nizi od stringovi.
I treba da napravish treta. Primer ABCDE i EOCFA
i fintata e tretata treba da se napravi soored prvata i vtorata.
Ako bukvata na prvata se naogja na isto mesto kako so vtorata vo tretata treba = da se zapishe.
Ako vo prvata ima bukva shto bilo kade ja ima vo vtorata treba vo tretata + da se napishe, a ako ja nema treba -
*/

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int main() {
    char str1[100], str2[100], result[100];
    int k=0;
    cin>>str1;
    cin>>str2;
    for (int i = 0; i < strlen(str1); ++i) {
        int flag=1;
        for (int j = 0; j < strlen(str2); ++j) {
            if (str1[i] == str2[i]){
                result[k++] = '=';
                flag=0;
                break;
            }
            else if (str1[i] == str2[j]){
                result[k++] = '+';
                flag=0;
            }
        }
        if(flag){
            result[k++] = '-';
        }
    }
    result[k]='\0';
    cout<<result;

    return 0;
}
