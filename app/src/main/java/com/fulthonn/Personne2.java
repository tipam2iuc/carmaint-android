package com.fulthonn;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Personne2 {
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private  int success;

    @SerializedName("cni")
    private String cni;
    @SerializedName("firtname")
    private String firsName;
    @SerializedName("lastname")
    private String lastName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("role")
    private String role;
    @SerializedName("email")
    private String email;
}
