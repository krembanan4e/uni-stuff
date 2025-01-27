package listi;
/*
10
1 2 3 4 5 6 7 8 9 10
1 5
6 10

output:
6<->7<->8<->9<->10<->1<->2<->3<->4<->5

samo za ovaj output rabotit trb da se doprajt
 */

import java.util.Scanner;

public class KnigaListi_str70_71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int i1 = sc.nextInt(); //prv interval od i1 do i2
        int i2 = sc.nextInt();
        int i3 = sc.nextInt(); //vtor interval od i3 do i4
        int i4 = sc.nextInt();

        DLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            if (curr.element == i3){
                break;
            }
            curr = curr.succ;
        }

        DLL<Integer> result = new DLL<>();
        while (curr.element != i4) {
            result.insertLast(curr.element);
            curr = curr.succ;
        }
        result.insertLast(i4);

        curr = list.getFirst();
        while (curr != null) {
            if (curr.element == i1){
                break;
            }
            curr = curr.succ;
        }

        while (curr.element != i2) {
            result.insertLast(curr.element);
            curr = curr.succ;
        }
        result.insertLast(i2);

        System.out.println(result);
    }
}
