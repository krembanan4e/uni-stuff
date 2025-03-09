package tehnikiNaKreiranjeAlgoritmi;

/*
Дадени се N задачи кои треба да се изработат. За секоја од задачите го знаеме времето за изработка (во часови) и заработката која ја носи.
Да се најде максималната заработка во рок од една 40 часовна работна недела.
Напомена дека и делумно сработени задачи носат делумна заработка, во зависност од процентот на завршеност.
Влез: Првиот број од влезот е бројот на задачи N, а потоа во следниот ред времетраењето на задачата во часови и заработката која ја носи.
Излез: Максимална заработка која можеме да ја направиме за 40 часа.

3
10 60
20 100
30 120
-----------
200


1
10 60
-----------
60
 */

import java.util.*;

class Task {
    int hours;
    int earnings;
    int earningsPerHour;

    public Task(int hours, int earnings) {
        this.hours = hours;
        this.earnings = earnings;
        this.earningsPerHour = earnings / hours;
    }

    public static Comparator<Task> comparator = Comparator.comparing(c -> c.earningsPerHour);
}

public class Courses03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Task> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Task t = new Task(sc.nextInt(), sc.nextInt());
            tasks.add(t);
        }

        tasks.sort(Task.comparator.reversed());

        int maxEarnings = 0;
        int hours = 40;
        for (int i=0; i<tasks.size(); i++){
            if (tasks.get(i).hours <= hours){
                maxEarnings += tasks.get(i).earnings;
                hours -= tasks.get(i).hours;
            }
            else{
                maxEarnings += hours * tasks.get(i).earningsPerHour;
                break;
            }
        }

        System.out.println(maxEarnings);
    }
}
