package listi;

/*
Разиграна листа
Дадена е двострано поврзана листа чии што јазли содржат по една буква (знак). Сé додека не остане само еден јазол во листата треба да с прави следното:
Прво почнувајќи од почетокот на листата се брише секој втор јазол (т.е. 2-от, па 4-от, па 6-от итн...),
потоа почнувајќи од крајот на листата повторно се брише секој втор јазол (т.е. претпоследниот, па 2 пред него итн..).
Постапката се повторува (се брише секој втор јазел од почетокот до крајот, па од крајот до почетокот на листата) сé додека не остане точно еден јазол во листата.
Влез: Во еден ред се дадени буквите од кои се составени јазлите по редослед разделени со празно место.
Излез: Се печати вредноста на јазолот кој останал во листата.
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл.
На располагање од структурите има само ЕДНА двојно поврзана листа.
Име на класа (Јава): RazigranaLista
                                
Пример: Нека е дадена листата a b c d e f g h i j
Листа после прво бришење (од почеток): a c e g i
Листа после второ бришење (од крај): а е і
Листа после трето бришење (од почеток): а і
Листа после четврто бришење (од крај): i - Тука е крајот, остана само еден јазол
 */

import java.util.*;

public class Listi_RazigranaLista {
    private static void transformiraj(DLL<Character> list) {
        while (list.getSize() > 1){
            DLLNode<Character> curr = list.getFirst().succ; //staj go na vtoriot od pocetok
            while (curr != null){
                if (curr.succ != null){ //aku imat ush eden element pred nego mojt da skokat dve napred
                    list.delete(curr);
                    curr = curr.succ.succ;
                }
                else { //dojden e na posledniot element nemojt da skokat dve napred
                    list.delete(curr);
                    curr = null;
                }
            }

            System.out.println(list);

            if (list.getSize() == 1){
                break;
            }

            curr = list.getLast().pred; //staj go na vtoriot od krajot
            while (curr != null){
                if (curr.pred != null){
                    list.delete(curr);
                    curr = curr.pred.pred;
                }
                else {
                    list.delete(curr);
                    curr = null;
                }
            }

            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        DLL<Character> list = new DLL<>();

        //String []pom = line.split(" ");
        for (int i=0; i < line.split(" ").length; i++){
            list.insertLast(line.split(" ")[i].charAt(0));
        }

        transformiraj(list);
    }
}
