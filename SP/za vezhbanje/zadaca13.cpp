//Од тастатура се читаат непознат број позитивни цели броеви се додека не се внесе нешто различно од број. 
//За секој број треба да се пресмета збирот на цифрата со максимална вредност од претходно внесениот број  и сумата на цифрите на тековниот број 
//(за првиот внесен број се пресметува само сумата на неговите цифри). За секој внесен број резултатот треба да се испечати во следниот формат:
//[број]: [сумата на цифрите на бројот + максималната цифра од претходниот број]
//342: 9   //3+4+2
//345: 16 //3+4+5+4
//123: 11 //1+2+3+5
//456: 18 //4+5+6+3

#include <iostream>
using namespace std;
int main(){
    int n, p0 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, c1, c2, c3, c4, c0, maksCifra, prethodnaMaxCifra = 0, zbir = 0;

    while ( cin >> n ) {
        c0 = n % 10;         //gi zemame site mozni cifri do 5cifren broj
        c1 = n / 10 % 10;
        c2 = n / 100 % 10;
        c3 = n / 1000 % 10;
        c4 = n / 10000;

        if (n > 0 && n < 10) {        //ako n e ednocifren 
            maksCifra = c0;
            cout << n << ": " << c0 + prethodnaMaxCifra << endl;
            prethodnaMaxCifra = maksCifra;        //ke ja zacuvame maksimalnata cifra
        }


        else if (n > 9 && n < 100) {    //ako n e dvocifren
            if (c0 >= c1) {
                maksCifra = c0;
            } else {
                maksCifra = c1;
            }
            cout << n << ": " << c0 + c1 + prethodnaMaxCifra << endl;  //ke ja dodajme prethodnata max cifra 
            prethodnaMaxCifra = maksCifra;      //ke ja zavuvame max cifra od dvocifreniot broj
        }


       else if (n > 99 && n < 1000) {
            if (c0 >= c1 && c0 >= c2) {
                maksCifra = c0;
            } else if (c1 >= c0 && c1 >= c2) {
                maksCifra = c1;
            } else {
                maksCifra = c2;
            }
            cout << n << ": " << c0 + c1 + c2 + prethodnaMaxCifra << endl; //ke ja dodajme prethodnata max cifra 
            prethodnaMaxCifra = maksCifra; //ke ja zavuvame max cifra od trocifreniot broj
        }


        else if (n > 999 && n < 10000) {
            if (c0 >= c1 && c0 >= c2 && c0 >= c3) {
                maksCifra = c0;
            } else if (c1 >= c0 && c1 >= c2 && c1 >= c3) {
                maksCifra = c1;
            } else if (c2 >= c0 && c2 >= c1 && c2 >= c3) {
                maksCifra = c2;
            } else {
                maksCifra = c3;
            }
            cout << n << ": " << c0 + c1 + c2 + c3 + prethodnaMaxCifra << endl; //ke ja dodajme prethodnata max cifra 
            prethodnaMaxCifra = maksCifra;    //ke ja zavuvame max cifra od 4cifreniot broj
        }


        else if (n > 9999 && n < 100000) {
            if (c0 >= c1 && c0 >= c2 && c0 >= c3 && c0 >= c4) {
                maksCifra = c0;
            } else if (c1 >= c0 && c1 >= c2 && c1 >= c3 && c1 >= c4) {
                maksCifra = c1;
            } else if (c2 >= c0 && c2 >= c1 && c2 >= c3 && c2 >= c4) {
                maksCifra = c2;
            } else if (c3 >= c0 && c3 >= c1 && c3 >= c2 && c3 >= c4) {
                maksCifra = c3;
            } else {
                maksCifra = c4;
            }
            cout << n << ": " << c0 + c1 + c2 + c3 + c4 + prethodnaMaxCifra << endl;
            prethodnaMaxCifra = maksCifra;  //ke ja zavuvame max cifra od 5cifreniot broj
        }

        else if (n < 10000 || n > 99999) {
            break;
        }


    }


    return 0;

}
