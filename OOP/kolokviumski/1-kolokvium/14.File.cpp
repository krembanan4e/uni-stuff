/*
Потребно е да се имплементираат класи File (датотека) и Folder (директориум) за работа со едноставен податочен систем.

Во класата File треба да се чуваат следниве податоци:

Име на датотеката (динамички алоцирана низа од знаци)
Екстензија на датотеката (енумерација со можни вредности: txt, pdf, exe)
Име на сопственикот на датотеката (динамички алоцирана низа од знаци)
Големина на датотеката (цел број на мегабајти)
Дополнително, во класата потребно е да се напишат и:

Конструктор без параметри
Конструктор со параметри
Конструктор за копирање
Деструктор
Преоптоварување на операторот =
Метод за печатење на информациите за една датотека (видете го излезот од тест примерите за структурата на печатење) - print()
Метод за проверка на еднаквост помеѓу две датотеки со потпис bool equals(const File & that) кој ќе враќа true ако датотеките имаат исто име, екстензија и сопственик
Метод за споредба на типот помеѓу две датотеки со потпис bool equalsType(const File & that) кој ќе враќа true ако датотеките се од ист тип, т.е. имаат исто име и екстензија
Во класата Folder треба да се чуваат следниве податоци:

Име на директориумот (динамички алоцирана низа од знаци)
Број на датотеки во него (на почеток директориумот е празен)
Динамички алоцирана низа од датотеки, објекти од класата File
Дополнително, во класата потребно е да се напишат и:

Конструктор со потпис Folder(const char* name)
Деструктор
Метод за печатење на информациите за еден директориум (видете го излезот од тест примерите за структурата на печатење) - print()
Метод за бришење на датотека од директориумот со потпис void remove(const File & file) кој ќе ја избрише првата датотека од директориумот која е еднаква според equals методот
Метод за додавање на датотека во директориумот со потпис void add(const File & file) кој ќе додава датотеката во директориумот
Не го менувајте почетниот код.

Input
2
rezultati_oop
FINKI
2
0
rezultati_oop
FINKI
3
0
rezultati_oop
FINKI
1
1

Output
======= FILE EQUALS & EQUALS TYPE =======
File name: rezultati_oop.pdf
File owner: FINKI
File size: 2
File name: rezultati_oop.pdf
File owner: FINKI
File size: 3
File name: rezultati_oop.txt
File owner: FINKI
File size: 1
FIRST EQUALS SECOND: TRUE
FIRST EQUALS THIRD: FALSE
FIRST EQUALS TYPE SECOND: TRUE
SECOND EQUALS TYPE THIRD: FALSE
*/

#include<iostream>
#include<cstring>

using namespace std;

enum Extension{pdf, txt, exe};

class File{
private:
    char* ime;
    Extension ext;
    char* sopstvenik;
    int mb;
public:
    File(){
        this->ime = new char[0];
        this->ext = pdf;
        this->sopstvenik = new char[0];
        this->mb = 0;
    }
    File(char* ime, char* sopstvenik, int mb, Extension ext){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->sopstvenik = new char[strlen(sopstvenik)+1];
        strcpy(this->sopstvenik, sopstvenik);
        this->mb = mb;
        this->ext = ext;
    }
    File(const File &f){
        this->ime = new char[strlen(f.ime)+1];
        strcpy(this->ime, f.ime);
        this->sopstvenik = new char[strlen(f.sopstvenik)+1];
        strcpy(this->sopstvenik, f.sopstvenik);
        this->mb = f.mb;
        this->ext = f.ext;
    }
    File &operator=(const File &f){
        if(this!=&f){
            delete []ime;
            delete []sopstvenik;
            this->ime = new char[strlen(f.ime)+1];
            strcpy(this->ime, f.ime);
            this->sopstvenik = new char[strlen(f.sopstvenik)+1];
            strcpy(this->sopstvenik, f.sopstvenik);
            this->mb = f.mb;
            this->ext = f.ext;
        }
        return *this;
    }
    void print(){
        cout<<"File name: "<<ime<<".";
        switch (ext) {
            case 0: cout<<"pdf"; break;
            case 1: cout<<"txt"; break;
            case 2: cout<<"exe"; break;
        }
        cout<<endl;
        cout<<"File owner: "<<sopstvenik<<endl;
        cout<<"File size: "<<mb<<endl;
    }
    bool equals(const File & that){
        return strcmp(this->ime, that.ime)==0 && strcmp(this->sopstvenik, that.sopstvenik)==0 && this->ext==that.ext;
    }
    bool equalsType(const File & that){
        return strcmp(this->ime, that.ime)==0 && this->ext==that.ext;

    }
    ~File(){
        delete []ime;
        delete []sopstvenik;
    }
};

class Folder{
private:
    char *ime;
    int n;
    File *files;
public:
    Folder(){
        this->ime = new char[0];
        this->n = 0;
        this->files = new File[n];
    }
    Folder(const char *ime){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->n = 0;
        this->files = new File[n];
    }
    Folder(const Folder &f){
        this->ime = new char[strlen(f.ime)+1];
        strcpy(this->ime, f.ime);
        this->n = f.n;
        this->files = new File[n];
        for (int i = 0; i < n; ++i) {
            this->files[i] = f.files[i];
        }
    }
    Folder &operator=(const Folder &f){
        if(this!=&f){
            delete []ime;
            delete []files;
            this->ime = new char[strlen(f.ime)+1];
            strcpy(this->ime, f.ime);
            this->n = f.n;
            this->files = new File[n];
            for (int i = 0; i < n; ++i) {
                this->files[i] = f.files[i];
            }
        }
        return *this;
    }
    void print(){
        cout<<"Folder name: "<<ime<<endl;
        for (int i = 0; i < n; ++i) {
            files[i].print();
        }
    }
    void remove(const File & file){
        int counter=0;
        for (int i = 0; i < n; ++i) {
            if(files[i].equals(file)){
                counter++;
                break; //najdi go prviot i break-ni
            }
        }
        if(counter > 0){
            File *tmp = new File[n-counter];
            int j=0;
            for (int i = 0; i < n; ++i) {
                if(!files[i].equals(file)){ //aku ne se ednakvi togas dodaj go
                    tmp[j] = files[i];
                    j++;
                }
            }
            delete []files;
            files = tmp;
            n--; //!!!!!!!!!!!!!!!!!!!!!!!!!
        }
    }
    void add(const File & file){
        File *tmp = new File[n+1];
        for (int i = 0; i < n; ++i) {
            tmp[i] = files[i];
        }
        tmp[n++] = file;
        delete []files;
        files = tmp;
    }
    ~Folder(){
        delete []ime;
        delete []files;
    }
};

int main() {
    char fileName[20];
    char fileOwner[20];
    int ext;
    int fileSize;

    int testCase;
    cin >> testCase;
    if (testCase == 1) {
        cout << "======= FILE CONSTRUCTORS AND = OPERATOR =======" << endl;
        cin >> fileName;
        cin >> fileOwner;
        cin >> fileSize;
        cin >> ext;

        File created = File(fileName, fileOwner, fileSize, (Extension) ext);
        File copied = File(created);
        File assigned = created;

        cout << "======= CREATED =======" << endl;
        created.print();
        cout << endl;
        cout << "======= COPIED =======" << endl;
        copied.print();
        cout << endl;
        cout << "======= ASSIGNED =======" << endl;
        assigned.print();
    }
    else if (testCase == 2) {
        cout << "======= FILE EQUALS & EQUALS TYPE =======" << endl;
        cin >> fileName;
        cin >> fileOwner;
        cin >> fileSize;
        cin >> ext;

        File first(fileName, fileOwner, fileSize, (Extension) ext);
        first.print();

        cin >> fileName;
        cin >> fileOwner;
        cin >> fileSize;
        cin >> ext;

        File second(fileName, fileOwner, fileSize, (Extension) ext);
        second.print();

        cin >> fileName;
        cin >> fileOwner;
        cin >> fileSize;
        cin >> ext;

        File third(fileName, fileOwner, fileSize, (Extension) ext);
        third.print();

        bool equals = first.equals(second);
        cout << "FIRST EQUALS SECOND: ";
        if (equals)
            cout << "TRUE" << endl;
        else
            cout << "FALSE" << endl;

        equals = first.equals(third);
        cout << "FIRST EQUALS THIRD: ";
        if (equals)
            cout << "TRUE" << endl;
        else
            cout << "FALSE" << endl;

        bool equalsType = first.equalsType(second);
        cout << "FIRST EQUALS TYPE SECOND: ";
        if (equalsType)
            cout << "TRUE" << endl;
        else
            cout << "FALSE" << endl;

        equalsType = second.equals(third);
        cout << "SECOND EQUALS TYPE THIRD: ";
        if (equalsType)
            cout << "TRUE" << endl;
        else
            cout << "FALSE" << endl;

    }
    else if (testCase == 3) {
        cout << "======= FOLDER CONSTRUCTOR =======" << endl;
        cin >> fileName;
        Folder folder(fileName);
        folder.print();

    }
    else if (testCase == 4) {
        cout << "======= ADD FILE IN FOLDER =======" << endl;
        char name[20];
        cin >> name;
        Folder folder(name);

        int iter;
        cin >> iter;

        while (iter > 0) {
            cin >> fileName;
            cin >> fileOwner;
            cin >> fileSize;
            cin >> ext;

            File file(fileName, fileOwner, fileSize, (Extension) ext);
            folder.add(file);
            iter--;
        }
        folder.print();
    }
    else {
        cout << "======= REMOVE FILE FROM FOLDER =======" << endl;
        char name[20];
        cin >> name;
        Folder folder(name);

        int iter;
        cin >> iter;

        while (iter > 0) {
            cin >> fileName;
            cin >> fileOwner;
            cin >> fileSize;
            cin >> ext;

            File file(fileName, fileOwner, fileSize, (Extension) ext);
            folder.add(file);
            iter--;
        }
        cin >> fileName;
        cin >> fileOwner;
        cin >> fileSize;
        cin >> ext;

        File file(fileName, fileOwner, fileSize, (Extension) ext);
        folder.remove(file);
        folder.print();
    }
    return 0;
}
