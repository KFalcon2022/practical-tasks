package com.walking.lesson33.Task1;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

public class DataBase {
    private final String path;
    private List<Car> data;

    public DataBase(String path){
        this.path = path;
        data = new ArrayList<Car>();
    }

    private int getMsec() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // рандом в джаве настолько мутный, что пока просто вот так вот. потом как-нибудь
    public void fill(int quantity){
        data.clear();
        int seed = getMsec();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] names = {"Вася", "Петя", "Валя", "Галя", "Сережа", "Леша", "Катя", "Света", "Саша"};
        String[] models = {"Model1", "Model2", "Model3", "Model4", "Model5"};

        for (int i=0; i<quantity; i++){
            data.add(new Car(
                    String.format("%02d %s%03d", seed % 100, letters.charAt(seed % letters.length()), seed % 1000),
                    names[seed % names.length],
                    models[seed % models.length]
            ));
            seed = Math.abs(seed * 13 - i * getMsec());
        }
    }

    public List<Car> items(){
        return data;
    }

    public boolean saveToFile(){
        try (FileOutputStream fos = new FileOutputStream(path)){
            for (Car car : data){
                fos.write(car.asObject().getBytes());
                fos.write(System.getProperty("line.separator").getBytes());
            }
            fos.flush();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadFromFile(){
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(path), "UTF-8")){
            data.clear();
            int ch;

            StringBuilder sb = new StringBuilder();
            while ((ch = fis.read()) != -1){
                if ((char) ch == System.getProperty("line.separator").charAt(0)){
                    data.add(new Car(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append((char) ch);
            }

            if (!sb.toString().strip().isEmpty()){
                data.add(new Car(sb.toString()));
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
