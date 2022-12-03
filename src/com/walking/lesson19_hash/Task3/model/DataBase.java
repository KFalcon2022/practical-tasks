package com.walking.lesson19_hash.Task3.model;

public class DataBase {
    private final Car[] data;

    public DataBase(){
        this.data = new Car[]{
                new Car(CarModel.FORD_FOCUS, "C651AK", Region.KARELIA, "Вася"),
                new Car(CarModel.TOYOTA_COROLLA, "G430EA", Region.KOMI, "Петя"),
                new Car(CarModel.LADA_SEDAN, "D493WF", Region.ASTRAHAN, "Катя"),
                new Car(CarModel.TOYOTA_COROLLA, "V159QF", Region.MOSOBL50, "Маша"),
                new Car(CarModel.KIA_RIO, "V464AS", Region.PSKOV, "Саша"),
                new Car(CarModel.KIA_RIO, "Z649FE", Region.KALUGA, "Лупа"),
                new Car(CarModel.PEUGEOUT_BOXER, "M159RG", Region.YANAO, "Пупа"),
                new Car(CarModel.PEUGEOUT_BOXER, "H357LL", Region.SARATOV64, "Лёлек"),
                new Car(CarModel.TOYOTA_COROLLA, "O000OO", Region.KURSK, "Болек"),
                new Car(CarModel.MERCEDES_BENZ, "Z777RU", Region.MOSCOW77, "Вова"),
                new Car(CarModel.RENAULT_LOGAN, "Q464HG", Region.TOMSK, "Яна")
        };
    }

    public String query(int searchRegion, String searchNumber) {
        Region region = Validator.validateRegion(searchRegion);
        String search = region + searchNumber;

        for (Car car : data) {
            if (car.equals(search)){
                return "Машина найдена по регистрационному номеру\n" + car;
            }
        }

        return "Ничего не найдено";
    }
}
