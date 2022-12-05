package com.walking.lesson21.Task1.model;

/**
 * База данных состоит из машин Car
 * Модель и регион - enum
 * Владелец - по идее immutable
 * Поиск осуществляется по региону и номеру
 */
public class DataBase {
    private final Car[] data;
    private static final String MSG_NOTHING = "Ничего не найдено";

    public DataBase(){
        this.data = new Car[]{
                new Car(CarModel.FORD_FOCUS, "C651AK", Region.KARELIA, "Вася Пупкин"),
                new Car(CarModel.TOYOTA_COROLLA, "G430EA", Region.KOMI, "Петя"),
                new Car(CarModel.LADA_SEDAN, "D493WF", Region.ASTRAHAN, "Катя"),
                new Car(CarModel.TOYOTA_COROLLA, "V159QF", Region.MOSOBL50, "Маша Смирнова"),
                new Car(CarModel.KIA_RIO, "V464AS", Region.PSKOV, "Шурик Батькович"),
                new Car(CarModel.KIA_RIO, "Z649FE", Region.KALUGA, "Лупа"),
                new Car(CarModel.PEUGEOUT_BOXER, "M159RG", Region.YANAO, "Пупа"),
                new Car(CarModel.PEUGEOUT_BOXER, "H357LL", Region.SARATOV64, "Лёлек"),
                new Car(CarModel.TOYOTA_COROLLA, "O000OO", Region.KURSK, "Болек"),
                new Car(CarModel.MERCEDES_BENZ, "Z777RU", Region.MOSCOW77, "Вова Просто"),
                new Car(CarModel.RENAULT_LOGAN, "Q464HG", Region.TOMSK, "Яна")
        };
    }

    public String queryByNumber(int searchRegion, String searchNumber) {
        Region region = Validator.validateRegion(searchRegion);
        String search = region + searchNumber;

        for (Car car : data) {
            if (car.equals(search)){
                return "Машина найдена по регистрационному номеру\n" + car;
            }
        }

        return MSG_NOTHING;
    }

    public String queryByOwner(String searchOwner) {
        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по имени владельца\n");

        for (Car car : data) {
            if (car.isOwner(searchOwner)){
                sb.append(car).append("\n");
            }
        }
        return sb.toString();
    }

    public String queryByModel(String searchModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("Машины найдены по модели\n");

        for (Car car : data) {
            if (car.isModel(searchModel)){
                sb.append(car).append("\n");
            }
        }
        return sb.toString();
    }
}
