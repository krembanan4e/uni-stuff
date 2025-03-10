package hesh;
import java.util.*;
//strana 241 vo knigata

/*
Пример:
Влез:
5
27/01/2016 14:00 Rooms Kalkulus 1/Matematika 1
27/01/2016 08:00 Laboratories Napredno programiranje
28/01/2016 08:00 Laboratories Algoritmi i podatochni strukturi
28/01/2016 14:00 Rooms Diskretna matematika 1
28/01/2016 09:00 315 Kalkulus 3
28/01/2016

Излез:
08:00 Laboratories Algoritmi i podatochni strukturi
09:00 315 Kalkulus 3
14:00 Rooms Diskretna matematika 1
*/

public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, List<String>> table = new CBHT<>(2*n-1); //key e datumot, value e info za predmetot

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String date = line.substring(0, 10);
            String timePlusInfo = line.substring(11);

            SLLNode<MapEntry<String, List<String>>> curr = table.search(date);
            if (curr == null) {
                List<String> list = new ArrayList<>();
                list.add(timePlusInfo);
                table.insert(date, list);
            }
            else{
                List<String> list2 = curr.element.value;
                list2.add(timePlusInfo);
                table.insert(date, list2);
            }
        }

        String date = sc.nextLine();
        SLLNode<MapEntry<String, List<String >>> curr = table.search(date);
        if (curr == null) {
            System.out.println("Empty");
        }
        else{
            List<String> list = curr.element.value;
            Collections.sort(list); //sortirani spored satot
            
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
