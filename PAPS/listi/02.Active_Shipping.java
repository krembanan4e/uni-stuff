package listi;

/*
Во рамки на една фабрика се користи систем за управување со нарачки.
За секоја нарачка се чува податок за: id на нарачката (int id), продукт (int product), како и приоритет (int priority).
Приоритетот е вредност во ранг [1, 10], каде што приоритет 1 означува највисок приоритет, а продукт е id на соодветниот продукт кој се нарачува.
Во рамки на еден ден до фабриката стигнуваат многу нарачки кои се чуваат во две еднострано поврзани листи.
Во првата листа се чуваат нарачките кои се активни (Active листата), а во втората листа се чуваат нарачките кои се испратени за достава (Shipping листата).
Ваша задача е да испроцесирате две нарачки.
Процесирање на нарачка се прави на следниот начин: се отстранува најприоритетната нарачка од Active листата и се става на крај на Shipping листата.
Внимавајте: Доколку има повеќе нарачки со ист приоритет, се зема последната.

Влез:
Во првиот ред е даден бројот на нарачки од Active листата.
Во вториот ред е даден бројот на нарачки од Shipping листата.
Во секој следен ред се дадени податоци за една нарачка, одделени со празно место, во формат id product priority.
Притоа, прво се дадени нарачките од Active листата, по што следуваат податоците за нарачките од Shipping листата.
Излез:
Во првиот ред id на сите нарачки од Active листата.
Во вториот ред id на сите нарачки од Shipping листата.
Забелешка:
Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Factory.java, со целосно имплементиран input и output.
Потребно е да се менува само во рамки на void orders(SLL<Order> active, SLL<Order> shipping) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на цел јазол.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.
Не смее да менувате во main функцијата!

Input
3
2
550 991 2
116 8695 2
469 608 3
491 355 3
349 8380 7

Result
469
491 349 116 550
 */

import java.util.*;

class Order{
    private int id;
    private int product;
    private int priority;

    public Order(int id, int product, int priority) {
        this.id = id;
        this.product = product;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Listi_ActiveShipping {
    private static void transform(SLL<Order> active, SLL<Order> shipping) {
        for (int i=0; i<2; i++){ //dve naracki
            SLLNode<Order> curr = active.getFirst();
            SLLNode<Order> najprioritetna = active.getFirst();
            while (curr != null){
                if (curr.element.getPriority() <= najprioritetna.element.getPriority()){ //ak imat pojke so ist prioritet zej go posledniot <=
                    najprioritetna = curr;
                }
                curr = curr.succ;
            }

            shipping.insertLast(najprioritetna.element);
            active.delete(najprioritetna);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Order> active = new SLL<>();
        SLL<Order> shipping = new SLL<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int product = sc.nextInt();
            int priority = sc.nextInt();
            Order order = new Order(id, product, priority);
            active.insertLast(order);
        }

        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int product = sc.nextInt();
            int priority = sc.nextInt();
            Order order = new Order(id, product, priority);
            shipping.insertLast(order);
        }

        transform(active, shipping);
        System.out.println(active);
        System.out.println(shipping);

    }
}
