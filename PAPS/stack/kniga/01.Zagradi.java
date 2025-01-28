package stack;

/*
Влез: s x (s- a) x (s- b) x (s- c)
Излез: s x (s- a) x (s- b) x (s- c) ima korektni zagradi.
 */

import java.util.Scanner;

public class KnigaStack_str83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<Character> stack = new ArrayStack<>(100);
        String izraz = sc.nextLine();
        for (int i = 0; i < izraz.length(); i++) {
            char c = izraz.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if (c == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            if (c == ']'){
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            if (c == '}'){
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }

        if (stack.isEmpty()){
            System.out.println(izraz + " ima korektni zagradi.");
        }
        else{
            System.out.println(izraz + " nema korektni zagradi!");
        }
    }
}
