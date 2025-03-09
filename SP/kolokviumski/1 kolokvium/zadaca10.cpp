//Цик-цак е број за кој што важи дека за секој пар соседни цифри, тие се наизменично поголеми односно помали една во однос на друга. 
//На пример, ако бројот x е составен од цифрите a, b, c, d и е, тогаш за нив важи:
//a>b, b<c, c>d, d<e или a<b, b>c, c<d, d>e
//Пр. 343, 4624, 6231209
//Од тастатура се читаат непознат број цели броеви поголеми од или еднакви на 10 (броевите помали од 10 се игнорираат). 
//Читањето завршува во моментот кога ќе се прочита знак што не е цифра. Да се испечатат сите цик-цак броеви.

//input      output
//343        343
//22         4624
//4624       6231209
//123456
//6231209
//9
//k

#include<iostream>
using namespace std;

bool cikcak(int n){
    int cikcak;
    if (n<=9){ //aku e ednocifren ili negativen
        return false;
    }

    if (n>=10 && n<=99){ //aku e dvocifren
        if (n%10 != n/10%10){
            return true;
        }
    }

    while (n>99){ //se dur imat 3 cifri
        int c0, c1, c2; //pozicii odnazad

        c0 = n%10;
        c1 = n/10%10;
        c2 = n/100%10;

        if ((c0>c1 && c1<c2) || (c0<c1 && c1>c2)){
            cikcak=1;
        }
        else {
            cikcak=0;
            break;
        }
        n/=10;
    }

    if (cikcak){
        return true;
    }
    else{
        return false;
    }
}

int main(){
    int n;
    while (cin>>n){
        if (cikcak(n)){
            cout<<n<<endl;
        }
    }

    return 0;
}
