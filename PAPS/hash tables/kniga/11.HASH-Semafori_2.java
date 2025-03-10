package hash;

//strana 224 vo knigata

/*
Input:
5
SK1234AA Anita Angelovska
OH1212BE Aleksandar Antov
ST0989OO Ognen Spirovski
ST0000AB Sara Spasovska
SK8888KD Dino Ackov
50
SK8888KD 48 14:00:00 ST0000AB 55 12:00:02 ST0989OO 60 08:10:00 SK1234AA 65 20:00:10 OH1212BE 50 22:00:21

Output:
Ognen Spirovski
Sara Spasovska
Anita Angelovska
*/

import java.util.*;

class Person{
    String reg;
    String name;
    String speed;
    String time;

    public Person(String reg, String name) {
        this.reg = reg;
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

public class KnigaHash_str234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Person> table = new CBHT<>(2*n-1);

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            String reg = parts[0];
            String name = parts[1] + " " + parts[2];
            table.insert(reg, new Person(reg, name));
        }

        int maxSpeed = sc.nextInt();
        sc.nextLine();
        String []line = sc.nextLine().split(" ");

        List<Person> list = new ArrayList<>();

        for (int i=0; i<line.length; i+=3){
            String reg = line[i];
            int speed = Integer.parseInt(line[i+1]);
            String time = line[i+2];

            SLLNode<MapEntry<String, Person>> curr = table.search(reg);
            if (curr != null && speed > maxSpeed){
                curr.element.value.setTime(time);
                list.add(curr.element.value);
            }
        }

        list.sort((p1,p2) -> p1.time.compareTo(p2.time));
        for (Person p : list){
            System.out.println(p.name);
        }
    }
}
