public class Triangle extends RightFigure {
    public void print (int size){
        for (int i =0;i<size;i++ ){
            System.out.println(" ".repeat(size-i)+"/"+" ".repeat(i*2)+"\\");



        }
        System.out.println( "__".repeat(size));



    }
}
