//ДОДАВАЊЕ НА ЕЛЕМЕНТ ВО НИЗА

//пример да се ДОДАЈТ 25

// 10 20 30 40 50 60
// 10 20 25 30 40 50 60

#include<iostream>

using namespace std;

void dodajElement (int a[], int n, int index, int novBroj){

    for (int i = n-1 ; i > index; i--) {
        a[i] = a[i - 1];
    }
    a[index]=novBroj;
}

int main() {
    int a[100], n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int element, index;
    cout<<"Vnesi koj element da se dodajt";
    cin>>element;
    cout<<"Vnesi pozicija na koja sakash da se dodajt elementot";
    cin>>index;

    n++; //da se proshirit goleminata na nizata za edno mesto za da imat mesto za nov element, celata se shiftat vo desno za edno mesto posle to
    dodajElement(a,n,index,element);

    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }

    return 0;
}
