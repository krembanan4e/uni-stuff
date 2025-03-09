/*
1
JohnDoe
This is a Facebook post.
1
100
50


2
Jane Smith
This is a Twitter post about bitcoin. #crypto
1
50
20
10
*/


#include<iostream>
#include<cstring>

using namespace std;

/*
YOUR CODE HERE

DO NOT MODIFY THE FUNCTIONS BELOW!!!
*/

class Post{
protected:
    string username;
    string sodrzina;
    bool daliSlika;
    int broj_lajkovi;
public:
    Post(){
        this->username="";
        this->sodrzina="";
        this->daliSlika= false;
        this->broj_lajkovi=0;
    }
    Post(string username, string sodrzina, bool daliSlika, int broj_lajkovi){
        this->username=username;
        this->sodrzina=sodrzina;
        this->daliSlika=daliSlika;
        this->broj_lajkovi=broj_lajkovi;
    }
    virtual double popularity() = 0;
    virtual void print() = 0;
    bool operator>=(Post &p){
        return this->popularity() >= p.popularity();
    }
    bool getDaliSlika(){
        return daliSlika;
    }
    virtual ~Post(){}
};

class FacebookPost : public Post{
private:
    int shares;
public:
    FacebookPost() : Post(){
        this->shares=0;
    }
    FacebookPost(string username, string sodrzina, bool daliSlika, int broj_lajkovi,
                 int broj_spodeluvanja) : Post(username, sodrzina, daliSlika, broj_lajkovi){
        this->shares=broj_spodeluvanja;
    }
    double popularity(){
        double p=broj_lajkovi*shares;
        if (daliSlika){
            p*=1.2;
        }
        return p;
    }
    void print(){
        cout<<"Facebook post"<<endl;
        cout<<"Username: "<<username<<endl;
        cout<<"Content: "<<sodrzina<<endl;
        if (daliSlika){
            cout<<"With photo"<<endl;
        }
        cout<<"Likes: "<<broj_lajkovi<<" Shares: "<<shares<<endl;
        cout<<"Popularity: "<<popularity()<<endl;
    }
    ~FacebookPost(){}
};

class TwitterPost : public Post{
private:
    int retweets;
    int replies;
public:
    TwitterPost() : Post(){
        this->retweets=0;
        this->replies=0;
    }
    TwitterPost(string username, string sodrzina, bool daliSlika, int broj_lajkovi,
    int retweets, int replies) : Post(username, sodrzina, daliSlika, broj_lajkovi){
        this->retweets=retweets;
        this->replies=replies;
    }

    double popularity(){
        double p=broj_lajkovi*retweets*replies;
        if (daliSlika){
            p*=1.1;
        }
        if (sodrzina.find("#crypto")!=-1){
            p*=1.2;
        }
        return p;
    }
    void print(){
        cout<<"Twitter post"<<endl;
        cout<<"Username: "<<username<<endl;
        cout<<"Content: "<<sodrzina<<endl;
        if (daliSlika){
            cout<<"With photo"<<endl;
        }
        cout<<"Likes: "<<broj_lajkovi<<" Retweets: "<<retweets<<" Replies: "<<replies<<endl;
        cout<<"Popularity: "<<popularity()<<endl;
    }
    ~TwitterPost(){}
};

double mostPopularPostWithPhoto(Post **posts, int n){
    int id=-1;
    for (int i = 0; i < n; ++i) {
        if (posts[i]->getDaliSlika()){
            if (posts[i]->popularity() > posts[id]->popularity()){
                id=i;
            }
        }
    }
    return posts[id]->popularity();
}

Post * leastPopularTwitterPost(Post **posts, int n){
    Post * leastPopular = nullptr;

    for (int i = 0; i < n; ++i) {
        TwitterPost *t = dynamic_cast<TwitterPost*>(posts[i]);
        if (t){
            if (leastPopular == nullptr){ //ova e prviot twitter post
                leastPopular = posts[i];
            }
            else if(posts[i]->popularity() < leastPopular->popularity()){
                leastPopular = posts[i];
            }
        }
    }
    return leastPopular;
}


Post *readFbPost() {
    string username;
    string content;
    bool photo;
    int likes;
    int shares;
    cin.ignore();
    getline(std::cin, username);
    getline(std::cin, content);
    cin >> photo >> likes >> shares;
    return new FacebookPost(username, content, photo, likes, shares);
}

Post *readTwPost() {
    string username;
    string content;
    bool photo;
    int likes;
    int retweets;
    int replies;
    cin.ignore();
    getline(std::cin, username);
    getline(std::cin, content);
    cin >> photo >> likes >> retweets >> replies;
    return new TwitterPost(username, content, photo, likes, retweets, replies);
}

Post **readMultiplePosts(int *n) {

    cin >> *n;
    Post **posts = new Post *[*n];
    for (int i = 0; i < *n; i++) {
        int type;
        cin >> type;
        if (type == 1) {
            posts[i] = readFbPost();
        } else {
            posts[i] = readTwPost();
        }
    }
    return posts;
}

int main() {
    int testCase;

    cin >> testCase;

    if (testCase == 1) {
        cout << "Test FacebookPost" << endl;
        Post *post = readFbPost();
        cout << "Popularity: " << post->popularity() << endl;
        post->print();
    } else if (testCase == 2) {
        cout << "Test TwitterPost" << endl;
        Post *post = readTwPost();
        cout << "Popularity: " << post->popularity() << endl;
        post->print();
    } else if (testCase == 3) {
        cout << "Test operator >=" << endl;
        int n;
        Post **posts = readMultiplePosts(&n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((*posts[i]) >= (*posts[j])) {
                        cout << i << " >= " << j << endl;
                    } else {
                        cout << i << " < " << j << endl;
                    }
                }
            }
        }
    } else {
        int n;
        Post **posts = readMultiplePosts(&n);
        for (int i = 0; i < n; i++) {
            posts[i]->print();
            cout << endl;
        }
        cout << "The most popular post with photo has a popularity of: " << mostPopularPostWithPhoto(posts, n) << endl;

        cout << "The least popular twitter post is: " << endl;
        Post * result = leastPopularTwitterPost(posts,n);
        if (result== nullptr){
            cout << "None";
        } else {
            result->print();
        }
    }

    return 0;
}
