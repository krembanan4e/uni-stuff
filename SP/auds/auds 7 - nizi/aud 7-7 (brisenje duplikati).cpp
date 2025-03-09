//Да се напише програма која што ќе ги избрише дупликатите од една низа.
//На крај, да се испечати на екран новодобиената низа. Елементите од низата се читаат од стандарден влез.

#include<iostream>

using namespace std;

int main() {
    int a[100], b[100], n, br=0;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    for (int i = 0, j=0; i < n; i++) { //so i++ se zgolemvit indeksot od nizata a
        if (a[i] != a[i + 1]) {
            b[j] = a[i];
            j++; //indeksot od nizata b samo da se zgolemvit so j++ aku se razlicni elementite
            br++; //broj kolku razlicni elementi imat vo nizata a, tolku ke e dolzinata na nizata b
        }
    }

    for (int i = 0; i < br; i++) {
        cout << b[i] << " ";
    }

    return 0;
}
