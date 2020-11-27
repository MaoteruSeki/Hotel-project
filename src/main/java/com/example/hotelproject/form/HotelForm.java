package com.example.hotelproject.form;

import org.springframework.web.multipart.MultipartFile;

public class HotelForm {

    private String name;
    private String description;
    private MultipartFile file;
    private String phone;
    private String location;
    private String body;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public HotelForm() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HotelForm(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HotelForm(String location, String body) {
        this.location = location;
        this.body = body;
    }

}