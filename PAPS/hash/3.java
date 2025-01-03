/*
На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
Ime Prezime budzhet ip_adresa vreme grad cena
Пример
Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.

Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.

Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:

Од сите N лица на влез, кои купуваат билет за до истиот град
колку од нив се вклучиле подоцна од 11:59; и
од овие, кој од нив се вклучил најрано? 
(погледнете го тест примерот!)

(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)

Ова ќе треба да го направите за сите M редови за тестирање!

Препорака, користете OBHT и/или CBHT.
*/

// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:
// The following classes are already imported, copying classes here is not allowed, use them directly as when they are available in other local files:

// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани
// CBHT, OBHT, MapEntry, SLLNode are already imported

import java.util.*;
class Person implements Comparable<Person> {
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public Person(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public int compareTo(Person o) {
        if (this.time.compareTo(o.time) < 0){
            return 1;
        }
        else if (this.time.compareTo(o.time) > 0){
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " with salary "+ budget +" from address "+ ipAddress +" who logged in at " + time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> table1 = new CBHT<>(2*n-1); //key e gradot, value e brojac
        CBHT<String, Person> table2 = new CBHT<>(2*n-1); //key e gradot, value e coekot

        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAddress = parts[3];
            String time = parts[4];
            String city = parts[5];
            int price = Integer.parseInt(parts[6]);

            SLLNode<MapEntry<String, Integer>> curr = table1.search(city);

            String []t = time.split(":");
            int hours = Integer.parseInt(t[0]);

            if (hours >= 12){
                if (curr == null){
                    table1.insert(city, 1);
                }
                else{
                    int prev_counter = curr.element.value;
                    table1.insert(city, prev_counter + 1);
                }
            }

            Person p = new Person(name, surname, budget, ipAddress, time, city, price);
            SLLNode<MapEntry<String,Person>> curr2 = table2.search(city);

            if (hours >= 12){
                if (curr2 == null){
                    table2.insert(city, p);
                }
                else{
                    Person prev_person = curr2.element.value;
                    if (prev_person.compareTo(p) == 1){
                        table2.insert(city, prev_person); //staj go stariot
                    }
                    else{
                        table2.insert(city, p); //staj go noviot
                    }
                }
            }

        }

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[5];

            SLLNode<MapEntry<String, Integer>> curr = table1.search(city);
            System.out.println("City: "+city+" has the following number of customers:");
            System.out.println(curr.element.value);

            SLLNode<MapEntry<String, Person>> curr2 = table2.search(city);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(curr2.element.value.toString() + "\n");
        }
    }
}
