package lesson19_object_methods;
import Model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[]{new Toyota(), new Honda(), new BMW()};

        System.out.println("Enter a number of a car: ");
        Scanner input = new Scanner(System.in);
        String numberCar = input.nextLine();
        if(numberCar == null){
            System.out.println("The car hasn't been found");
            return;
        }
        input.close();

        Car car = getCar(cars, numberCar);
        if(car == null) {
            System.out.println("The car hasn't been found");
        } else{
            System.out.println("The brand of the car is " + car.getBrand() + "\n" + "The color of the car is " + car.getColor() + "\n" + "The number of the car is " + car.getNumber());
        }
    }

    public static Car getCar(Car[] cars, String numberCar) {
        if (cars == null) {
            return null;
        }
        for (Car car : cars) {
            if(containsObject(car)){
                if(car.getNumber().equals(numberCar)){
                    return car;
                }
            }
        }
        return null;
    }

    private static boolean containsObject(Car car){
        if(car == null){
            return false;
        }
        if(car instanceof Toyota){
            if(!(car.hashCode() == new Toyota().hashCode())){
                return false;
            }
            return car.equals(new Toyota());
        }
        if(car instanceof Honda){
            if(!(car.hashCode() == new Honda().hashCode())){
                return false;
            }
            return car.equals(new Honda());
        }
        if(car instanceof BMW){
            if(!(car.hashCode() == new BMW().hashCode())){
                return false;
            }
            return car.equals(new BMW());
        }
        return false;
    }
}
