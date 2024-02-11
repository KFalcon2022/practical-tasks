package com.walking.lesson49_optional.task1.service;

import java.util.HashSet;
import java.util.Random;

public class RandomService {
    private static HashSet<String> vinTable = new HashSet<>();
    public static String randomVin(){
        String resultVin = "ZFA";
        Random rnd = new Random();
        for (int i=0;i<14;i++){
            resultVin+=rnd.nextInt(11);
        }
        if (vinTable.contains(resultVin))
            resultVin=randomVin();
        else vinTable.add(resultVin);

        return resultVin;
    }
}
