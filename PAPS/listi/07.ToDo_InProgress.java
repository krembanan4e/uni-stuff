package listi;

/*
Во рамки на една компанија се користи систем за управување со таскови за вработените.
За секој таск се чува податок за: id на таскот (int id), времетраење - број на работни часови (int hours), како и приоритет (int priority).
Приоритетот е вредност во ранг [1, 10], каде што приоритет 10 означува највисок приоритет.
Еден вработен има повеќе доделени таскови кои се чуваат во две еднострано поврзани листи.
Во првата листа се чуваат тасковите кои се незавршени (То Dо листа), а во втората листа се чуваат тасковите кои ги работи во моментов (In Progress листа).
За секој од тасковите може да се пресмета неговата важност, како двоен производ на бројот на работни часови и приоритетот на таскот. importance = 2* hours * priority
Ваша задача е да се отстрани најважниот таск од То Dо листата и истиот да се стави на почеток на In Progress листата.
Потоа, треба да се отстрани таскот со најмала важност од In Progress листата и истиот да се стави на крај на To Do листата.
Влез:
Во првиот ред е даден бројот на таскови од То Dо листата.
Во вториот ред е даден бројот на таскови од In Progress листата.
Во секој следен ред се дадени податоци за еден таск, одделени со празно место, во формат id hours priority.
Притоа, прво се дадени тасковите од То Dо листата, по што следуваат податоците за тасковите од In Progress листата.
Излез:
Во првиот ред id на сите таскови од To Do листата.
Во вториот ред id на сите таскови од In Progress листата.

Забелешка:
Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Tasks.java, со целосно имплементиран input и output.
Потребно е да се менува само во рамки на void work(SLL <Task> to_Do, SLL<Task> inProgress) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.
Не смее да менувате во main функцијата !

For example:
Input
3
3
111 1 1
222 2 4
333 1 1
444 2 7
555 4 6
666 2 9

Result
111 333 222
444 555 666
 */

import java.util.*;

class Task{
    int id;
    int hours;
    int priority;

    public Task(int id, int hours, int priority) {
        this.id = id;
        this.hours = hours;
        this.priority = priority;
    }

    public int vazhnost(){
        return 2 * hours * priority;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class ListiToDoInProgress {
    private static void work(SLL<Task> toDo, SLL<Task> inProgress) {
        SLLNode<Task> najvazhen = toDo.getFirst();
        SLLNode<Task> curr = toDo.getFirst();
        while (curr != null){
            if (curr.element.vazhnost() >= najvazhen.element.vazhnost()){
                najvazhen = curr;
            }
            curr = curr.succ;
        }

        inProgress.insertFirst(najvazhen.element);
        toDo.delete(najvazhen);

        SLLNode<Task> najNevazhen = inProgress.getFirst();
        curr = inProgress.getFirst();
        while (curr != null){
            if (curr.element.vazhnost() <= najNevazhen.element.vazhnost()){
                najNevazhen = curr;
            }
            curr = curr.succ;
        }

        toDo.insertLast(najNevazhen.element);
        inProgress.delete(najNevazhen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Task> toDo = new SLL<>();
        SLL<Task> inProgress = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int hours = sc.nextInt();
            int priority = sc.nextInt();
            Task t = new Task(id, hours, priority);
            toDo.insertLast(t);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int hours = sc.nextInt();
            int priority = sc.nextInt();
            Task t = new Task(id, hours, priority);
            inProgress.insertLast(t);
        }

        work(toDo, inProgress);
        System.out.println(toDo);
        System.out.println(inProgress);
    }
}
