package queue;

/*
Пример:
Влез:
5
РистовскаМоника
РистоваИвана
НиколчевИван
МановскаАдриjана
БуразерМариjан
5
СтоjменовскаЕмилиjа
ПановскиАнгелче
ТраjковскаЕлена
СрбиноскаИвана
БитирноваЛусиjана
5
МилошевскиДамjан
ПавловиќВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар

Излез:
Polagaat e-test:
termin 1
РистовскаМоника
РистоваИвана
НиколчевИван
МановскаАдриjана
БуразерМариjан
МилошевскиДамjан
ПавловиќВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар
Polagaat zadaci:
termin 1
СтоjменовскаЕмилиjа
ПановскиАнгелче
ТраjковскаЕлена
СрбиноскаИвана
БитирноваЛусиjана
МилошевскиДамjан
ПавловиќВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар
 */

import java.util.ArrayList;
import java.util.Scanner;

public class KnigaQueue_str136 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kapacitet = 20;

        int n1 = sc.nextInt();
        sc.nextLine();
        ArrayList<String> e_test  = new ArrayList<>(); //samo e-test
        for (int i = 0; i < n1; i++) {
            e_test.add(sc.nextLine());
        }

        int n2 = sc.nextInt();
        sc.nextLine();
        ArrayList<String> zadaci =  new ArrayList<>(); //samo zadaci
        for (int i = 0; i < n2; i++) {
            zadaci.add(sc.nextLine());
        }

        int n3 = sc.nextInt();
        sc.nextLine();
        ArrayList<String> dvete =  new ArrayList<>(); //i e-test i zadaci
        for (int i = 0; i < n3; i++) {
            dvete.add(sc.nextLine());
        }

        //prvo e-test, pa dvete(teorija), pa zadaci, pa dvete(zadaci)

        int teorija = (int) Math.ceil((n1+n3) / 20); //kolku termini trebat za teorija
        int prakticno = (int) Math.ceil((n2+n3) / 20); //kolku termini trebat za prakticno
        int x=0;

        if (teorija==0){
            teorija = 1;
        }
        if (prakticno==0){
            prakticno = 1;
        }

        System.out.println("Polagaat e-test:");
        for (int i=1; i<=teorija; i++){
            System.out.println("termin " + i);
            for (int j=0; j<kapacitet; j++){
                while(!e_test.isEmpty()){
                    System.out.println(e_test.getFirst());
                    e_test.removeFirst();
                }
                if (e_test.isEmpty()){
                    if (x == dvete.size()){
                        break;
                    }
                    else{
                        System.out.println(dvete.get(x++));
                    }
                }
            }
        }

        x = 0;
        System.out.println("Polagaat zadaci:");
        for (int i=1; i<=prakticno; i++){
            System.out.println("termin " + i);
            for (int j=0; j<kapacitet; j++){
                while(!zadaci.isEmpty()){
                    System.out.println(zadaci.getFirst());
                    zadaci.removeFirst();
                }
                if (zadaci.isEmpty()){
                    if (x == dvete.size()){
                        break;
                    }
                    else {
                        System.out.println(dvete.get(x++));
                    }
                }
            }
        }
    }
}
