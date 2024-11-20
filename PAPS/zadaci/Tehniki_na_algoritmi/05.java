/*
Дадена е улица на која има поставено места за улични светилки. Улицата е со должина М и има N такви места на кои можат да се постават улични светилки и нивната позиција е дадена во една низа.
Ако знаеме дека една светилка освен својата позиција осветлува и уште две позиции во лево и две во десно, да се најде најмалиот број на светилки со кои може да се осветли улицата. Не мора да поставуваме светлика на секоја можна позиција.

Влез: Првиот број од влезот е бројот на позиции за светилки N и должината на улицата М, а потоа во следниот ред се дадени можните позиции за поставување на светилки.
Излез: Минимален број на светилки за да се осветли улицата.

Input	Result
5 5
1 2 3 4 5
------------
1


3 10
3 8 9
------------
2

reshenie od Dinev
*/

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //na kolku pozicii imat svetilki
        int m = sc.nextInt(); //opseg na pozicii

        List<Integer> positions = new ArrayList<>(); //mozhni pozicii
        for (int i = 0; i < n; i++){
            positions.add(sc.nextInt());
        }

        List<Boolean> has_light = new ArrayList<>(); //na pocetok se site neosvetleni
        for (int i = 0; i <= m; i++){
            has_light.add(false);
        }

        for (int i = 0; i < n; i++){ //za ta pozicija kaj sho imat svetilka stavi true
            int light_position = positions.get(i);
            has_light.set(light_position, true);
        }

        int first_unlit = 1;
        int number_lights = 0;

        while (first_unlit <= m){
            Integer last_valid_position = null;
            for (int vp = first_unlit - 2; vp <= first_unlit + 2; vp++){  //vp e valid position
                if (1 <= vp && vp <= m){ //dali valid position e vo granici na ulicata
                    if (has_light.get(vp)){
                        last_valid_position = vp;
                    }
                }
            }
            first_unlit = last_valid_position + 3;
            number_lights++;
        }

        System.out.println(number_lights);
    }
}
