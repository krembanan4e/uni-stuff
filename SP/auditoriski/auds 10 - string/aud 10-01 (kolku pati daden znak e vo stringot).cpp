/* Да се напише функција што ќе одредува колку пати даден знак се наоѓа
 во даден стринг. Знакот за споредување и стрингот се внесуваат од тастатура.

 HELLO FINKI ---> L се појавува два пати

*/

#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char str[100], c;
    int br=0;
    cin.getline(str, 100);
    cin>>c;
    for (int i = 0; i < strlen(str); ++i) {
        if (str[i]==c){
            br++;
        }
    }
    cout<<"Znakot "<<c<<" se pojavuva "<<br<<" pati.";


    return 0;
}
