package hash;

/*
Поради ковид пандемијата при секое тестирање на даден пациент се зачувува општината во која живее, неговото презиме и дали е позитивен или негативен на корона вирусот.
Потребни се статистички податоци во коишто ќе се одреди ризик факторот за дадена општина.
За таа цел се чуваат две хеш табели (СВНТ) едната за позитивни, а другата за негативни пациенти од корона вирусот.
Ваша задача е за дадена општина на излез да го испечатите ризик факторот во дадената општина.

                                 (број на позитивни)
Ризик фактор =  ----------------------------------------------------------
                (број на негативни пациенти + број на позитивни пациенти)

Забелешка: Можно е да се појават пациенти со исто презиме. Истите треба да се земат како посебни вредности во статистиката.
Влез:
На влез најпрво е даден бројот на пациенти N, а потоа секој пациент е даден во нов ред во форматот:
"Општина во која живее" "Презиме на пациент" "Резултати од тестот (позитивен/негативен)"
На крај е дадена општината за која треба да се пресмета ризик факторот
Излез:
Децимален број заокружен на две децимали кој го претставува ризик факторот за дадената општина

Пример:
Влез:
6
Центар Стојаноски негативен
Центар Трајковски позитивен
Центар Петковски позитивен
Карпош Стојаноски позитивен
Карпош Трајковски негативен
Центар Трајковски позитивен
Центар
Излез: 0.75
(излезот се добива како 3/(1+3) за општината Центар)
 */

import java.util.*;

public class Ispitna_Pandemija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> pozitivni = new CBHT<>(2*n-1);
        CBHT<String, Integer> negativni = new CBHT<>(2*n-1);

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String opstina = parts[0];
            String pozNeg = parts[2];

            if (pozNeg.equals("позитивен")){
                SLLNode<MapEntry<String, Integer>> curr = pozitivni.search(opstina);
                if (curr == null){
                    pozitivni.insert(opstina, 1);
                }
                else {
                    pozitivni.insert(opstina, curr.element.value + 1);
                }
            }
            else if (pozNeg.equals("негативен")){
                SLLNode<MapEntry<String, Integer>> curr = pozitivni.search(opstina);
                if (curr == null){
                    negativni.insert(opstina, 1);
                }
                else {
                    negativni.insert(opstina, curr.element.value + 1);
                }
            }
        }

        String opstina = sc.nextLine();

        SLLNode<MapEntry<String, Integer>> currP = pozitivni.search(opstina);
        SLLNode<MapEntry<String, Integer>> currN = negativni.search(opstina);

        int brojPoz = currP.element.value;
        int brojNeg = currN.element.value;

        float rez = (float) brojPoz / (brojNeg + brojPoz);

        System.out.println(String.format("%.2f", rez));
    }
}
