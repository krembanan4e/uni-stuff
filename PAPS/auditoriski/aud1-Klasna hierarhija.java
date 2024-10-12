//klasna hierarhija

public class Main {
    public static void main(String[] args) {

        //nemat vrska sho se dolu klasite pak gi raspoznavat
        Bicycle b = new Bicycle(1, 60);
        System.out.println(b.toString());
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.toString());

    }
}

class Bicycle {
    public int gear;
    public int speed;

    //konstruktor
    public Bicycle(int gear, int speed){
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement){
        speed -= decrement;
    }

    public void speedUp(int increment){
        speed += increment;
    }

    public String toString(){
        return ("Number of gears are " + gear + ", speed of bicycle is " + speed);
    }
}


//derived class - nasleduvanje
class MountainBike extends Bicycle {

    public int seatHeight;

    //konstruktor
    public MountainBike(int gear, int speed, int startHeight){
        //invoking base-class(Bicycle) construktor using word "super"
        super(gear, speed);
        seatHeight = startHeight;
    }

    public void setSeatHeight(int value){
        seatHeight = value;
    }

    //Overriding toString method of Bicycle to print more info
    @Override
    public String toString(){
        return (super.toString() + ", seat height is: " + seatHeight);
    }
}
