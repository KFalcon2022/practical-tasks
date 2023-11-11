
public class Main {
    public static void main(String[] args) {
        Counter gasCounter = new Counter("√аз", "м.куб.");
        Counter coldWater = new Counter("’олодна€ вода", "л.куб.");
        Counter warmWater = new Counter("√ор€ча€ вода", "л.куб.");
        Counter electycity = new Counter("Ёлектричество", "кв.ч.");

        CounterService array = new CounterService();
        array.addCounter(gasCounter, coldWater, warmWater, electycity);

        array.increment(array.getCounter("√аз"));
        System.out.println(gasCounter.getCounter());

        array.reset(gasCounter);

        print(coldWater);
        print(warmWater);
        print(gasCounter);
        print(electycity);
    }
    private static void print(Counter counter){
        System.out.printf("%s: %d\n", counter.getNAME(), counter.getCounter());
    }
}