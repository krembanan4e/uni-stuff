/*Дефинираме вредност d за тројка цели броеви a,b,c, такашто таа се пресметува како сума меѓу апсолутните разлики
 * од првиот и вториот број, од една страна, и вториот и третиот од друга страна: d = |(a-b)| + |(b-c)|
 * Да се напише програма со којашто од тастаура се вчитуваат N тројки цели броеви (N се внесува од тастатура), и
 * којашто ја наоѓа и јa печати најмалата вредност за d од прочитаните тројки. Вредноста d за секоја од тројките
 * се пресметува ВО ФУНКЦИЈА.
 *
 * input        output        input      output
 * 3            0             5          6
 * 1 2 3                      1 21 3
 * 22 30 22                   5 8 4
 * 1 1 1                      2 1 9
 *                            21 42 81
 *                            2 5 2
 *
 * Објаснување: за тројката 1 2 3 вредноста на d e: |(1-2)+(2-3)| = 2, за 22 30 22 = 16, за 1 1 1 = 0. */

#include <iostream>
#include <cmath>

using namespace std;

int vrednostNaD(int x, int y, int z) {
    int xy = abs(x - y);
    int yz = abs(y - z);
    int d = xy + yz;
    return d;
}

int main() {
    int n, a, b, c, a1, b1, c1, najmalaVrednostNaD;
    cin >> n >> a >> b >> c;
    najmalaVrednostNaD = vrednostNaD(a, b, c);
    for (int i = 1; i <= n - 1; i++) {
        cin >> a1 >> b1 >> c1;
        if (najmalaVrednostNaD > vrednostNaD(a1, b1, c1)) {
            najmalaVrednostNaD = vrednostNaD(a1, b1, c1);
        }
    }
    cout << najmalaVrednostNaD << endl;

    return 0;
}
