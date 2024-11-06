package com.walking.lesson67_locks.task2_1.model;

import java.time.LocalDateTime;

public class Accident {
public final AccidentType Type;
public final String Place;
private int victimCount;
private String description;
public final LocalDateTime Time;

public Accident(String place, AccidentType type){
    this.Place=place;
    this.Type=type;
    this.Time=LocalDateTime.now();
}

public Accident(String place, AccidentType type, int victimCount, String description){
    this.Place=place;
    this.Type=type;
    this.victimCount=victimCount;
    this.description=description;
    this.Time=LocalDateTime.now();
}

public int getVictimCount() {
    return victimCount;
}

public void setVictimCount(int victimCount) {
    this.victimCount = victimCount;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}
    
@Override
public int hashCode(){
    int result=this.Place==null ? 0 : this.Place.hashCode();
    result=29*result+(this.Time==null ? 0 : this.Time.hashCode());
    return result;
}

}
enum AccidentType{
    CarAccident,
    Fire,
    Flood,
    Explosion
}

