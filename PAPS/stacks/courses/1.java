package stack;

/*
func1
func2
endfunc2
func3
endfunc3
endfunc1
x

output:
Valid
--------------------------
func1
func2
endfunc2
func3
endfunc1
x

output:
Invalid
 */

import java.util.Scanner;

public class CoursesStack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<String> stack = new ArrayStack<>(100);

        while (true){
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("x")){
                break;
            }

            if (str.startsWith("func")){
                stack.push(str);
            }
            else if (str.startsWith("end")){
                if (!stack.isEmpty()){
                    if (str.charAt(str.length()-1) == stack.peek().charAt(stack.peek().length()-1)){
                        stack.pop();
                    }
                    else {
                        stack.push(str);
                    }
                }
                else {
                    stack.push(str);
                }
            }
        }

        if (!stack.isEmpty()){
            System.out.println("Invalid");
        }
        else {
            System.out.println("Valid");
        }
    }
}
