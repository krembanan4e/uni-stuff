package listi;

import java.util.Scanner;

public class CoursesListi10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.print(list);

        int M = sc.nextInt();
        int k = sc.nextInt();

        DLLNode<Integer> curr = list.getFirst();
        DLLNode<Integer> tmp = null;
        while (curr != null){
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

        for (int i = 0; i < k; i++) {
            curr = curr.succ;
            if (curr == null){
                curr = list.getFirst();
                flag = true;
            }
        }

        if (flag){ //ako prefrli od drugata strana
            list.insertBefore(tmp.element, curr);
        }
        else{
            list.insertAfter(tmp.element, curr);
        }
        list.delete(tmp);
        System.out.println(list);
    }
}
