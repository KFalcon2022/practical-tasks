import java.util.ArrayList;

public class CounterService {
    private ArrayList<Counter> counters= new ArrayList<Counter>();
    public void addCounter(Counter...counters){
        for(Counter x: counters){
            this.counters.add(x);
        }
   }
   public Counter getCounter(String name){
        for(Counter i: counters){
            if (i.getNAME().equals(name)){
                return i;
            }
        }
       System.out.println("Счетчика с таким названием нет");
       return null;
   }
   public ArrayList getAllCounters(){
        if(counters.isEmpty()){
            System.out.println("Нет доступных счетчиков");
            return null;
        }
        return counters;
   }
    public int increase(Counter counter, int value) {
        return counter.increaseCounter(value);
    }
    public int increment(Counter counter) {
        return counter.increaseCounter(1);
    }
    public int reset(Counter counter){
        return counter.multiply(0);
    }
    private boolean isEmpty(){
        for(Counter x: counters){
            if(x != null){
                return false;
            }
        }
        return true;
    }
}