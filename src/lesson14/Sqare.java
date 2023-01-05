public class Sqare extends RightFigure {
    public void print(int size){
       String v= "|";
        String h ="";
       for (int i=0;i<size;i++){
           h= h+"-";
           v=v+" ";
       }
       v=v+"|";

        System.out.println(h);
        for (int i = 0;i<size;i++){
            System.out.println(v);
        }
        System.out.println(h);


    }

}
