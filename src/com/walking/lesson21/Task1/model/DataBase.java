package com.walking.lesson21.Task1.model;

/**
 * База данных состоит из машин Car
 * Модель и регион - enum
 * Владелец - по идее immutable
 * Поиск осуществляется по региону и номеру
 */
public class DataBase {
    private static final String MSG_NOTHING = "Ничего не найдено";

    private final Car[] data;

    public DataBase(){
        this.data = new Car[]{
                new Car(CarModel.FORD_FOCUS, "C651AK", Region.KARELIA, "Вася Пупкин"),
                new Car(CarModel.TOYOTA_COROLLA, "G430EA", Region.KOMI, "Петя Смирнов"),
                new Car(CarModel.LADA_SEDAN, "D493WF", Region.ASTRAHAN, "Катя Пушкина"),
                new Car(CarModel.TOYOTA_COROLLA, "V159QF", Region.MOSOBL50, "Маша Смирнова"),
                new Car(CarModel.KIA_RIO, "V464AS", Region.PSKOV, "Шурик Батькович"),
                new Car(CarModel.KIA_RIO, "Z649FE", Region.KALUGA, "Лупа Батькович"),
                new Car(CarModel.PEUGEOUT_BOXER, "M159RG", Region.YANAO, "Пупа Батькович"),
                new Car(CarModel.PEUGEOUT_BOXER, "H357LL", Region.SARATOV64, "Лёлек Батькович"),
                new Car(CarModel.TOYOTA_COROLLA, "O000OO", Region.KURSK, "Болек Батькович"),
                new Car(CarModel.MERCEDES_BENZ, "Z777RU", Region.MOSCOW77, "Вова Просто"),
                new Car(CarModel.RENAULT_LOGAN, "Q464HG", Region.TOMSK, "Яна Бесценная")
        };
    }

    // Вот например может стоило сравнить equals(new Person(searchOwner)) ?
    public boolean isCarOwner(Car car, String owner) {
        return car.getOwner()
                .equals(owner);
    }

    public boolean isCarModel(Car car, String model) {
        return car.getModel()
                .getName()
                .equals(model);
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

    public String queryByOwner(String ownerName, String ownerSurname) {
        String owner = ownerName + " " + ownerSurname;
        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по имени владельца\n");

        for (Car car : data) {
            if (isCarOwner(car, owner)){
                sb.append(car).append("\n");
            }
        }
        return sb.toString();
    }

    public String queryByBrandModel(String brand, String model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по модели:\n");
        String temp = formatCarModel(brand, model);

        for (Car car : data) {
            if (isCarModel(car, temp)){
                sb.append(car).append("\n");
            }
        }
        return sb.toString();
    }

    private String formatCarModel(String brand, String model){
        return new StringBuilder()
                .append(brand.substring(0,1).toUpperCase())
                .append(brand.substring(1).toLowerCase())
                .append(" ")
                .append(model.substring(0,1).toUpperCase())
                .append(model.substring(1).toLowerCase())
                .toString();
    }
}