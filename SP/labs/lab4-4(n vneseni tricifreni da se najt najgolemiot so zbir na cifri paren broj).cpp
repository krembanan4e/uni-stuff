/*Од стандарден влез се вчитува даден број n, а потоа се вчитуваат n трицифрени броеви.
 * Ваша задача е да го најдете најголемиот број чиј бир на неговите цифри е парен број.
 * input           output
 * 4               170
 * 999
 * 122
 * 900
 * 170                        */

#include <iostream>
using namespace std;
int main(){
    int n, br, najgolem = 0;
    cin >> n;
    for ( int i = 1; i <= n; i++ ){
        cin >> br;
        int zbirCifri = 0;
        if ( br < 100 || br > 999 ){
            break;
        }
        int temp = br;
        while ( temp != 0 ){
            zbirCifri += temp % 10;
            temp /= 10;
        }
        if ( zbirCifri % 2 == 0 ){
            if ( br > najgolem ){
                najgolem = br;
            }
        }

    }
    cout << najgolem;


    return 0;
}
