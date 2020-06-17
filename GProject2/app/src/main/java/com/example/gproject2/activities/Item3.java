package com.example.gproject2.activities;

public class Item3 {
    int id; // 나중에 DB에서 조회한 id 값을 넣어두기 위한 것
    int image;
    String title;
    String category;
    String address;
    String state;
    String phone;

    public Item3 (int id, int image, String title, String category, String address, String state, String phone) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.category = category;
        this.address = address;
        this.state = state;
        this.phone = phone;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
