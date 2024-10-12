//Generici

import java.security.cert.CertificateEncodingException;

class GenericsClass<T>{

    //variable of T type
    private T data;

    public GenericsClass(T data){
        this.data = data;
    }

    //method that returns T type variable
    public T getData(){
        return this.data;
    }
}

public class Main {
    public static void main(String[] args) {

        GenericsClass<Integer> intObj = new GenericsClass<>(5);
        System.out.println("Generics class returns: " + intObj.getData());

        GenericsClass<String> strObj = new GenericsClass<>("Java Programming");
        System.out.println("Generics class returns: " + strObj.getData());

    }
}
