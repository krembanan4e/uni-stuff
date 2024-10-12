//Primer 1: Da se ispecati brojot na parni i neparni broevi kako i nivniot prosek od dadena vlezna niza so broevi

public class Main {
    public static void main(String[] args) {

        int[] numbers = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
        int suma = 0, parni = 0, neparni = 0;
        Double prosek;

        //access all elements using for loop
        for (int i=0; i<numbers.length; i++){
            suma += numbers[i];
            if (numbers[i] % 2 == 0){
                parni++;
            }
            else {
                neparni++;
            }
        }

        //vkupen broj elementi vo nizata
        int vkupno = numbers.length;

        //prosek
        prosek = (double)suma / (double)vkupno;

        System.out.println("Ima " + parni + " parni broevi i " + neparni + " neparni broevi.");
        System.out.println("Prosekot e: " + prosek);
    }
}
