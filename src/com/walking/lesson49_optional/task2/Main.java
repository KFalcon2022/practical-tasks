package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.CarIdentifier;
import com.walking.lesson49_optional.task2.model.Housing;
import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.service.CarService;
import com.walking.lesson49_optional.task2.service.HousingSearchService;

/**
 * Реализуйте рад классов:
 * 1. Жилье, должен иметь поле «адрес»;
 * 2. Человек. Поля – «имя», «мать», «отец», «дети», «жилье», «машина», «профессия»;
 * 3. Машина. Предлагаю взять реализацию из Задачи 1 и добавить к ней поле «владелец» типа «Человек».
 * Реализуйте поиск адреса проживания первого ребенка владельца машины с заданным номером и годом выпуска.
 * Используйте реализацию поиска машины из Задачи 1. Изменять ее под требования текущей задачи – недопустимо.
 * <p>
 * Поиск должен быть прекращен, если совпало хотя бы одно из условий:
 * · машина новее 2021 года;
 * · профессия владельца машины или его первого ребенка – «полицейский»;
 * · адрес проживания содержит подстроку «Рублевское шоссе».
 * <p>
 * В таких случаях ничего не должно быть найдено.
 */
public class Main {
    public static void main(String[] args) {
        HousingSearchService service = new HousingSearchService(createCarMap());

        CarIdentifier id = new CarIdentifier("zx222i", 2002);

        service.getService().get(id)
                .flatMap(service::get)
                .ifPresent(Housing::print);
    }

    private static CarService createCarMap() {
        CarIdentifier[] carIDs = createCarIdentifierArray();
        Human[] humans = createHumanArray();
        CarService cars = new CarService();
        cars.put(carIDs[0], humans[0]);
        cars.put(carIDs[1], humans[2]);
        cars.put(carIDs[2], humans[3]);
        cars.put(carIDs[3], humans[4]);
        cars.put(carIDs[4], humans[5]);
        cars.put(carIDs[5], humans[6]);

        return cars;
    }

    private static Human[] createHumanArray() {
        Housing apartment1 = new Housing("Рублёвское шоссе, д.2, кв.47");
        Housing apartment2 = new Housing("Рублёвское шоссе, д.13, кв.13");
        Housing apartment3 = new Housing("улица Строителей, д.1, кв.50");
        Housing apartment4 = new Housing("улица Строителей, д.2, кв.2");
        Housing apartment5 = new Housing("проспект Революции, д.17, кв.23");

        Human alex = new Human("Алекс", null, null, apartment1, "полицейский");
        Human eva = new Human("Ева", null, null, apartment1, "парикмахер");
        Human kate = new Human("Катя", eva, alex, apartment3, "учитель");
        Human dan = new Human("Даниил", null, null, apartment3, "продавец-консультант");
        Human george = new Human("Георгий", eva, alex, apartment4, "полицейский");
        Human helen = new Human("Елена", kate, null, apartment5, "строитель");
        Human liza = new Human("Лиза", null, dan, apartment3, "врач");
        Human viktor = new Human("Виктор", null, dan, apartment2, "официант");

        alex.addKid(kate);
        alex.addKid(george);
        eva.addKid(kate);
        eva.addKid(george);
        kate.addKid(helen);
        dan.addKid(liza);
        dan.addKid(viktor);

        return new Human[]{alex, eva, kate, dan, george, helen, liza, viktor};
    }

    private static CarIdentifier[] createCarIdentifierArray() {
        return new CarIdentifier[]{
                new CarIdentifier("yt456r", 1996),
                new CarIdentifier("io543d", 2003),
                new CarIdentifier("zx222i", 2002),
                new CarIdentifier("lk678t", 2021),
                new CarIdentifier("er345w", 2009),
                new CarIdentifier("qp623k", 2025)
        };
    }
}
