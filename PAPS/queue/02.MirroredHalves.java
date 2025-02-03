package stack;

/*
ispecati go queue do pola pa prevrteno, pa drugata pola i prevrteno

6
10 20 30 40 50 60

output:
10 20 30 30 20 10 40 50 60 60 50 40
 */

import java.util.*;

public class QueueStack_MirroredHalves {
    private static ArrayList<Integer> mirroredHalves(ArrayList<Integer> queue) {
        if (queue.isEmpty() || queue.size() % 2 != 0){
            System.out.println("Error");
            return null;
        }

        int half = queue.size() / 2;
        ArrayStack<Integer> stack = new ArrayStack<>(half);

        for (int i = 0; i < half; i++){
            int element = queue.getFirst();
            stack.push(element);
            queue.add(element);
            queue.removeFirst();
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

        for (int i = 0; i < half; i++){
            int element = queue.getFirst();
            stack.push(element);
            queue.add(element);
            queue.removeFirst();
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> queue = new ArrayList<>(n*2);
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        queue = mirroredHalves(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.removeFirst() + " ");
        }
    }
}
