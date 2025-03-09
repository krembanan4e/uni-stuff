//da se najt redot sho imat najmnogu razlicni bukvi?

#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;
 
 
int countDifferentChars(char str[])
{
    int azbuka[91] = {0};
    for(int i=0;i<strlen(str);i++)
    {
        if(isalpha(str[i])){
            if(azbuka[toupper(str[i])]==0)
            {
                azbuka[toupper(str[i])] = 1;
            }
        }
    }
    int differentChars = 0;
    for(int i=0;i<91;i++)
    {
        differentChars+=azbuka[i];
    }
    return differentChars;
}
 
 
int main()
{
    int maxBroj = 0;
    int maxRed =0;
    int daliPrvPat = 1;
    int brRed = 0;
    int najdenChar = 0;
    while(1)
    {
        char str[81];
        fgets(str,80,stdin);
 
        if(str[0]=='#')
        {
            break;
        }
        int diff =  countDifferentChars(str);
        if(diff>0)
        {
            najdenChar = 1;
        }
        if(daliPrvPat == 1)
        {
            daliPrvPat = 0;
            maxRed = brRed;
            maxBroj =diff;
        }
        if(diff>=maxBroj)
        {
            maxBroj = diff;
            maxRed = brRed;
        }
        brRed++;
    }
    if(najdenChar == 0)
    {
        cout<<"Ne postojat redovi koi sodrzat bukvi"<<endl;
    }
    else
    {
        cout<<"Najmnogu razlicni bukvi ("<<maxBroj<<") ima redot "<<maxRed<<endl;
    }
}
