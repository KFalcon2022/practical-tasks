package com.walking.lesson26_string_types.task1.model;

public class Rectangle {
    private final char HORIZONTAL_LINE='-';
    private final char VERTICAL_LINE='|';
    private final char ANGLE=' ';
    private final char NEW_LINE='\n';
    private int a;
    private int b;
    private String image;

    public Rectangle(int a, int b){
        this.a=a;
        this.b=b;
        this.image=setImage();
    }

    public String getImage(){
        return image;
    }
    
    private String setImage(){
        StringBuilder result=new StringBuilder();
        a++;
        b++;
        for (int y=0; y<=a; y++){
            for (int x=0; x<=b; x++){
                result.append(printLines(a, b, x, y));
            }
            result.append(NEW_LINE);
        }
        return result.toString();
    }

    private char printLines(int a, int b, int x, int y){
        if((y==0&x==0)||(y==a&x==0)||(y==0&x==b)||(y==a&x==b)||(y>0&y<a&x>0&x<b)){ 
            return ANGLE;
        } else if (y==0||y==a){
            return HORIZONTAL_LINE;
        }else {
            return VERTICAL_LINE;
        }
    }
}
