/*
Да се напише програма која за дадена квадратна матрица со димензии 8х8 која претставува шаховска табла и дадени
 координати на шаховска фигура ЛОВЕЦ ќе провери, односно испечати сите можни полиња каде фигурата ловец може да биде
 поместена. Матрицата содржи нули на полињата каде нема фигури, единици на полињата каде има фигури во истата боја
 како и дадениот ловец, а двојки на полињата каде има фигура од спротивната боја. За возможните позиции програмата
 треба да испечати доколку со поместувањето на ловецор на соодветното поле се зема фигура од спротивната боја. Ловецот
 може да се движи само по ДИЈАГОНАЛИ.
 Пример
 за позицијата (5,4) на ловецот, возможни полиња за поместување се следните:
 (5,3), (5,5), (5,6), (5,7), (2,4) - зема фигура, (3,4), (4,4), (6,4), (7,4)

 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0
 0 0 2 0 0 0 0 0
 0 0 0 0 0 0 0 1
 0 0 0 0 0 0 0 0
 0 0 0 0 0 L 0 0 - ловецот е овде кај L (долу во инпут не е означен)
 0 0 0 0 0 0 0 0

-----input-----

0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 2 0 0 0 0 0
0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
6 5

-----output----- (vo nasoka gore-levo, gore-desno, dolu-levo, dolu-desno)

(5,4) (4,3) (3,2) - zema figura (5,6) (7,4) (7,6)

*/

#include <iostream>

using namespace std;

int main() {
    int mat[8][8];
    int x,y; // koordinati na topot
    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            cin>>mat[i][j];
        }
    }
    cin>>x>>y;

    //gore levo
    for (int i = x-1, j = y-1; i >= 0 && j >=0 ; --i, --j) {
        if (mat[i][j] == 0){ //prazno pole
            cout<<"("<<i<<","<<j<<")"<<" ";
        }
        else if (mat[i][j] == 1){ //figura so ista boja
            break;
        }
        else if (mat[i][j] == 2){ //figura so razlicna boja
            cout<<"("<<i<<","<<j<<")"<<" - zema figura ";
            break;
        }
    }

    //gore desno
    for (int i = x-1, j = y+1; i >= 0 && j < 8 ; --i, ++j) {
        if (mat[i][j] == 0){ //prazno pole
            cout<<"("<<i<<","<<j<<")"<<" ";
        }
        else if (mat[i][j] == 1){ //figura so ista boja
            break;
        }
        else if (mat[i][j] == 2){ //figura so razlicna boja
            cout<<"("<<i<<","<<j<<")"<<" - zema figura ";
            break;
        }
    }

    //dolu levo
    for (int i = x+1, j = y-1; i < 8 && j >=0 ; ++i, --j) {
        if (mat[i][j] == 0){ //prazno pole
            cout<<"("<<i<<","<<j<<")"<<" ";
        }
        else if (mat[i][j] == 1){ //figura so ista boja
            break;
        }
        else if (mat[i][j] == 2){ //figura so razlicna boja
            cout<<"("<<i<<","<<j<<")"<<" - zema figura ";
            break;
        }
    }

    //dolu desno
    for (int i = x+1, j = y+1; i < 8 && j < 8 ; ++i, ++j) {
        if (mat[i][j] == 0){ //prazno pole
            cout<<"("<<i<<","<<j<<")"<<" ";
        }
        else if (mat[i][j] == 1){ //figura so ista boja
            break;
        }
        else if (mat[i][j] == 2){ //figura so razlicna boja
            cout<<"("<<i<<","<<j<<")"<<" - zema figura ";
            break;
        }
    }

    return 0;
}
