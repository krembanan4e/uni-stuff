package stack;

/*
R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+

output:
4
R- G- G- B-   (valda imat greska vo knigata za outputot sho e R- G- G- B+ )????
 */

import java.util.Scanner;

public class KnigaStack_str93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<String> red = new ArrayStack<>(100);
        ArrayStack<String> green = new ArrayStack<>(100);
        ArrayStack<String> blue = new ArrayStack<>(100);
        String str = sc.nextLine();
        String []topcinja = str.split(" ");
        for (int i = 0; i < topcinja.length; i++) {
            String topce = topcinja[i];
            if (topce.charAt(0) == 'R'){
                if (!red.isEmpty() && topce.charAt(1) != red.peek().charAt(1)){
                    red.pop();
                }
                else{
                    red.push(topce);
                }
            }
            else if (topce.charAt(0) == 'G'){
                if (!green.isEmpty() && topce.charAt(1) != green.peek().charAt(1)){
                    green.pop();
                }
                else {
                    green.push(topce);
                }
            }
            else if (topce.charAt(0) == 'B'){
                if (!blue.isEmpty() && topce.charAt(1) != blue.peek().charAt(1)){
                    blue.pop();
                }
                else {
                    blue.push(topce);
                }
            }
        }

        int counter = 0;
        ArrayStack<String> stack = new ArrayStack<>(100);

        while (!blue.isEmpty()){
            counter ++;
            String topce = blue.pop();
            if (topce.equals("B+")){
                stack.push("B-");
            }
            else{
                stack.push("B+");
            }
        }
        while (!green.isEmpty()){
            counter ++;
            String topce = green.pop();
            if (topce.equals("G+")){
                stack.push("G-");
            }
            else{
                stack.push("G+");
            }
        }
        while (!red.isEmpty()){
            counter ++;
            String topce = red.pop();
            if (topce.equals("R+")){
                stack.push("R-");
            }
            else{
                stack.push("R+");
            }
        }

        System.out.println(counter);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
