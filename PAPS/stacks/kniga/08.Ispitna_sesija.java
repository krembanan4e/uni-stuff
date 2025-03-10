package stack;

/*
7 3
APS OS Мrezhi AOK Objektno Strukturno Kalkulus
APS Objektno Мrezhi

output:
APS 3
OS 1
Мrezhi 2
AOK 2
Objektno 3
Strukturno 3
Kalkulus 3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KnigaStack_str103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayStack<String> stack = new ArrayStack<>(100);

        String str = sc.nextLine();
        String []knigi = str.split(" "); //site predmeti

        Map<String, Integer> brojaci = new HashMap<>(); //za kolku pati e sekoja kniga istaena
        for (int i = 0; i < n; i++) {
            brojaci.put(knigi[i], 0);
        }

        String str2 = sc.nextLine();
        String []ispiti = str2.split(" ");

        for (int i=0; i<knigi.length; i++){
            stack.push(knigi[i]);
        }

        ArrayStack<String> pom = new ArrayStack<>(100);
      
        for (int i=0; i<ispiti.length; i++){
            String ispit = ispiti[i];
            for (int j=0; j<knigi.length; j++){
                if (!stack.isEmpty()){
                    if (ispit.equals(stack.peek())){ //knigata sho se barat ko ke se istajt i se brojt ednas
                        //brojaci[j] ++;
                        brojaci.put(stack.peek(), brojaci.get(stack.peek())+1);
                        stack.pop();
                        while(!stack.isEmpty()){
                            pom.push(stack.pop()); //ovie se pod taja sho se barat zato samo se prefrlet vo pom
                        }
                    }
                    else { //ovie se nad knigata sho se barat zato se vagjet i se brojat po ednas
                       //brojaci[j] ++;
                        brojaci.put(stack.peek(), brojaci.get(stack.peek())+1);
                        pom.push(stack.pop());
                    }
                }
            }
            while(!pom.isEmpty()){
                stack.push(pom.pop());
            }
            stack.push(ispit);
        }

        for (int i=0; i<n; i++){
            System.out.println(knigi[i] + " " + brojaci.get(knigi[i]));
        }
    }
}
