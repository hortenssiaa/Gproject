package com.example.gproject2.activities;

public class Item3 {
    int id; // 나중에 DB에서 조회한 id 값을 넣어두기 위한 것
    int image;
    String title;
    String category;
    String address;
    String time;
    String day;

    public Item3 (int id, int image, String title, String category, String address, String time, String day) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.category = category;
        this.address = address;
        this.time = time;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
