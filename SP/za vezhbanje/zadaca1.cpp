//Благ број е број што е составен само од парни цифри (0, 2, 4, 6, 8).
//Во зададен опсег (почетокот m и крајот на опегот n се цели броеви чија вредност се внесува од тастатура),
//да се најде и испечати најмалиот „благ број“. Ако не постои таков број, да се испечати NE.

//input             output
//99 500            200

#include <iostream>
using namespace std;
int main(){
    int m, n, i, broj, blag = 0;
    cin >> m >> n;
    for ( i = m; i <= n; i++ ){

        broj = i;
        blag = 0;   //flag za dali e blag

        while ( broj > 0 ){
            int cifra = broj % 10;
            if ( cifra % 2 != 0 ){      //ako poslednata cifra mu e neparna ne e blag flag==0
                blag = 0;
                break;
            }
            blag = 1;          //go redime na 1 zs aku e blag da prodolzit se dur ne e
            broj /= 10;
        }

        if ( blag == 1 ){
            cout << i;
            return 0;
        }
        
    }

    cout << "NE";
    
    return 0;
}
