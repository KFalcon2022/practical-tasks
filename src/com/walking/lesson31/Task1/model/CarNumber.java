package com.walking.lesson31.Task1.model;

import java.io.Serializable;
import java.util.logging.Logger;

public final class CarNumber implements Serializable {
    private final static Logger LOG = Logger.getLogger(CarNumber.class.getName());

    private final Region region;
    private final String number;

    public CarNumber(Region region, String number){
        this.region = region;
        this.number = number.toUpperCase();
    }

    public CarNumber(int region, String number){
        this.region = validateRegion(region);
        this.number = number.toUpperCase();
    }

    private Region validateRegion(int value) {
        for (Region region : Region.values()) {
            if (region.getValue() == value){
                return region;
            }
        }
        LOG.warning("Unknown region number passed: " + value);
        return Region.NONE;
    }

    public String getNumber() {
        return number;
    }

    public int getRegionCode() {
        return region.getValue();
    }

    public String getRegionName() {
        return region.getTitle();
    }

    @Override
    public String toString(){
        return String.format("Number: %s, Region: %d \"%s\"", getNumber(), getRegionCode(), getRegionName());
    }

    @Override
    public int hashCode(){
        return number.hashCode() * 11 + region.hashCode() * 7;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null) {return false;}
        return hashCode() == o.hashCode();
    }
}
