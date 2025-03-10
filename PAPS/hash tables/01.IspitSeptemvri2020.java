package hash;

/*
Индекс на книга 
Да се овозможи пребарување на збор или израз во индекс на книга и како резултат да се врати на која страна се појавува или зборот или ако е израз, целиот израз.
Доколку зборот не постои во индексот на книгата, да се испечати "Not found“. Да не се прави разлика помеѓу големи и мали букви при пребарување на збор.
Доколку даден збор се повторува во повеќе изрази од индексот, при пребарување на тој збор, се прикажува бројот на страната која е последно внесена.
(пример, доколку во индексот се внесе: Alan Turing, 72 Alan Ford, 44 и потоа се пребара зборот Alan, програмата треба да отпечати 44, бидејќи таа страна е последно внесена.
Пребарувањата на изразите Alan Turing и Alan Ford како изрази треба да вратат 72 и 44, соодветно)
Влез: Се внесува индексот на книгата (израз и број на страница разделени со) се до внесување на знакот #.
По знакот #, се внесува N кој означува колку зборови ќе се пребаруваат. Во следните редови се читаат N зборови
Излез: За секој од внесените зборови/изрази, во нов ред треба да се ипечати страницата во која се наоѓа зборот (или "Not found", доколку зборот не е во индексот на книгата).
Делумно решение: Проблемот е делумно решен ако поминат 7 тест случаи.
Име на класа (Јава): Book.java
Забелешка: При реализација на задачите МОРА да се користат соодветни податочни структури. Забрането користење на поврзани листи, низи и сл.

input:
Mongol Invasions of Japan, 21
diplomatic relations, 46
Shelter for the Indigent, 29
Vehicle storage, 166
Soldiers, 265
Soviet Union, 193
Engineer-Building Workers team, 288
Medical services, 300
Temporary Rules, 147
Teutonic Knights, 130
Travel Pass, 271
World War II, 236
#
6
diplomatic relations
Japan
Cloud
mongol japan
engineer-building Workers team
MEDICAL

output:
46
21
Not found
Not found
288
300
 */

import java.util.*;

/*
za sekoj zbor od edna linija od inputot, go chuvam celiot izraz i stranicata
primer za "Mongol Invasions of Japan, 21" chuvam 

<mongol, <mongol invasions of japan, 21>>
<invasions, <mongol invasions of japan, 21>>
<of, <mongol invasions of japan, 21>>
<japan, <mongol invasions of japan, 21>>

sekoj zbor se mapirat vo celiot izraz + stranicata

se prebarvit spored prviot zbor, i aku vneseniot izrazot se sostojt vo celiot izraz (od Info) togas se pecatit stranicata
aku ne se sostojt ili go nemat toj key se pecatit Not found
 */

class Info{
    String izraz;
    int strana;

    public Info(String izraz, int strana) {
        this.izraz = izraz;
        this.strana = strana;
    }
}

public class IspitSeptemvri2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<String, Info> table = new CBHT<>(100);

        while (true){
            String line = sc.nextLine();
            if (line.equals("#")){
                break;
            }

            String []parts = line.split(", ");
            String izraz = parts[0].toLowerCase();
            int strana = Integer.parseInt(parts[1]);
            String []words = izraz.split(" ");

            for (String word : words){
                word = word.toLowerCase();
                Info info = new Info(izraz, strana);
                table.insert(word, info);
            }
        }

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String line = sc.nextLine().toLowerCase();
            String []words = line.split(" ");

            for (String word : words){
                SLLNode<MapEntry<String, Info>> curr = table.search(word);
                if (curr == null){
                    System.out.println("Not found");
                }
                else{
                    if (curr.element.value.izraz.contains(line)){
                        System.out.println(curr.element.value.strana);
                        break;
                    }
                    else{
                        System.out.println("Not found");
                        break;
                    }
                }
            }
        }
    }
}
