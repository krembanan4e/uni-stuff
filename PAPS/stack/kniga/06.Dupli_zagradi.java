package stack;

/*

Пример 1:
Влез:
(((a+(b)))+(c+d))
Излез:
Najdeni se dupli zagradi
-------------------------------
Пример 2:
Влез:
((a)+(b))
Излез:
/

 */

import java.util.Scanner;

public class KnigaStack_str101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<Character> stack = new ArrayStack<>(100);
        String str = sc.nextLine();
        char []niza = str.toCharArray();
        int counter = 0;
        boolean najde = false;

        for (int i = 0; i < niza.length; i++) {
            if (counter == 3){
                najde = true;
                counter = 0;
            }
            if (niza[i] == '('){
                stack.push(niza[i]);
                counter++;
            }
            else if (niza[i] == ')'){
                counter = 0;
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        if (najde){
            System.out.println("Najdeni se dupli zagradi");
        }
        else {
            System.out.println("/");
        }
    }
}
