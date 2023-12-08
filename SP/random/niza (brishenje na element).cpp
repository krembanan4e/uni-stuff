//БРИШЕЊЕ НА ЕЛЕМЕНТ ОД НИЗА

//пример да се избришит 30

// 10 20 30 40 50 60
// 10 20 40 50 60

#include<iostream>

using namespace std;

void izbrishiElement (int a[], int n, int index){
    for (int i = index; i < n - 1; i++) {
        a[i] = a[i + 1];
    }
}

int main() {
    int a[100], n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int index;
    cout<<"Vnesi pozicija na elementot sho trebit da se izbrishit";
    cin>>index;

    izbrishiElement(a,n,index);
    n--; //se namalvit goleminata na nizata za 1, zsh cela se shiftat vo levo, i da ne se zemat posledniot element kako dupli

    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }

    return 0;
}
