public class Counter {
    private final String NAME;
    private final String UNIT;

    private int counter;

    public Counter(String name, String unit) {
        this(name, unit, 0);
    }
    public Counter(String name, String unit, int counter){
        NAME = name;
        UNIT = unit;
        this.counter = counter;
    }
    public String getNAME(){
        return NAME;
    }
    public String getUNIT(){
        return UNIT;
    }
    public int getCounter(){
        return counter;
    }
    public int increaseCounter(int num){
        return counter+=num;
    }
    public int multiply(int num){
        return counter*=num;
    }
}

