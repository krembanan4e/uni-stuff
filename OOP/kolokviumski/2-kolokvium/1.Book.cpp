/*
1. Издавачката куќа FINKI-Education издава онлајн и печатени книги. За секоја книга се чуваат податоци за ISBN бројот (низа од најмногу 20 знаци), 
насловот (низа од најмногу 50 знаци), авторот (низа од најмногу 30 знаци) и основната цена изразена во $ (реален број). Класата за опишување на книгите е апстрактна (5 поени).
За секоја онлајн книга дополнително се чуваат податоци за url од каде може да се симне (динамички резервирана низа од знаци) и големината изразена во MB (цел број). 
За секоја печатена книга дополнително се чуваат податоци за масата изразена во килограми (реален број) и дали ја има на залиха (логичка променлива). (5 поени)
За секој објект од двете изведени класи треба да бидат на располагање следниве методи:
Метод bookPrice, за пресметување на продажната цена на книгата на следниот начин: (10 поени)
За онлајн книга - цената се зголемува за 20% од основната цена ако книгата е поголема од 20MB
За печатена книга - цената се зголемува за 15% од основната цена ако масата на книгата е поголема од 0.7kg
Преоптоварен оператор > за споредба на две книги од каков било вид според нивната цена. (5 поени)
Преоптоварен оператор << за печатење на податоците за книгите во формат: (5 поени)
Да се имплементира функција mostExpensiveBook со потпис:
void mostExpensiveBook (Book** books, int n)
во која се печати вкупниот број на онлајн, односно, печатени книги во проследената низа посебно. (5 поени) Потоа се наоѓа и печати најскапата книга. (5 поени)
Да се обезбедат сите потребни функции за правилно функционирање на програмата. (5 поени)

input
4
3
1
0-312-31677-1
The Moscow Vector
Robert Ludlum
7
www.finki-education/olinebooks/book1.pdf
1
2
007-6092006565
Thinking in C++
Bruce Eckel
52
1.2
1
1
978-0672326974
C++ Primer Plus
Stephen Prata
20
www.finki-education/olinebooks/book2.pdf
30

output
====== Testing method mostExpensiveBook() ======
FINKI-Education
Total number of online books: 2
Total number of print books: 1
The most expensive book is: 
007-6092006565: Thinking in C++, Bruce Eckel 59.8
*/

#include <iostream>
#include <cstring>

using namespace std;

class Book{
protected:
    char ISBN[20];
    char naslov[50];
    char avtor[30];
    float osnovnaCena;
public:
    Book(){}
    Book(char* ISBN, char* naslov, char* avtor, float osnovnaCena){
        strcpy(this->ISBN, ISBN);
        strcpy(this->naslov, naslov);
        strcpy(this->avtor, avtor);
        this->osnovnaCena=osnovnaCena;
    }
    virtual float bookPrice() = 0;
    bool operator>(Book &b){
        return this->osnovnaCena > b.osnovnaCena;
    }
    friend ostream &operator<<(ostream &o, Book &b){
        o<<b.ISBN<<": "<<b.naslov<<", "<<b.avtor<<" "<<b.bookPrice()<<endl;
        return o;
    }
    virtual int tip() = 0;

    virtual ~Book(){}
};

class OnlineBook : public Book{
private:
    char *url;
    int mb;
public:
    OnlineBook() : Book(){
        this->url = new char[0];
    }
    OnlineBook(char* ISBN, char* naslov, char* avtor, float osnovnaCena,
               char* url, int mb) : Book(ISBN, naslov, avtor, osnovnaCena){
        this->url=new char[strlen(url)+1];
        strcpy(this->url, url);
        this->mb=mb;
    }
    OnlineBook(const OnlineBook &ob) : Book(ob){
        this->url=new char[strlen(ob.url)+1];
        strcpy(this->url, ob.url);
        this->mb=ob.mb;
    }
    OnlineBook &operator=(const OnlineBook &ob){
        if(this!=&ob) {
            delete[]url;
            Book::operator=(ob);
            this->url = new char[strlen(ob.url) + 1];
            strcpy(this->url, ob.url);
            this->mb = ob.mb;
        }
        return *this;
    }
    float bookPrice(){
        float osnovna=Book::osnovnaCena;
        if (mb>20){
            return osnovna*1.20;
        }
        else{
            return osnovna;
        }
    }
    void setISBN(char* isbn){
        strcpy(this->ISBN, isbn);
    }
    friend ostream &operator<<(ostream &o, OnlineBook &ob){
        o<<ob.ISBN<<": "<<ob.naslov<<", "<<ob.avtor<<" "<<ob.bookPrice()<<endl;
        return o;
    }
    int tip(){
        return 1;
    }
    ~OnlineBook(){
        delete []url;
    }
};

class PrintBook : public Book{
private:
    float kg;
    bool daliJaIma;
public:
    PrintBook() : Book(){}
    PrintBook(char* ISBN, char* naslov, char* avtor, float osnovnaCena,
               float kg, bool daliJaIma) : Book(ISBN, naslov, avtor, osnovnaCena){
        this->kg=kg;
        this->daliJaIma=daliJaIma;
    }
    float bookPrice(){
        float osnovna=Book::osnovnaCena;
        if(kg>0.7){
            return osnovna*1.15;
        } else{
            return osnovna;
        }
    }
    friend ostream &operator<<(ostream &o, PrintBook &pb){
        o<<pb.ISBN<<": "<<pb.naslov<<", "<<pb.avtor<<" "<<pb.bookPrice()<<endl;
        return o;
    }
    int tip(){
        return 2;
    }
    ~PrintBook(){}
};

void mostExpensiveBook (Book** books, int n){
    int br_online=0, br_pecateni=0;
    for (int i = 0; i < n; ++i) {
        OnlineBook *ob = dynamic_cast<OnlineBook*>(books[i]);
        if(ob!= nullptr){
            br_online++;
        }
        else{
            br_pecateni++;
        }
    }

    Book *b = books[0];
    for (int i = 1; i < n; ++i) {
        if (books[i]->bookPrice() > b->bookPrice()){
            b=books[i];
        }
    }

    cout<<"FINKI-Education"<<endl;
    cout<<"Total number of online books: "<<br_online<<endl;
    cout<<"Total number of print books: "<<br_pecateni<<endl;
    cout<<"The most expensive book is:"<<endl;
    cout<<*b;
}

int main(){

	char isbn[20], title[50], author[30], url[100];
	int size, tip;
	float price, weight;
	bool inStock;
	Book  **books;
	int n;

	int testCase;
	cin >> testCase;

	if (testCase == 1){
		cout << "====== Testing OnlineBook class ======" << endl;
		cin >> n;
		books = new Book *[n];

		for (int i = 0; i < n; i++){
			cin >> isbn;
			cin.get();
			cin.getline(title, 50);
			cin.getline(author, 30);
			cin >> price;
			cin >> url;
			cin >> size;
			cout << "CONSTRUCTOR" << endl;
			books[i] = new OnlineBook(isbn, title, author, price, url, size);
			cout << "OPERATOR <<" << endl;
			cout << *books[i];
		}
		cout << "OPERATOR >" << endl;
		cout << "Rezultat od sporedbata e: " << endl;
		if (*books[0] > *books[1])
			cout << *books[0];
		else
			cout << *books[1];
	}
	if (testCase == 2){
		cout << "====== Testing OnlineBook CONSTRUCTORS ======" << endl;
		cin >> isbn;
		cin.get();
		cin.getline(title, 50);
		cin.getline(author, 30);
		cin >> price;
		cin >> url;
		cin >> size;
		cout << "CONSTRUCTOR" << endl;
		OnlineBook ob1(isbn, title, author, price, url, size);
		cout << ob1 << endl;
		cout << "COPY CONSTRUCTOR" << endl;
		OnlineBook ob2(ob1);
		cin >> isbn;
		ob2.setISBN(isbn);
		cout << ob1 << endl;
		cout << ob2 << endl;
		cout << "OPERATOR =" << endl;
		ob1 = ob2;
		cin >> isbn;
		ob2.setISBN(isbn);
		cout << ob1 << endl;
		cout << ob2 << endl;
	}
	if (testCase == 3){
		cout << "====== Testing PrintBook class ======" << endl;
		cin >> n;
		books = new Book *[n];

		for (int i = 0; i < n; i++){
			cin >> isbn;
			cin.get();
			cin.getline(title, 50);
			cin.getline(author, 30);
			cin >> price;
			cin >> weight;
			cin >> inStock;
			cout << "CONSTRUCTOR" << endl;
			books[i] = new PrintBook(isbn, title, author, price, weight, inStock);
			cout << "OPERATOR <<" << endl;
			cout << *books[i];
		}
		cout << "OPERATOR >" << endl;
		cout << "Rezultat od sporedbata e: " << endl;
		if (*books[0] > *books[1])
			cout << *books[0];
		else
			cout << *books[1];
	}
	if (testCase == 4){
		cout << "====== Testing method mostExpensiveBook() ======" << endl;
		cin >> n;
		books = new Book *[n];

		for (int i = 0; i<n; i++){

			cin >> tip >> isbn;
			cin.get();
			cin.getline(title, 50);
			cin.getline(author, 30);
			cin >> price;
			if (tip == 1) {

				cin >> url;
				cin >> size;

				books[i] = new OnlineBook(isbn, title, author, price, url, size);

			}
			else {
				cin >> weight;
				cin >> inStock;

				books[i] = new PrintBook(isbn, title, author, price, weight, inStock);
			}
		}

		mostExpensiveBook(books, n);
	}

	for (int i = 0; i<n; i++) delete books[i];
		delete[] books;
	return 0;
}
