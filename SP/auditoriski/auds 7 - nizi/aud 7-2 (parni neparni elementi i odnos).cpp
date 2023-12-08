//Да се напише програма која за низа чии елементи се внесуваат од тастатура, ќе го пресмета збирот на парните елементи,
//збирот на непарните елементи, како и односот помеѓу бројот на парни и непарни елементи.
//Резултатот да се испечати на екран.

#include<iostream>

using namespace std;

int main() {
    int a[100], n, sumaParni=0, sumaNeparni=0, brParni=0, brNeperni=0;
    float odnos;
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>a[i];
    }
    for (int i=0; i<n; i++){
        if (a[i]%2==0){
            sumaParni+=a[i];
            brParni++;
        }
        if (a[i]%2!=0){
            sumaNeparni+=a[i];
            brNeperni++;
        }
    }
    cout <<"Suma na parni: "<<sumaParni<<endl;
    cout<<"Suma na neparni: "<<sumaNeparni<<endl;
    odnos = (float)brParni / brNeperni;
    cout<<"Odnos megju parni i neparni: "<< odnos << endl;
    return 0;
}
