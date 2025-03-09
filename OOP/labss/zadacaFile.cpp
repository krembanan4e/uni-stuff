#include<iostream>
#include<cstring>

using namespace std;

enum Extension{
    pdf,
    txt,
    exe
};

class File{
private:
    char* ime;
    Extension ext;
    char* ime_sopstvenik;
    int mb;
public:
    File(){
        this->ime = new char[0];
        this->ime_sopstvenik = new char[0];
        this->mb = 0;
        this->ext = pdf;
    }
    File(char* ime, char* ime_sopstvenik, int mb, Extension ext){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->ime_sopstvenik = new char[strlen(ime_sopstvenik)+1];
        strcpy(this->ime_sopstvenik, ime_sopstvenik);
        this->mb = mb;
        this->ext = ext;
    }
    File(const File &f){
        this->ime = new char[strlen(f.ime)+1];
        strcpy(this->ime, f.ime);
        this->ext = f.ext;
        this->ime_sopstvenik = new char[strlen(f.ime_sopstvenik)+1];
        strcpy(this->ime_sopstvenik, f.ime_sopstvenik);
        this->mb = f.mb;
    }
    File &operator=(const File &f){
        if(this!=&f){
            delete []ime;
            delete []ime_sopstvenik;
            this->ime = new char[strlen(f.ime)+1];
            strcpy(this->ime, f.ime);
            this->ext = f.ext;
            this->ime_sopstvenik = new char[strlen(f.ime_sopstvenik)+1];
            strcpy(this->ime_sopstvenik, f.ime_sopstvenik);
            this->mb = f.mb;
        }
        return *this;
    }
    bool equals(const File & that){
        if (strcmp(this->ime, that.ime)==0 && strcmp(this->ime_sopstvenik, that.ime_sopstvenik)==0){
            if(this->ext == that.ext){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    bool equalsType(const File & that){
        if (strcmp(this->ime, that.ime)==0){
            if(this->ext == that.ext){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    void print(){
        cout<<"File name: "<<ime<<".";
        switch (ext) {
            case 0: cout<<"pdf"; break;
            case 1: cout<<"txt"; break;
            case 2: cout<<"exe"; break;
        }
        cout<<endl;
        cout<<"File owner: "<<ime_sopstvenik<<endl;
        cout<<"File size: "<<mb<<endl;
    }
    ~File(){
        delete []ime;
        delete []ime_sopstvenik;
    }
};

class Folder{
private:
    char* ime;
    int n; //br na datoteki
    File* d; //niza od datoteki
public:
    Folder(){
        this->ime = new char[0];
        this->n = 0;
        this->d = new File[n];
    }
    Folder(char* ime){
        this->ime = new char[strlen(ime)+1];
        strcpy(this->ime, ime);
        this->n = 0;
        this->d = new File[n];
    }
    Folder(const Folder &fo){
        this->ime = new char[strlen(fo.ime)+1];
        this->n = fo.n;
        this->d = new File[n];
    }
    Folder &operator= (const Folder &fo){
        if(this!=&fo){
            delete []ime;
            delete []d;
            this->ime = new char[strlen(fo.ime)+1];
            this->n = fo.n;
            this->d = new File[n];
        }
        return *this;
    }
    void remove(const File & file){
        bool najde=false;
        for (int i = 0; i < n; ++i) {
            if (d[i].equals(file)){
                najde=true;
                break;
            }
        }
        if(najde){
            int j=0;
            File *tmp = new File[n-1];
            for (int i = 0; i < n; ++i) {
                if (!d[i].equals(file)){
                    tmp[j] = d[i];
                    j++;
                }
            }
            delete []d;
            d = tmp;
            n--;
        }
    }
    void add(const File & file){
        File *tmp = new File[n+1];
        for (int i = 0; i < n; ++i) {
            tmp[i] = d[i];
        }
        tmp[n] = file;
        delete []d;
        d = tmp;
        n++;
    }
    void print(){
        cout<<"Folder name: "<<ime<<endl;
        for (int i = 0; i < n; ++i) {
            d[i].print();
        }
    }
    ~Folder(){
        delete []ime;
        delete []d;
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
