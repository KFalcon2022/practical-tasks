package com.walking.lesson21_immutable_object;
import com.walking.lesson21_immutable_object.model.Car;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[]{
                new Car("Honda", "Fit", "2014", "white", "P590HT125", "DAAGP66545234"),
                new Car("Toyota", "Mark 2", "1999", "white", "O712BP125", "GX1056006383"),
                new Car("Toyota", "Vitz", "2008", "grey", "H523HC125", "NCP11231532123"),
                new Car("Nissan", "Note", "2011", "blue", "H925TC125", "GVNO103952736"),
                new Car("Toyota", "Probox", "2005", "white", "B150EM125", "PIZDA123587543"),
                new Car("test", "test", "test", "test", "TEST", "TEST"),
                new Car("Toyota", "Crown", "2020", "black", "X777XX777", "S220N119043234")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter government registration number: ");
        String regNum = sc.nextLine().toUpperCase().replace(" ", "");
        System.out.print("Enter body/frame number or vin: ");
        String vin = sc.nextLine().toUpperCase().replace(" ", "");
        Car desired = new Car("", "", "", "", regNum, vin);
        try {
            System.out.println(findCar(cars, desired));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String findCar(Car[] cars, Car obj) throws FileNotFoundException {
        String result = null;
        for (Car car : cars) {
            if (car.equals(obj)) {
                result = "\nCar is found!" + "\n" +
                        "Vendor: " + (car.getVendor()) + "\n" +
                        "Model: " + car.getModel() + "\n" +
                        "Issue year: " + car.getIssueYear() + "\n" +
                        "Frame/Body number or VIN: " + car.getVin().toUpperCase() + "\n" +
                        "Color: " + car.getColor() + "\n" +
                        "Registration number: " + car.getRegNumber().toUpperCase() + "\n";
                return result;
            }
        }
        if (result != null){
            return result;
        }else {
            throw new FileNotFoundException("Car not found!");
        }
    }
}