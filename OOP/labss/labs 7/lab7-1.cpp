/*Потребно е да конструирате абстракна класа Shape со само еден параметар:

страна (int)
Конструктори:

Shape()
Shape(int a)
И виртуелните методи:

double plostina()
void pecati()
int getType()
Од таа класа вие треба да конструирате 3 изведени класи:

Square
Circle
Triangle
Изведените класи немаат дополнителни парамтери, туку ја наследуваат страната од Shape

Конструктори:

Конструкторот на изведените класи ќе зема еден аругмент, страната на фигурата.

При пишување на конструкторот на изведените класи да се искористи констукторот на родител класата

Методи:

Секоја од класите си има своја формула за plostina() соодветна за нивната геометриска фигура

Формула за плоштина на квадрат а * a
Формула за плоштина на круг 3.14 * a * a
Формула за плоштина на триаголник (sqrt(3)/4) * side * side
За pecati() методот упатете се кон outputot за тест случајите.

getType() методот треба да враќа:

1 за Square
2 за Circle
3 за Triangle
Дефинирајте го методот void checkNumTypes(Shape** niza, int n) така што ќе испечати во три реда колку квадрати, кругови и триаголници има во низата.

Покрај тоа треба да ја допишете Main класата така што ќе алоцирате динамичка низа од покажувачи кон класата Shape.

Потоа кај секој покажувач од низата зависно од дадениот input да алоцирате објект од една од трите изведени класи.

Input:

Прво се добива n - големината на динамичката низа. Потоа n пати се добиваат пар цели броеви t i a, каде што t е типот на објектот и а е страната на објектот.

Пример:

3

1 3 //квадрат со страна со должина 3

2 2 //круг со страна со должина 2

3 1 //триаголник со страна со должина 1

Поени: 3


input
5
1
2
2
1
3
3
3
1
2
2

output
Kvadrat so plostina = 4
Krug so plostina = 3.14
Triagolnik so plostina = 3.89711
Triagolnik so plostina = 0.433013
Krug so plostina = 12.56
Broj na kvadrati vo nizata = 1
Broj na krugovi vo nizata = 2
Broj na triagolnici vo nizata = 2
------------------------------------------------

input
	
3
1
2
2
1
3
3

output
Kvadrat so plostina = 4
Krug so plostina = 3.14
Triagolnik so plostina = 3.89711
Broj na kvadrati vo nizata = 1
Broj na krugovi vo nizata = 1
Broj na triagolnici vo nizata = 1

*/

#include <iostream>
#include <cmath>
using namespace std;


//TODO: konstruiraj ja abstraknata klasa Shape
class Shape{
protected:
    int a;
public:
    Shape(){}
    Shape(int a){
        this->a=a;
    }
    virtual double plostina()=0;
    virtual void pecati()=0;
    virtual int getType()=0;

    ~Shape(){}
};

//TODO: konstruiraj ja klasata Kvadrat
class Kvadrat : public Shape{
public:
    Kvadrat() : Shape(){}
    Kvadrat(int a) : Shape(a){}
    double plostina(){
        return a*a;
    }
    void pecati(){
        cout<<"Kvadrat so plostina = "<<plostina()<<endl;
    }
    int getType(){
        return 1;
    }
    ~Kvadrat(){}
};

//TODO: konstruiraj ja klasata Krug
class Krug : public Shape{
public:
    Krug() : Shape(){}
    Krug(int a) : Shape(a){}
    double plostina(){
        return 3.14*a*a;
    }
    void pecati(){
        cout<<"Krug so plostina = "<<plostina()<<endl;
    }
    int getType(){
        return 2;
    }
    ~Krug(){}
};

//TODO: konstruiraj ja klasata Triagolnik
class Triagolnik : public Shape{
public:
    Triagolnik() : Shape(){}
    Triagolnik(int a) : Shape(a){}
    double plostina(){
        return (sqrt(3)/4) * a * a;
    }
    void pecati(){
        cout<<"Triagolnik so plostina = "<<plostina()<<endl;
    }
    int getType(){
        return 3;
    }
    ~Triagolnik(){}
};


//TODO: definiraj go metodot void checkNumTypes(Shape** niza, int n)
void checkNumTypes(Shape** niza, int n){
    int bkv=0, bkr=0, btr=0;
    for (int i = 0; i < n; ++i) {
        if(niza[i]->getType()==1){bkv++;}
        else if(niza[i]->getType()==2){bkr++;}
        else if(niza[i]->getType()==3){btr++;}
    }
    cout<<"Broj na kvadrati vo nizata = "<<bkv<<endl;
    cout<<"Broj na krugovi vo nizata = "<<bkr<<endl;
    cout<<"Broj na triagolnici vo nizata = "<<btr<<endl;
}

int main(){


    int n;
    cin >> n;

    //TODO: inicijaliziraj niza od pokazuvachi kon klasata Shape

    //TODO: alociraj memorija so golemina n za prethodno navedenata niza
    Shape **niza = new Shape * [n];

    int classType;
    int side;

    //TODO: konstruiraj for ciklus so chija pomosh ke ja popolnish nizata
    for(int i = 0; i < n; ++i){

        cin >> classType;
        cin >> side;

        if(classType==1){
            niza[i] = new Kvadrat(side);
        }
        else if(classType==2){
            niza[i] = new Krug(side);
        }
        else if(classType==3){
            niza[i] = new Triagolnik(side);
        }
    }


    for(int i = 0; i < n; ++i){

        niza[i]->pecati();
    }

    checkNumTypes(niza, n);


    return 0;
}
