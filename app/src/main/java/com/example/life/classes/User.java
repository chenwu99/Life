package com.example.life.classes;

import java.io.Serializable;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {

    private String weight;
    private String majiaxian;
    private String mood, habit, remember;
    private String ID;

    public User(){

    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getWeight() {
        return weight;
    }

    public String getMajiaxian() {
        return majiaxian;
    }

    public String getHabit() {
        return habit;
    }

    public String getMood() {
        return mood;
    }

    public String getRemember() {
        return remember;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public void setMajiaxian(String majiaxian) {
        this.majiaxian = majiaxian;
    }


}
