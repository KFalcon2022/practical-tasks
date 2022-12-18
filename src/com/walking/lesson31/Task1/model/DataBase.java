package com.walking.lesson31.Task1.model;

import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class DataBase {
    private final static String MSG_NOTHING = "Ничего не найдено";
    private final static Logger LOG = Logger.getLogger(DataBase.class.getName());

    private final String DB_FILE;
    private List<Car> data;

    public DataBase(String path){
        DB_FILE = path;

        unserialize(); // Да, помню, что методы не гуд вызывать из конструктора.
/*
        data = new ArrayList<>();
        data.add(new Car(CarModel.FORD_FOCUS, "C651AK", Region.KARELIA, "Пупкин Василий Васильевич"));
        data.add(new Car(CarModel.TOYOTA_COROLLA, "G430EA", Region.KOMI, "Смирнов Максим Иванович"));
        data.add(new Car(CarModel.LADA_SEDAN, "D493WF", Region.ASTRAHAN, "Пушкина Екатерина Алексеевна"));
        data.add(new Car(CarModel.TOYOTA_COROLLA, "V159QF", Region.MOSOBL50, "Смирнова Мария Ивановна"));
        data.add(new Car(CarModel.KIA_RIO, "V464AS", Region.PSKOV, "Сидоров Евлампий Карпович"));
        data.add(new Car(CarModel.KIA_RIO, "Z649FE", Region.KALUGA, "Краснова Юлия Федоровна"));
        data.add(new Car(CarModel.PEUGEOUT_BOXER, "M159RG", Region.YANAO, "Жилкин Семен Спиридонович"));
        data.add(new Car(CarModel.PEUGEOUT_BOXER, "H357LL", Region.SARATOV64, "Имярек Лёлек Батькович"));
        data.add(new Car(CarModel.TOYOTA_COROLLA, "O000OO", Region.KURSK, "Имярек Болек Батькович"));
        data.add( new Car(CarModel.MERCEDES_BENZ, "Z777RU", Region.MOSCOW77, "Цукерман Петр Петрович"));
        data.add(new Car(CarModel.RENAULT_LOGAN, "Q464HG", Region.TOMSK, "Бесценная Яна Игоревна"));

 */
    }

    public int getSize(){
        return data.size();
    }

    public String queryByNumber(int region, String number) {
        CarNumber tempNumber = new CarNumber(region, number);

        for (Car car : data) {
            if (car.getNumber().equals(tempNumber)){
                return "Машина найдена по регистрационному номеру\n" + car;
            }
        }

        return MSG_NOTHING;
    }

    public String queryByOwner(String owner) {
        Person tempOwner = new Person(owner);

        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по имени владельца\n");

        for (Car car : data) {
            if (car.getOwner().equals(tempOwner)){
                sb.append(car).append("\n");
            }
        }

        return sb.toString();
    }

    public String queryByBrandModel(String brand, String model) {
        CarModel tempModel = CarModel.validate(brand, model);

        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по модели:\n");

        for (Car car : data) {
            if (car.getModel().equals(tempModel)){
                sb.append(car).append("\n");
            }
        }
        return sb.toString();
    }

    public void serialize() throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB_FILE))){
            oos.writeObject(data);

        } catch (IOException e){
            throw new IOException();
        }
    }

    public void unserialize() throws IllegalArgumentException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DB_FILE))){
            data = (ArrayList<Car>) ois.readObject();

        } catch (ClassNotFoundException | IOException | ClassCastException e){
            data = new ArrayList<Car>();
        }
    }

    public void add(int region, String number, String brand, String model, String owner){
        CarModel tempModel = CarModel.validate(brand, model);
        Region tempRegion = Region.validate(region);
        data.add(new Car(tempModel, number, tempRegion, owner));
        try {
            serialize();
        } catch (IOException e){
            // do nothing
        }
    }
}