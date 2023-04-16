public class CounterService {
    private static Counter[] arrayCounter = new Counter[0];

    public static void writeDownObjectIntoArray(Counter counter) {
        if (arrayCounter.length == 0) {                             // проверяем пустой ли массив. Если пустой,
            arrayCounter = new Counter[1];                          // значит нам поступает самый первый объект.
            arrayCounter[0] = counter;                              // Просто создаем массив с этим объектом и завершаем работу метода.
            return;
        }
        if (hasThisElement(arrayCounter, counter.name) == true) {   // Проверяем, если ли счетчик с таким именем в массиве, если есть, то останавливаем работу метода.
            System.out.println("Счетчик " + counter.name + " уже есть в массиве, повторно счетчик записан в массив не будет. Измените его название.");
            return;
        }
        Counter[] copyArray = new Counter[arrayCounter.length + 1]; // Если массив уже заполнен какими-то данными,
        for (int j = 0; j < arrayCounter.length; j++) {             // значит создаем массив, количество элементов которого на 1 больше, чем в исходном массиве.
            copyArray[j] = arrayCounter[j];                         // Копируем исходный массив в новосозданный
        }
        copyArray[copyArray.length - 1] = counter;                  // Так как мы создали массив на 1 элемент больший чем исходный, записываем в него новый объект.

        arrayCounter = new Counter[copyArray.length];               // Теперь нужно наш исходный массив дополнить новым объектом.
        for (int k = 0; k < copyArray.length; k++) {                // Для этого копируем данные из новосозаднного массива в исходный.
            arrayCounter[k] = copyArray[k];
        }
    }
    private static boolean hasThisElement(Counter[] arrayCounter, String name) {
        for (int i = 0; i < arrayCounter.length; i++) {
            if (arrayCounter[i].name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Counter getArray(String name) {                   // Создаем статический метод, который возвращает объект по имени
        for (int i = 0; i < arrayCounter.length; i++) {
            if (arrayCounter[i].name.equals(name)) {
                return arrayCounter[i];
            }
        }
        System.out.println("Объекта с таким именем не обнаружено.");
        return null;                                                /* Не могу здесь решить проблему того, если объект с таким именем не найдется.
                                                                    /* Ведь тогда будет ошибка: Exception in thread "main" java.lang.NullPointerException: Cannot read field
                                                                    /* "name" because the return value of "com.walking.counterAggregation.CounterService.getArray(String)" is null.*/

    }
    public static void increase(String name) {
        getArray(name).counter++;                                   // Увеличение счетчика на 1 по имени объекта
    }
    public static void increaseByCertainValue(String name, int num) {
        getArray(name).counter+= num;                               // Увеличение счетчика на заданное число по имени объекта
    }
    public static void turnToZero(String name) {
        getArray(name).counter = 0;                                 // Обнуление счетчика по имени объекта
    }
}
