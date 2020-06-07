package org.talentboost.networkforgiving.model;


public class Register {

    private String username;
    private String password;
    private String name;
    private int age;
    private String gender;
    private String location;

    public Register(String username, String password, String name, int age, String gender, String location) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
