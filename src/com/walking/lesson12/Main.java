
public class Main {
    public static void main(String[] args) {
        Counter gasCounter = new Counter("���", "�.���.");
        Counter coldWater = new Counter("�������� ����", "�.���.");
        Counter warmWater = new Counter("������� ����", "�.���.");
        Counter electycity = new Counter("�������������", "��.�.");

        CounterService array = new CounterService();
        array.addCounter(gasCounter, coldWater, warmWater, electycity);

        array.increment(array.getCounter("���"));
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