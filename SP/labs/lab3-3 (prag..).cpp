//Во државата Х е воведен прогресивен данок на личен доход.
//Потребно е да напишете програма која ќе им помогне на вработените во УЈП на државата Х да го пресметува данокот на определен граѓанин.
//Од стандарден влез се читаат 5 броеви процент0, праг1, процент1, праг2, процент2, а потоаа се чита износот на примањата на граѓанинот.
//На екран треба да се испечати износот на данокот на личниот доход пресметан со прогресивна стапка.
//Објаснување:
// процент 0 = 10%
// праг 1 = 1000
// процент 1 = 20%
// праг 2 = 2500
// процент 2 = 30%
// износ на примања = 3800
// Првите 1000 се оданочуваат со стапка 10%, па наредните 1500 се оданочуваат со 20% и останатите 1300 со 30%.
// Резултат = 1000 * 0.1 + 1500 * 0.2 + 1300 * 0.3 = 790

#include <iostream>
using namespace std;
int main() {
    int procent0, prag1, procent1, prag2, procent2, iznosPrimanja, iznosDanok;
    int sumaDanok=0, razlika1, razlika2, razlika3;
    cin >> procent0 >> prag1 >> procent1 >> prag2 >> procent2 >> iznosPrimanja;
    razlika1 = iznosPrimanja - ( ( iznosPrimanja - prag2 ) + ( prag2 - prag1 ) );
    razlika2 = prag2 - razlika1;
    razlika3 = iznosPrimanja - prag2;
    for ( int i = 0; i <= iznosPrimanja; i++ ){
        iznosDanok = 0;
        if ( i == prag1 ){
            iznosDanok += ( razlika1 * ( (float) procent0 / 100 ));
        }
        if ( i == prag2 ){
            iznosDanok += ( razlika2 * ( (float) procent1 / 100 ));
        }
        if ( i == iznosPrimanja ){
            iznosDanok += ( razlika3 * ( (float) procent2 / 100 ));
        }
        sumaDanok += iznosDanok;
    }
    cout << sumaDanok;
    return 0;
}
