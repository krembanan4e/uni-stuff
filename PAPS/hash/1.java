/*
Во оваа задача ќе работите со два објекти „Вработени“ и „Проекти“.
Еден вработен е дефиниран со 2 вредности: Име (String), Возраст (цел број).
Еден проект е дефиниран со 2 вредности: Работно Време (цел број), Плата по час (цел број).
За даден проект вкупната плата се пресметува како производ на работното време и платата по час.
Вработените ќе добиваат понудени проекти, и треба да го изберат проектот од кој ќе добијат најголема плата (доколку имаат избор од повеќе проекти со иста најголема плата, тогаш првиот таков).
Ваша задача ќе биде да им помогнете на вработените со тоа што ќе искористите CBHT со 10 кофички каде што за секој вработен ќе ја чувате неговата најдобра понуда.
За хеш функција користете производ од возраста на вработениот и ASCII вредноста на првата буква од името на вработениот.

Влез:
Во првиот ред е даден еден цел број N кој го означува бројот на понуди. Потоа во следните N редови се дадени по 4 вредности, 
информациите за понудите, името и возраста на вработениот и работното време и платата од час на проектот соодветно:

N
name_1 age_1 time_1 rate_1
name_2 age_2 time_2 rate_2
...
name_N age_N time_N rate_N

Излез:
Отпечатете ја целата табела (со готовиот toString метод).

Секој вработен да се печати во формат "<name, age>" каде на местото на name и age треба да стои името и возраста на вработениот соодветно (имплементирајте го ова во toString метод)
Секој проект да се печати во формат "<time, rate>" каде на местото на time и rate треба да стои работното време и платата по час на проектот соодветно (имплементирајте го ова во toString метод)
*/

// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:
// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани


// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи
import java.util.*;
class Person {
    // поставете ги потребните полиња овде
    String ime;
    int vozrast;

    // имплементирајте соодветен конструктор
    public Person(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    @Override
   public String toString() {
        return "<" + ime + ", " + vozrast + ">";
    }


    // имплементирајте ги следните два методи за да работи табелата правилно
    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person vraboten = (Person) o;
        return vozrast == vraboten.vozrast && Objects.equals(ime, vraboten.ime);
    }
    
    @Override
    public int hashCode() {
        return ime.charAt(0) * vozrast;
    }
}

class Project {
    int rabotno_vreme;
    int plata_po_chas;

    public Project(int rabotno_vreme, int plata_po_chas) {
        this.rabotno_vreme = rabotno_vreme;
        this.plata_po_chas = plata_po_chas;
    }


    int vkupnaPlata(){
        return rabotno_vreme * plata_po_chas;
    }

    @Override
    public String toString() {
        return "<" + rabotno_vreme + ", " + plata_po_chas + ">";
    }
}

public class Solution {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        CBHT<Person, Project> table = new CBHT<Person, Project>(10);
        
        // Прочитајте ги податоците од влезот и пополнете ја табелата
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String ime = sc.next();
            int vozrast = sc.nextInt();
            int rabotno_vreme = sc.nextInt();
            int plata_po_chas = sc.nextInt();

            Person person = new Person(ime, vozrast);
            Project project = new Project(rabotno_vreme, plata_po_chas);

            SLLNode<MapEntry<Person, Project>> curr = table.search(person);
            if (curr == null){
                table.insert(person, project);
            }
            else {
                Project prev_proekt = curr.element.value;
                if (prev_proekt.vkupnaPlata() >= project.vkupnaPlata()){
                    table.insert(person, prev_proekt); 
                }
                else{
                    table.insert(person, project);
                }
            }
        }
        
        // отпечатете ја вашата табела
        System.out.println(table);
    }
}

