package stack;

/*
Влез: 5 9 + 2 * 6 5 * +
Излез: Rezultatot e 58.0
-----------------------------------
Input: 2 3 1 * + 9 -
Output: -4
-----------------------------------
Input: 100 200 + 2 / 5 * 7 +
Output: 757
*/

import java.util.Scanner;

public class KnigaStack_str86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String izraz = sc.nextLine();
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        String []znaci = izraz.split(" ");
        for (int i = 0; i < znaci.length; i++) {
            String c = znaci[i];
            if (stack.size() >= 2){
                if (c.equals("+")){
                    int rez = stack.pop() + stack.pop();
                    stack.push(rez);
                }
                else if (c.equals("*")){
                    int rez = stack.pop() * stack.pop();
                    stack.push(rez);
                }
                else if (c.equals("-")){
                    int prv = stack.pop();
                    int vtor = stack.pop();
                    int rez = vtor - prv;
                    stack.push(rez);
                }
                else if (c.equals("/")){
                    int prv = stack.pop();
                    int vtor = stack.pop();
                    int rez = vtor / prv;
                    stack.push(rez);
                }
                else {
                    stack.push(Integer.parseInt(c));
                }
            }

            else{
                stack.push(Integer.parseInt(c));
            }
        }

        if (stack.isEmpty()){
            System.out.println("Greshka");
        }
        else {
            System.out.println("Rezultatot e " + stack.pop().floatValue());
        }

    }
}
