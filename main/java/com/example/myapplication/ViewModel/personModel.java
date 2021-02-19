package com.example.myapplication.ViewModel;

public class personModel {

    public String personId;
    public String Name;
    public String email;
    public String phone;
    public String gender;

    public personModel(String name, String email, String phone, String gender,String personId) {
        this.Name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.personId = personId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
