package queue;

import java.util.*;

class Person{
    String name;
    int priority;

    public Person(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public static Comparator<Person> comparator = Comparator.comparing(c -> c.priority);
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int priority = sc.nextInt();
            Person p = new Person(name, priority);
            list.add(p);
        }

        list.sort(Person.comparator);
        for (Person p : list) {
            System.out.println(p.name);
        }
    }
}
