#include <iostream>
#include <cstring>
#include <fstream>


using namespace std;

void wtf() {
    ofstream fout("input.txt");

    string fname, lname;
    int points;
    string line;

    while (getline(std::cin, line)) {
        if (line == "----") {
            break;
        }
        fout << line << endl;
    }
}

void rff1() {
    ifstream fin("output1.txt");
    string line;
    while (getline(fin, line)) {
        cout << line << endl;
    }
}

void rff2() {
    ifstream fin("output2.txt");
    string line;
    while (getline(fin, line)) {
        cout << line << endl;
    }
}

class Book{
private:
    string naslov;
    string avtor;
    int godina;
public:
    Book(){
        this->naslov="";
        this->avtor="";
        this->godina=0;
    }
    Book(string naslov, string avtor, int godina){
        this->naslov=naslov;
        this->avtor=avtor;
        this->godina=godina;
    }
    friend ostream &operator<<(ostream &o, Book &b){
        o<<b.naslov<<" "<<b.avtor<<" "<<b.godina;
        return o;
    }
    bool operator==(Book &b){
        return this->naslov==b.naslov && this->avtor==b.avtor && this->godina==b.godina;
    }
    string getAvtor(){
        return avtor;
    }
    ~Book(){}
};


class BookAlreadyExistsException{
private:
    Book b;
public:
    BookAlreadyExistsException(Book &b){
        this->b=b;
    }
    void msg(){
        cout<<"Book \""<<b<<"\" already exists in the library"<<endl;
    }
};


class Library{
private:
    string ime;
    Book  *books;
    int n;
public:
    Library(){
        this->ime="";
        this->n=0;
        this->books=new Book[n];
    }
    Library(string ime){
        this->ime=ime;
        this->n=0;
        this->books=new Book[n];
    }
    Library &operator+=(Book &book){

        for (int i = 0; i < n; ++i) {
            if (books[i] == book){ //operator== od gore
                throw BookAlreadyExistsException(book);
            }
        }

        Book *tmp = new Book[n+1];
        for (int i = 0; i < n; ++i) {
            tmp[i]=books[i];
        }
        tmp[n++]=book;
        delete []books;
        books=tmp;

        return *this;
    }

    friend ostream &operator<<(ostream &o, Library &l){
        o<<l.ime<<endl;
        for (int i = 0; i < l.n; ++i) {
            o << l.books[i] << endl;
        }
        return o;
    }

    Book * getBooksByAuthor(string &author, int &numberFound){
        numberFound=0;
        for (int i = 0; i < n; ++i) {
            if (books[i].getAvtor() == author){
                ++numberFound;
            }
        }

        Book *result = new Book[numberFound];
        int j=0;
        for (int i = 0; i < n; ++i) {
            if (books[i].getAvtor() == author){
                result[j++]=books[i];
            }
        }


        if(numberFound==0){
            return nullptr;
        }
        else{
            return result;
        }
    }
    ~Library(){}
};


int main() {


    wtf(); //ja kreira datotekata input.txt


    //YOUR CODE STARTS HERE

    ifstream ifs("input.txt");

    string library_Ime;
    getline(ifs, library_Ime);

    Library l(library_Ime); //kreirame library

    int n;
    ifs>>n;
    ifs.ignore();

    string book_Naslov;
    string book_Avtor;
    int godina;

    for (int i = 0; i < n; ++i) {
        getline(ifs, book_Naslov);
        getline(ifs,book_Avtor);
        ifs>>godina;
        ifs.ignore();

//        cout << book_Naslov << " " << book_Avtor << " " << godina <<endl;

        Book b(book_Naslov, book_Avtor, godina); //kreirame kniga

        try{
            l += b;
        }
        catch (BookAlreadyExistsException &e){
            e.msg();
        }

    }

    ifs.close();

//    cout<<l<<endl;

    ofstream ofs1("output1.txt");
    ofs1<<l;
    ofs1.close();


    //DO NOT MODIFY THE NEXT PART

    string author;
    getline(std::cin, author);

    //DO NOT MODIFY THE PART ABOVE, CONTINUE AFTER THIS COMMENT

    ofstream ofs2("output2.txt");

    int number;
    Book *result = l.getBooksByAuthor(author, number);

    if (result== nullptr){
        ofs2<<"None";
    }
    for (int i = 0; i < number; ++i) {
        ofs2<<result[i]<<endl;
    }
    ofs2.close();

    //YOUR CODE ENDS HERE
    rff1();
    cout << "Books written by " << author << " are: " << endl;
    rff2();

    return 0;
}
