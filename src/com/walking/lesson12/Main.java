public class Main {
    public static void main(String[] args) {
        Counter electricity = new Counter("Электричество", "kw/h");
        Counter hotWater = new Counter("Горячая вода", "л.");
        Counter coldWater = new Counter("Холодная вода", "л.");
        Counter gas = new Counter("Газ", "м?/ч");

        CounterService.writeDownObjectIntoArray(electricity);
        CounterService.writeDownObjectIntoArray(hotWater);
        CounterService.writeDownObjectIntoArray(coldWater);
        CounterService.writeDownObjectIntoArray(gas);

        print("Электричество");
        print("Горячая вода");
        print("Холодная вода");
        print("Газ");
    }
    private static void print(String name) {
        String nameCounter = CounterService.getArray(name).name;
        int counter = CounterService.getArray(name).counter;

        System.out.println(nameCounter + " : " + counter);
    }
}
