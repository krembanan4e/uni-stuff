package hesh;
import java.util.*;
//strana 240 vo knigata

/*
Пример:
Влез:
4
stop
tsop
ooos
toos
tosp

Излез:
2
 */

public class Permutacii {
    public static String sortWord(String word){
        char []letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Integer> table = new CBHT<>(2*n-1); //key e zborot (sortiran), value e brojac

        for (int i=0; i<n; i++){
            String word = sc.nextLine();
            String sortedWord = sortWord(word);

            SLLNode<MapEntry<String, Integer>> curr = table.search(sortedWord);
            if (curr == null){
                table.insert(sortedWord, 1);
            }
            else {
                int prev_counter = curr.element.value;
                table.insert(sortedWord, prev_counter+1);
            }
        }
        
        String word = sc.nextLine();
        String sortedWord = sortWord(word);
        SLLNode<MapEntry<String, Integer>> curr = table.search(sortedWord);
        if (curr != null){
            System.out.println(curr.element.value);
        }
    }
}
