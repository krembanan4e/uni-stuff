package hash;

/*
4
Ohrid 10:00 12:00 23.1
Skopje 09:00 10:30 24
Ohrid 12:00 13:00 25
Skopje 10:00 11:00 26.2
Ohrid

Излез:
Ohrid:
10:00 - 12:00 23.10
12:00 - 13:00 25.00
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Merenje{
    String city;
    String from;
    String to;
    float temperature;

    public Merenje(String city, String from, String to, float temperature) {
        this.city = city;
        this.from = from;
        this.to = to;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return from + " - " + to + " " + String.format("%.2f", temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, List<Merenje>> table = new CBHT<>(2*n-1);
        for (int i=0; i<n; i++){
            String city = sc.next();
            String from = sc.next();
            String to = sc.next();
            float temperature = sc.nextFloat();
            sc.nextLine();

            Merenje m = new Merenje(city, from, to, temperature);
            SLLNode<MapEntry<String, List<Merenje>>> curr = table.search(city);
            if (curr == null){
                List<Merenje> list = new ArrayList<>();
                list.add(m);
                table.insert(city, list);
            }
            else{
                List<Merenje> prev = curr.element.value;
                prev.add(m);
                table.insert(city, prev);
            }
        }

        String city = sc.nextLine();
        SLLNode<MapEntry<String, List<Merenje>>> curr = table.search(city);
        if (curr == null){
            System.out.println("No merenje found");
        }
        else{
            System.out.println(city + ":");
            List<Merenje> list = curr.element.value;
            list.sort((p1, p2) -> p1.from.compareTo(p2.from));
            for (Merenje m : list){
                System.out.println(m);
            }
        }
    }
}
