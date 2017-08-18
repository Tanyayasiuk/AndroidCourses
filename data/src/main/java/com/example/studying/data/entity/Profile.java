package com.example.studying.data.entity;

import com.google.gson.annotations.SerializedName;

public class Profile implements DataModel{

    @SerializedName("name")
    private String firstName;

    @SerializedName("surname")
    private String lastName;

    @SerializedName("age")
    private int age;

    @SerializedName("objectId")
    private String id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
