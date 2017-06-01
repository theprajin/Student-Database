package com.infotechnocation.studentdatabase.entity;

import java.io.Serializable;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class Students implements Serializable{
    int id;
    String name;
    String roll;
    String address;

    public Students() {
    }

    public Students(String name, String roll, String address) {
        this.name = name;
        this.roll = roll;
        this.address = address;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
