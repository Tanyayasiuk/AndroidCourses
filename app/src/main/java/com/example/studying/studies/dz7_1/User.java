package com.example.studying.studies.dz7_1;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class User {
    private String firstName;
    private String lasName;
    private String age;
    private String imageUrl;
    private char sex;

    private ImageView view;

    public User(String firstName, String lasName, String age, String imageUrl, char sex) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.age = age;
        this.imageUrl = imageUrl;
        this.sex = sex;
    }

    public static User[] ITEMS = new User[]{
            new User("Oleg", "Fedorov", "24", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-H1-icon.png" , 'm'),
            new User("Anna", "Sidorova", "19", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FE-4-blonde-icon.png", 'f'),
            new User("Fedor", "Sokolov", "26", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-E4-icon.png", 'm'),
            new User("Artem", "Semenov", "22", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-F1-icon.png", 'm'),
            new User("Marina", "Anikina", "23", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FE-5-blonde-icon.png", 'f'),
            new User("Ignat", "Domeiko", "44", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-A3-icon.png", 'm'),
            new User("Anna-Maria", "Akselrod", "25", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FI-1-icon.png", 'f')
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
