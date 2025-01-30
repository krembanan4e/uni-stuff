package tehnikiNaKreiranjeAlgoritmi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Courses01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i));
        }
    }
}
