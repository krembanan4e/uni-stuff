package listi;

import java.util.Scanner;

public class CoursesListi9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int M = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(list);

        DLLNode<Integer> curr = list.getFirst();
        DLLNode<Integer> tmp = null;

        for (int i=0; i<n; i++){
            if (curr.element == M){
                tmp = curr;
                break;
            }
            curr = curr.succ;
        }

        if (tmp == null){
            System.out.println("Elementot ne postoi vo listata");
            System.out.println(list);
            return;
        }

        curr = tmp;
        boolean flag = false; //dali prefrli od drugata strana

        for (int i=0; i<k; i++){
            curr = curr.pred;
            if (curr == null){
                curr = list.getLast();
                flag = true;
            }
        }

        if (flag){ //ako prefrli od drugata strana
            list.insertAfter(tmp.element, curr);
        }
        else { //ako ne prefrli
            list.insertBefore(tmp.element, curr);
        }
        list.delete(tmp);

        System.out.println(list);
    }
}
