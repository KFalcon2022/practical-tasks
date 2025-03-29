package lesson13_inheritance.task2;

class Animal {
    String shout;
    
    Animal(String shout) {
        this.shout = shout;
    }
    
    protected void sound() {
        System.out.println(this.shout);
    }
}
