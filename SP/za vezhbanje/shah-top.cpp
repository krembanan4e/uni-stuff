/*
Да се напише програма која за дадена квадратна матрица со димензии 8х8 која претставува шаховска табла и дадени
 координати на шаховска фигура ТОП ќе провери, односно испечати сите можни полиња каде фигурата топ може да биде
 поместена. Матрицата содржи нули на полињата каде нема фигури, единици на полињата каде има фигури во истата боја
 како и дадениот топ, а двојки на полињата каде има фигура од спротивната боја. За возможните позиции програмата
 треба да испечати доколку со поместувањето на топот на соодветното поле се зема фигура од спротивната боја. Топ
 може да се движи само по хоризонтала и вертикала.
 Пример
 за позицијата (5,4) на топот, возможни полиња за поместување се следните:
 (5,3), (5,5), (5,6), (5,7), (2,4) - зема фигура, (3,4), (4,4), (6,4), (7,4)

 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0
 0 0 0 0 2 0 0 0
 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0
 0 0 1 0 Т 0 0 0 - топот е овде кај Т (долу во инпут не е означен)
 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0
 
-----input-----
 
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 2 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
5 4
 
-----output----- (vo nasoka gore, dolu, levo, desno)
 
(4,4) (3,4) (2,4) - zema figura (6,4) (7,4) (5,3) (5,5) (5,6) (5,7)

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

    //nagore
    for (int i = x-1, j = y; i >=0 ; --i) {
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

    //nadolu
    for (int i = x+1, j = y; i < 8 ; ++i) {
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

    //nalevo
    for (int i = x, j = y-1; j >= 0 ; --j) {
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

    //nadesno
    for (int i = x, j = y+1; j < 8 ; ++j) {
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
