package stack;

/*
LM OZ OM OM LM SZ SM LZ OM LZ SZ SM SM LM

output:
4
LZ SZ OZ OZ
 */

import java.util.Scanner;

public class KnigaStack_str104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<String> osnovni = new ArrayStack<>(100);
        ArrayStack<String> standardni = new ArrayStack<>(100);
        ArrayStack<String> latino = new ArrayStack<>(100);

        String str = sc.nextLine();
        String []tanci = str.split(" ");
        for (int i = 0; i < tanci.length; i++) {
            if (tanci[i].charAt(0) == 'O'){
                if (!osnovni.isEmpty()){
                    if (osnovni.peek().equals("OM") && tanci[i].equals("OZ")){
                        osnovni.pop();
                    }
                    else if (osnovni.peek().equals("OZ") && tanci[i].equals("OM")){
                        osnovni.pop();
                    }
                    else {
                        osnovni.push(tanci[i]);
                    }
                }
                else{
                    osnovni.push(tanci[i]);
                }
            }
            else if (tanci[i].charAt(0) == 'S'){
                if (!standardni.isEmpty()){
                    if (standardni.peek().equals("SM") && tanci[i].equals("SZ")){
                        standardni.pop();
                    }
                    else if (standardni.peek().equals("SZ") && tanci[i].equals("SM")){
                        standardni.pop();
                    }
                    else {
                        standardni.push(tanci[i]);
                    }
                }
                else{
                    standardni.push(tanci[i]);
                }
            }
            else if (tanci[i].charAt(0) == 'L'){
                if (!latino.isEmpty()){
                    if (latino.peek().equals("LM") && tanci[i].equals("LZ")){
                        latino.pop();
                    }
                    else if (latino.peek().equals("LZ") && tanci[i].equals("LM")){
                        latino.pop();
                    }
                    else {
                        latino.push(tanci[i]);
                    }
                }
                else{
                    latino.push(tanci[i]);
                }
            }
        }

        int counter = 0;
        ArrayStack<String> pom = new ArrayStack<>(100);

        while(!osnovni.isEmpty()){
            String tanc = osnovni.pop();
            counter++;
            if (tanc.equals("OM")){
                pom.push("OZ");
            }
            else{
                pom.push("OM");
            }
        }
        while(!standardni.isEmpty()){
            String tanc = standardni.pop();
            counter++;
            if (tanc.equals("SM")){
                pom.push("SZ");
            }
            else{
                pom.push("SM");
            }
        }
        while(!latino.isEmpty()){
            String tanc = latino.pop();
            counter++;
            if (tanc.equals("LM")){
                pom.push("LZ");
            }
            else{
                pom.push("LM");
            }
        }


        System.out.println(counter);
        while(!pom.isEmpty()){
            System.out.print(pom.pop() + " ");
        }

    }
}
