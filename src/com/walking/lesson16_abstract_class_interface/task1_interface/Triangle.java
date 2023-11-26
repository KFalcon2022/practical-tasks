package Lesson16.Task1.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends rightShape implements drowable{
    private List<String> triangleArray = new ArrayList<String>();
    private final int width;
    public Triangle(int length, int width) {
        super(length);
        if (width >= 1 && width < Integer.MAX_VALUE)
            this.width = width;
        else {
            System.out.println("Wrong width");
            this.width = 2;
        }
    }
    public void draw()
    {
        triangleCalculate(this.length-1, this.width-1);
        for (String line : triangleArray)
        {
            System.out.println(line);
        }
    }

    private List<String> triangleCalculate(int length, int width)
    {
        String line = "";
        if (length==0)
        {
            line+=VERTICAL_LINE;
            for (int i = 0; i<=width; i++)
            {
                if (i!=width)
                line += HORIZONTAL_UNDERLINE;
                else line += ECKE;
            }
            this.triangleArray.add(line);
            return triangleArray;
        }
        else if (length == (this.length-1))
        {
            line += ECKE;
            for (int i = 0; i<=width; i++)
            {
                line += EMPTY_ELEMENT;
            }
            this.triangleArray.add(line);
        }
        else
        {
                String sub1 = VERTICAL_LINE;
                if (((this.length - length)-1) < width) {
                    sub1 += EMPTY_ELEMENT.repeat((this.length - length) - 1);
                }
                else
                    sub1 += EMPTY_ELEMENT.repeat(width-1);
                String sub2 = ECKE;
                for (int i=0; i<= width-1;  i++)
                {
                    sub2+=EMPTY_ELEMENT;
                }
                line = sub1+sub2;
                this.triangleArray.add(line);
        }
        return triangleCalculate(length-1, width);
    }
}
