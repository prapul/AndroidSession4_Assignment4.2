package com.spambox.payal.androidsession4_assignment42;

public class People {

    private String name;
    private Integer distance;
    private String descr;

    public People(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public People(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }

    public People(String name, Integer distance, String descr) {
        this.name = name;
        this.distance = distance;
        this.descr = descr;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDistance() {
        return distance;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
