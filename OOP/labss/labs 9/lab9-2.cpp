/*Дадени ви се класите User и SocialNetwork. 

Во класата User се чуваат информации за корисничко име, возраст и број на пријатели во рамки на некоја социјална мрежа.

Во класата SocialNetwork се чува листа на членови (објекти од класата User) и големина на листата.

Да се дополни почетниот код со следните работи:

- Да се спречи додавање на корисник со веќепостоечко корисничко име преку фрлање исклучок од тип UserAlreadyExistsException. Справете се со исклучокот на потребното место. 

- Да се додаде променлива за лимитот на дозволени пријатели на еден корисник (цел број). 
Променливата да важи за сите корисници (објекти од класа User) и истата да може да се менува преку методот setLimit. Иницијално променливата да има вредност 3.

- Да се фрли исклучок од тип UserNotFoundException во методот friendRequest доколку firstUsername или secondUsername не се кориснички имиња на корисници во социјалната мрежа. 
Справете се со исклучокот на потребното место. 

- Да се спречи зголемување на бројот на пријатели на некој корисник (над дозволениот лимит) со исклучок од тип FriendsLimitExceededException. 
Справете се со исклучокот на потребното место.


For example:

Input	
5
stefan.andonov 19
vlatko.spasev 20
marko.petrov 21
dimitar.kitanovski 22
ema.pandilova 18
0
0
0

Output
Registration of users
Users:
Username: stefan.andonov Age: 19 # of friends: 0
Username: vlatko.spasev Age: 20 # of friends: 0
Username: marko.petrov Age: 21 # of friends: 0
Username: dimitar.kitanovski Age: 22 # of friends: 0
Username: ema.pandilova Age: 18 # of friends: 0

Friend requests
Users:
Username: stefan.andonov Age: 19 # of friends: 0
Username: vlatko.spasev Age: 20 # of friends: 0
Username: marko.petrov Age: 21 # of friends: 0
Username: dimitar.kitanovski Age: 22 # of friends: 0
Username: ema.pandilova Age: 18 # of friends: 0

CHANGE STATIC VALUE
Users:
Username: stefan.andonov Age: 19 # of friends: 0
Username: vlatko.spasev Age: 20 # of friends: 0
Username: marko.petrov Age: 21 # of friends: 0
Username: dimitar.kitanovski Age: 22 # of friends: 0
Username: ema.pandilova Age: 18 # of friends: 0
*/

#include<iostream>
#include<cstring>
using namespace std;

class UserAlreadyExistsException {
//TODO
private:
    string username;
public:
    UserAlreadyExistsException(string username){
        this->username=username;
    }
    void message(){
        cout<<"User with username "<<username<<" already exists!"<<endl;
    }
};

class UserNotFoundException {
//TODO
private:
    string username;
public:
    UserNotFoundException(string username){
        this->username=username;
    }
    void message(){
        cout<<"User with username "<<username<<" was not found!"<<endl;
    }
};

class FriendsLimitExceededException {
//TODO
private:
    int limit;
public:
    FriendsLimitExceededException(int limit){
        this->limit=limit;
    }
    void message(){
        cout<<"Can't have more than "<<limit<<" friends."<<endl;
    }
};

class User {
private:
    char username[50];
    int age;
    int friends;
    static int LIMIT;

public:
    User(char *username = "", int age = 18) : age(age) {
        strcpy(this->username, username);
        friends = 0;
    }

    friend ostream &operator<<(ostream &os, const User &user) {
        os << "Username: " << user.username << " Age: " << user.age << " # of friends: " << user.friends;
        return os;
    }

    User &operator++() {
        ++friends;
        return *this;
    }

    static void setLimit(int l){
        LIMIT=l;
    }

    friend class SocialNetwork;


};
int User::LIMIT=3;

class SocialNetwork {
private:
    User *users;
    int n;
public:
    SocialNetwork() {
        n = 0;
        users = new User[n];
    }

    SocialNetwork &operator+=(User &u) {
        for (int i = 0; i < n; ++i) {
            if (strcmp(users[i].username, u.username)==0){
                throw UserAlreadyExistsException(u.username);
            }
        }

        User *tmp = new User[n + 1];
        for (int i = 0; i < n; i++) {
            tmp[i] = users[i];
        }
        tmp[n++] = u;
        delete[] users;
        users = tmp;
        return *this;
    }

    void friendRequest(char *firstUsername, char *secondUsername) {
        bool najdeVtor=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (strcmp(users[i].username, secondUsername) == 0){
                    najdeVtor= true;
                }
            }
        }
        
         if (!najdeVtor) {
            throw UserNotFoundException(secondUsername);
        }

        for (int i = 0; i < n; i++) {
            if (strcmp(users[i].username, firstUsername) == 0) {
                for (int j = 0; j < n; j++) {
                    if (strcmp(users[j].username, secondUsername) == 0) {
                        if (users[i].friends>=User::LIMIT || users[j].friends>=User::LIMIT){
                            throw FriendsLimitExceededException(User::LIMIT);
                        }
                        ++users[i];
                        ++users[j];
                        return;
                    }
                }
            }
        }
    }

    friend ostream &operator<<(ostream &os, const SocialNetwork &network) {
        os << "Users: " << endl;
        for (int i=0;i<network.n;i++) {
            os << network. users[i] << endl;
        }
        return os;
    }
};


int main() {
    SocialNetwork sn;
    int n;
    cin >> n;
    for (int i=0;i<n;i++){
        char username[50]; int age;
        cin >> username >> age;
        User u(username, age);
        try {
            sn += u;
        }
       catch (UserAlreadyExistsException &e){
           e.message();
       }

    }

    cout << "Registration of users " << endl;
    cout << sn << endl;
    cout << "Friend requests " << endl;

    int friendships;
    cin >> friendships;
    for (int i=0;i<friendships;i++){
        char username1[50], username2[50];
        cin >> username1 >> username2;
        try {
            sn.friendRequest(username1, username2);
        }
        catch (UserNotFoundException &u){
            u.message();
        }
        catch (FriendsLimitExceededException &f){
            f.message();
        }

    }

    cout << sn << endl;

    cout << "CHANGE STATIC VALUE" << endl;

    int maxFriends;
    cin >> maxFriends;
    cin >> friendships;
    User::setLimit(maxFriends);

    for (int i=0;i<friendships;i++){
        char username1[50], username2[50];
        cin >> username1 >> username2;

        try {
            sn.friendRequest(username1, username2);
        }
        catch (UserNotFoundException &u){
            u.message();
        }
        catch (FriendsLimitExceededException &f){
            f.message();
        }


    }
    cout << sn;
    return 0;
}
