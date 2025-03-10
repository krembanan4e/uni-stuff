package listi;
import java.util.Scanner;

public class CoursesListi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        SLL<String> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextLine());
        }
        System.out.print(list);

        int L = sc.nextInt();
        SLLNode<String> curr = list.getFirst();
        while (curr != null){
            if (curr.element.length() < L){
                list.delete(curr);
            }
            curr = curr.succ;
        }
        System.out.println(list);
    }
}
