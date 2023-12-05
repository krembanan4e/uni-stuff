//Напишете програма со која ќе ја пронајдете поднизата со најголем збир на елементите и испечатете го тој збир.
//Дополнително, пронајдете го и испечатете го процентот на елементи што се користат во поднизата во споредба со вкупниот број на елементи на низата.

//input                         output
//10                            Maximum Sum: 7
//-2 1 -3 4 -1 2 1 -5 4 2       Percentage of Elements Used: 70

//Kako e dobieno reshenievo:
//-2 1 -3 4 -1 2 1 -5 4 2 (sumata e 3)
//   1 -3 4 -1 2 1 -5 4 2 (sumata e 5)
//     -3 4 -1 2 1 -5 4 2 (sumata e 4)
//        4 -1 2 1 -5 4 2 (sumata e 7)  ----> max
//          -1 2 1 -5 4 2 (sumata e 3)
//             2 1 -5 4 2 (sumata e 4)
//               1 -5 4 2 (sumata e 2)
//                 -5 4 2 (sumata e 1)
//                    4 2 (sumata e 6)
//                      2 (sumata e 2)

#include <iostream>

using namespace std;

void proverka (int a[], int n){
    int max=a[n-1];
    int maxBr=a[0];
    for (int i=0; i<n; i++){
        int suma=0;
        int br=0;
        for (int j=i; j<n; j++){
            suma=suma+a[i];
            br++;
        }
        if (suma>max){
            max=suma;
            maxBr=br;
        }
    }
    cout<<"Maximum Sum: "<<max<<endl;
    cout<<"Percentage of Elements Used: "<<maxBr*100/n<<endl;
}

int main() {
    int N, a[100];
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin>>a[i];
    }
    proverka(a, N);


    return 0;
}
