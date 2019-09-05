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

@Document(collection = "memberships")
public class Membership {
    @Id
    String id;
    String group_id;
    String congregant_id;
    String status;

    public Membership() {
    }

    public Membership(String group_id, String congregant_id, String status) {
        this.group_id = group_id;
        this.congregant_id = congregant_id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getCongregant_id() {
        return congregant_id;
    }

    public void setCongregant_id(String congregant_id) {
        this.congregant_id = congregant_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}