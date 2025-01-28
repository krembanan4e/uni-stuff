package stack;

/*
H H O H H O H H O H H H H H O H O H O O H O O H H H

output:
8
H
O
 */

import java.util.Scanner;

public class KnigaStack_str96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<Character> stack_H = new ArrayStack<>(100);
        ArrayStack<Character> stack_O = new ArrayStack<>(100);

        String str = sc.nextLine();
        char []niza = str.toCharArray();
        for (int i = 0; i < niza.length; i++) {
            if (niza[i] == 'H') {
                stack_H.push(niza[i]);
            }
            else if (niza[i] == 'O') {
                stack_O.push(niza[i]);
            }
        }

        int counter = 0;
        while (!stack_H.isEmpty() && !stack_O.isEmpty()) {
            if (stack_H.size() >= 2) {
                counter++;
                stack_H.pop();
                stack_H.pop();
                stack_O.pop();
            }
            else {
                break;
            }
        }

        System.out.println(counter);
        while(!stack_H.isEmpty()){
            System.out.println(stack_H.pop());
        }
        while (!stack_O.isEmpty()){
            System.out.println(stack_O.pop());
        }
    }
}
