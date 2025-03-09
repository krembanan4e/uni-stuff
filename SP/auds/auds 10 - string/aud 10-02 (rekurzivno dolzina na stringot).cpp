/* Да се напише функција што ќе ја одредува должината на една текстуална низа.
 Да се даде итеративно и рекурзивно решение.
 Пример Ако на функцијата како аргумент и се предаде стрингот zdravo!
 тогаш таа треба да врати: 7
*/

#include <iostream>
#include <cstring>
using namespace std;

int length_of_string (char * str){
    if (*str=='\0')
        return 0;
    return 1 + length_of_string(str+1);
}

int main(){
    char str[100];
    cin.getline(str, 100);
    cout<<length_of_string(str);

    return 0;
}
