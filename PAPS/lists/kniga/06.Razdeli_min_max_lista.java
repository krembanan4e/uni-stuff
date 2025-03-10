package listi;

/*
9
1 5 7 3 2 9 4 8 6

output:
1->5->3->2->4
7->9->8->6
 */

import java.util.Scanner;

public class KnigaListi_str49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> min = list.getFirst();
        SLLNode<Integer> max = list.getFirst();

        while(curr != null){
            if (curr.element < min.element){
                min = curr;
            }
            else if (curr.element > max.element){
                max = curr;
            }
            curr = curr.succ;
        }

        //System.out.println(min.element);
        //System.out.println(max.element);

        SLL<Integer> pobliskiDoNajmaliot = new SLL<>();
        SLL<Integer> pobliskiDoNajgolemiot = new SLL<>();

        curr = list.getFirst();

        while (curr != null){
            if ((curr.element - min.element) < (max.element - curr.element)){
                pobliskiDoNajmaliot.insertLast(curr.element);
            }
            else if ((max.element - curr.element) < (curr.element - min.element)){
                pobliskiDoNajgolemiot.insertLast(curr.element);
            }
            else{ //ako se isti
                pobliskiDoNajmaliot.insertLast(curr.element);
            }
            curr = curr.succ;
        }

        System.out.println(pobliskiDoNajmaliot);
        System.out.println(pobliskiDoNajgolemiot);
    }
}
