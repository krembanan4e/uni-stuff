package stack;

/*
Пример 1:
Влез:
7
6 5 8 4 7 10 9
Излез:
2
-------------------
Пример 2:
Влез:
5
1 1 1 1 1
Излез:
0
 */

import java.util.Scanner;

public class KnigaStack_str102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        ArrayStack<Integer> pom =  new ArrayStack<>(100);
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        int denovi = 0;
        while(true){
            int umreni = 0;
            while (!stack.isEmpty()) {
                if (stack.size() >= 2){
                    int pesticidi = stack.pop();

                    if (pesticidi > stack.peek()){
                        //stack.pop();
                        umreni++;
                    }
                    else{ //prv <= vtor
                        pom.push(pesticidi);
                    }
                }
                else{
                    pom.push(stack.pop());
                }
            }

            while (!pom.isEmpty()){
                stack.push(pom.pop());
            }
            if (umreni == 0){
                break;
            }
            else{
                denovi++;
            }
        }

        System.out.println(denovi);

    }
}
