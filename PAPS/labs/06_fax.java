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
        List<Person> list = new ArrayList<>();
        CBHT<String, List<Person>> table = new CBHT<>(2*n);

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

            if (budget > price){ //togas dodaj go coekot
                SLLNode<MapEntry<String, List<Person>>> curr = table.search(city);
                if (curr != null){
                    list.add(p);
                    table.insert(city, list);
                }
                else{
                    List list1 = new ArrayList();
                    list1.add(p);
                    table.insert(city, list1);
                }
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
            int counter = 0;
            int min = Integer.MAX_VALUE;
            Person user = null; //coekot sho imat najmnogu potroseno

            SLLNode<MapEntry<String, List<Person>>> curr = table.search(city);
            if (curr != null){
                Person p = curr.element.value.getFirst();
                while (curr != null){
                    counter ++;
                    if (p.budget-p.price < min){
                        min = p.budget-p.price;
                        user = p;
                    }
                    curr = curr.succ;
                }
            }
            else{
                System.out.println("Nema zapis za toj grad!");
            }

            System.out.println("City: " + city + " has the following number of customers:\n" + counter);
            System.out.println("The user who spent the most purchasing for that city is: \n" + user.toString());
        }
    }
}
