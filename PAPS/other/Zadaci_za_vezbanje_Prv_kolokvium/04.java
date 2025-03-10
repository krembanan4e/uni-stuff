/*
Да се напише алгоритам кој ќе пресметува (евалуира) математички израз составен од броеви и операциите за собирање (+) и множење (*). 
Забелешка: Операцијата множење има предност пред операцијата собирање. 

For example:

Input	Result
2+2*2*2*2*2*2+2*2
---------------------
70

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka

        Stack<Integer> stack = new Stack<>();
        Character znak = '+';
        Integer result = 0;
        String broj = new String("");

        for (int i = 0; i < expression.length(); i++){
            if (Character.isDigit(expression.charAt(i))){
                broj = broj + expression.charAt(i);
            }
            if (!Character.isDigit(expression.charAt(i)) || i == expression.length()-1){
                stack.push(Integer.parseInt(broj));
                //System.out.println(broj);
                broj = new String("");

                if (expression.charAt(i) == '*'){
                    if(znak == '+'){
                        znak = '*';
                    }
                    else {
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        //System.out.println(result);
                    }
                }
                else if (expression.charAt(i) == '+'){
                    if(znak == '*'){
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        //System.out.println(result);
                        znak = '+';
                    }
                }
            }
        }


        int final_result = 0;

        if (znak == '*'){
            //System.out.println(stack.peek());
            //stack.pop();
            //System.out.println(stack.peek());
            //result += stack.pop() * stack.pop();
            final_result += stack.pop() * stack.pop();
            //System.out.println(result);
        }


        while(!stack.isEmpty()){
            //result = result + stack.pop();
            //System.out.println(stack.peek());
            final_result += stack.pop();
        }

        return final_result;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}
