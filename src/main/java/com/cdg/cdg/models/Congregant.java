/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdg.cdg.models;

/**
 *
 * @author victorpuch
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "congregants")
public class Congregant {
    @Id
    String id;
    String status;
    String name;
    String first_last_name;
    String second_last_name;
    String address;
    String phone;
    String email;
    String birthday;
    String gender;
    String civil_status;
    String type;
    String baptized;

    public Congregant() {
    }

    public Congregant(String status, String name, String first_last_name, String second_last_name, String address, String phone, String email, String birthday, String gender, String civil_status, String type, String baptized) {
        this.status = status;
        this.name = name;
        this.first_last_name = first_last_name;
        this.second_last_name = second_last_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.civil_status = civil_status;
        this.type = type;
        this.baptized = baptized;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBaptized() {
        return baptized;
    }

    public void setBaptized(String baptized) {
        this.baptized = baptized;
    }
    
    
}