package com.earana.mvc.springmvc.models;

public class User {

    private String name;
    private String lastname;
    private String email;
    private Short age;
    
    public User(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;

    }
    
    public User(String name, String lastname, String email, Short age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
    
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
