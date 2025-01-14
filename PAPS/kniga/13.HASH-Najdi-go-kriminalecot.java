package hesh;
import java.util.*;

//strana 239 vo knigata

/*

Пример 1:
Влез:
3
IvanIvanovski
ACGTGTACCATGATAG
GGTACGATCCT
ElenaPetrevska
GTACCGATGCTAGGATC
ACGTAGCTCCGGATCG
KostaKostovski
CGCTAATTTAAAGC
TAGACTCGATCGCT
ACGTGTACCATGATAG
GGTACGATCCT

Излез: IvanIvanovski
--------------------------
Пример 2:
Влез:
3
IvanIvanovski
ACGTGTACCATGATAG
GGTACGATCCT
ElenaPetrevska
GTACCGATGCTAGGATC
ACGTAGCTCCGGATCG
KostaKostovski
CGCTAATTTAAAGC
TAGACTCGATCGCT
ACGTACCATGATAG
A

Излез: Unknown
*/

public class NajdiGoKriminalecot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, String> table1 = new CBHT<>(2*n-1); //key e kod1, value e imeto
        CBHT<String, String> table2 = new CBHT<>(2*n-1); //key e kod2, value e imeto

        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            String kod1 = sc.nextLine();
            String kod2 = sc.nextLine();

            table1.insert(kod1, ime);
            table2.insert(kod2, ime);
        }

        String kod1 = sc.nextLine();
        String kod2 = sc.nextLine();

        SLLNode<MapEntry<String , String>> curr1 = table1.search(kod1); //baraj vo prvata
        SLLNode<MapEntry<String , String>> curr2 = table1.search(kod1); //baraj vo vtorata

        if (curr1 != null){ //go imat vo prvata
            if (curr2 != null){ //go imat vo vtorata
                if (curr1.element.value.equals(curr2.element.value)){
                    System.out.println(curr1.element.value);
                }
                else{
                    System.out.println("Unknown");
                }
            }
        }
        else{
            System.out.println("Unknown");
        }
    }
}
