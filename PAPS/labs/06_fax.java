//import CBHT, MapEntry, SLLNode

class Person{
    String name;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public Person(String name, int budget, String ipAddress, String time, String city, int price) {
        this.name = name;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " with salary " + budget + " from address " + ipAddress + " who spent " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return budget == person.budget && price == person.price && Objects.equals(name, person.name) && Objects.equals(ipAddress, person.ipAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, budget, ipAddress, time, city, price);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Person> table = new CBHT<>(2*n);
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String []str = s.split(" ");
            String name = str[0] + " " + str[1];
            int budget = Integer.parseInt(str[2]);
            String ipAddress = str[3];
            String time = str[4];
            String city = str[5];
            int price = Integer.parseInt(str[6]);
            Person p = new Person(name, budget, ipAddress, time, city, price);

            if (budget > price){
                table.insert(city, new Person(name, budget, ipAddress, time, city, price));
            }
        }
        System.out.println(table);
        System.out.println("Searching...");

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String []str = s.split(" ");
            String city = str[5];
            int min = Integer.MAX_VALUE;
            int counter = 0;
            SLLNode<MapEntry<String, Person>> user = null; //toj sho imat najmnogu potroseno


            SLLNode<MapEntry<String, Person>> curr = table.search(city);
            if (curr != null){ //aku imat takov zapis vo tabelata
                while(curr != null){ //shetaj niz zapisite vo ta kofichka
                    counter++;
                    if (curr.element.value.budget-curr.element.value.price < min){
                        min = curr.element.value.budget-curr.element.value.price;
                        user = curr;
                    }
                    curr = curr.succ;
                }
            }
            else{
                System.out.println("Nema zapis za toj grad");
            }

            System.out.println("City: " + city + " has the following number of customers:\n" + counter);
            if (user != null) {
                System.out.println("The user who spent the most purchasing for that city is: \n" + user.element.value);
            }
        }
    }
}

