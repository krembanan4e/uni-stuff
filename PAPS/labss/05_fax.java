/*
Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови книги. Дадена книга може да припаѓа на една од трите категории: Наука, научна фантастика, историја.
Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа ПАРАЛЕЛНО, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот 
редослед: ДВА студента што бараат книга од тип НАУКА, ЕДЕН срудент што бара книга од тип НАУЧНА ФАНТАСТИКА, ДВА студента што бараат книга од тип ИСТОРИЈА.
Доколку студент чека ред за книги од различпен тип, тој чека првин во редицата за книга од тип НАУКА, потоа во редицата за книга од тип НАУЧНА ФАНТАСТИКА, и на крај
во редицата за книга од тип ИСТОРИЈА (во зависност ако ги бара овие книги за позајмување)

Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотека да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студентот,
а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука,Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да ја позајми книгата 
од тој тип, а 0 значи дека нема да позајми книга од тој тип.

Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но нема за цел да позајми книга од тип Историја.

Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.
*/

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}


class Student {
    public String ime;
    public int br_nauka;
    public int br_scifi;
    public int br_istorija;

    public Student(String ime, int br_nauka, int br_scifi, int br_istorija) {
        this.ime = ime;
        this.br_nauka = br_nauka;
        this.br_scifi = br_scifi;
        this.br_istorija = br_istorija;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayQueue<Student> nauka_queue = new ArrayQueue<>(n);
        ArrayQueue<Student> scifi_queue = new ArrayQueue<>(n);
        ArrayQueue<Student> istorija_queue = new ArrayQueue<>(n);

        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            int nauka = sc.nextInt();
            int scifi = sc.nextInt();
            int istorija = sc.nextInt();
            sc.nextLine();

            Student s = new Student(ime, nauka, scifi, istorija);

            if (s.br_nauka == 1){
                nauka_queue.enqueue(s);
            }
            else if (s.br_scifi == 1){
                scifi_queue.enqueue(s);
            }
            else if (s.br_istorija == 1){
                istorija_queue.enqueue(s);
            }
        }

        while (!nauka_queue.isEmpty() || !scifi_queue.isEmpty() || !istorija_queue.isEmpty()) {
            if (!nauka_queue.isEmpty()){
                for (int i = 0; i < 2 && !nauka_queue.isEmpty(); i++){
                    Student s = nauka_queue.dequeue();
                    if (s.br_scifi == 1){
                        scifi_queue.enqueue(s);
                    }
                    else if (s.br_istorija == 1){
                        istorija_queue.enqueue(s);
                    }
                    else{
                        System.out.println(s.ime);
                    }
                }
            }
            if (!scifi_queue.isEmpty()){
                for (int i = 0; i < 1 && !scifi_queue.isEmpty(); i++){
                    Student s = scifi_queue.dequeue();
                    if (s.br_istorija == 1){
                        istorija_queue.enqueue(s);
                    }
                    else{
                        System.out.println(s.ime);
                    }
                }
            }
            if (!istorija_queue.isEmpty()){
                for (int i = 0; i < 2 && !istorija_queue.isEmpty(); i++){
                    Student s = istorija_queue.dequeue();
                    System.out.println(s.ime);
                }
            }
        }
    }
}
