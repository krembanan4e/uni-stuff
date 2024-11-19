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
--------
200


1
10 60
-------
60
*/

import java.util.*;

class Task implements Comparable<Task>{
    int hours;
    int earnings;

    Task(int hours, int earnings){
        this.hours = hours;
        this.earnings = earnings;
    }

    @Override
    public int compareTo(Task t) {
        if (this.earnings/this.hours < t.earnings/t.hours){ //in descending order
            return 1;
        }
        else if (this.earnings/this.hours > t.earnings/t.hours){
            return -1;
        }
        else {
            return 0;
        }
    }

    public String toString(){
        return hours + " " + earnings;
    }
}

public class Main{
    public static int max_earnings(Task []tasks, int n){
        int H = 40; //total hours
        int max_earnings = 0;
        for (int i = 0; i < n; i++){
            if (tasks[i].hours < H){
                max_earnings += tasks[i].earnings;
                H -= tasks[i].hours;
            }
            else if (tasks[i].hours > H){
                max_earnings += (tasks[i].earnings / tasks[i].hours) * H;
                H -= tasks[i].hours;
            }
            if (H <= 0){
                break;
            }
        }

        return max_earnings;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Task[] tasks = new Task[n];

        for(int i = 0; i < n; i++){
            int hours = sc.nextInt();
            int earnings = sc.nextInt();
            tasks[i] = new Task(hours, earnings);
        }

        Arrays.sort(tasks);
        //System.out.println(Arrays.toString(tasks));
        System.out.println(max_earnings(tasks, n));
    }
}
