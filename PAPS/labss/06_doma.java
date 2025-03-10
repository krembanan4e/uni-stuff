// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:
 
// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани
import java.util.Scanner;
 
// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи
 
class Person {
    // поставете ги потребните полиња овде
    String ime;
    int vozrast;
 
    // имплементирајте соодветен конструктор
    Person(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }
 
    @Override
    public String toString() {
        // имплементирајте го toString методот според барањето во текстот
        return "<" + ime + ", " + vozrast + ">";
    }
 
    // имплементирајте ги следните два методи за да работи табелата правилно
    @Override
    public boolean equals(Object o) {
        return (this.ime.equals(((Person) o).ime) && (this.vozrast == ((Person) o).vozrast));
    }
 
    @Override
    public int hashCode() {
        return vozrast * (ime.charAt(0));
    }
}
 
class Project {
    int rabotnoVreme;
    int plataPoChas;
 
    Project(int rabotnoVreme, int plataPoChas) {
        this.rabotnoVreme = rabotnoVreme;
        this.plataPoChas = plataPoChas;
    }
 
    public int vkupnaPlata(){
        return rabotnoVreme*plataPoChas;
    }
 
 
    @Override
    public String toString() {
        return "<" + rabotnoVreme + ", " + plataPoChas + ">";
    }
}
 
public class Solution {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        CBHT<Person, Project> table = new CBHT<>(10);
 
        // Прочитајте ги податоците од влезот и пополнете ја табелата
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Person person = new Person(sc.next(), sc.nextInt());
            Project project = new Project(sc.nextInt(), sc.nextInt());
            if (table.search(person) == null){
                table.insert(person, project);
            }
            else{
                SLLNode<MapEntry<Person, Project>> p = table.search(person);
                Project najdobra_ponuda = p.element.value;
                if (project.vkupnaPlata() > najdobra_ponuda.vkupnaPlata()){
                    table.insert(person, project);
                }
            }
        }
 
        // отпечатете ја вашата табела
        System.out.println(table);
    }
}
 
