package com.example.studying.domain.entity;


public class Dz10Model implements DomainModel {

    private String name;
    private long timer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
}
