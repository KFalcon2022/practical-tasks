package com.walking.lesson20_exeption.task1;

import com.walking.lesson20_exeption.task1.model.Extension;
import com.walking.lesson20_exeption.task1.model.File;
import com.walking.lesson20_exeption.task1.model.FileNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File[] files = new File[]{new File("Porno", 200, Extension.AVI), new File("Story", 10, Extension.TXT), new File("City", 150, Extension.DWG)};

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя интересующего файла: ");
        String name = in.nextLine();

        try{
            findFile(files,name);
        }
        catch(FileNotFoundException ex){
            System.out.print(ex.getMessage());
            System.out.println(ex.getName());
        }
        finally {
            System.out.println("Заходите к нам еще!!!");
        }
    }

    static void findFile(File[] files,String name) throws FileNotFoundException{
        boolean result=false;
        for (File file:files) {
            if (file.getName().equals(name)){
                System.out.println(file.getAll());
                result=true;
            }
        }
        if (!result){
            throw new FileNotFoundException("Искомый файл не существует: ", name);
        }
    }

}
