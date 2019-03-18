package com.fulthonn.model;

import com.google.gson.annotations.SerializedName;

import java.nio.channels.Pipe;
import java.util.Date;
import java.util.Objects;

public class Personne {
    private int id;



    @SerializedName("cni")
    private String idCard;
    @SerializedName("firtname")
    private String firsName;
    @SerializedName("lastname")
    private String lastName;
    private Date birthday;
    @SerializedName("role")
    private String role;
    private String login;
    @SerializedName("email")
    private String email;
    private String password;
    private Date dateEmbauche;
    private Date numeroPermis;
    private Date expirationPermis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Personne(String firsName, String email, String password,String role) {

        this.firsName = firsName;
        this.email = email;
        this.password = password;
        this.role=role;
    }

    public Personne(int id, String idCard, String firsName, String lastName, Date birthday, String role,String login, String email, String password, Date dateEmbauche, Date numeroPermis, Date expirationPermis) {
        this.id=id;
        this.idCard = idCard;
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role = role;
        this.login=login;
        this.email = email;
        this.password=password;
        this.dateEmbauche = dateEmbauche;
        numeroPermis = numeroPermis;
        expirationPermis = expirationPermis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;
        Personne personne = (Personne) o;
        return getIdCard() == personne.getIdCard();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCard());
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idCard=" + idCard +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", numeroPermis=" + numeroPermis +
                ", expirationPermis=" + expirationPermis +
                '}';
    }

    public enum Role{
        ResponsableParc,
        Mecanicien,
        AgentReservation,
        AgentParking,
        Chauffeur,
        Client
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String IdCard) {
        this.idCard = IdCard;
    }

    public String getFirsName() {
        return this.firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return this.role;
    }



    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateEmbauche() {
        return this.dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getNumeroPermis() {
        return this.numeroPermis;
    }

    public void setNumeroPermis(Date NumeroPermis) {
        this.numeroPermis = NumeroPermis;
    }

    public Date getExpirationPermis() {
        return this.expirationPermis;
    }

    public void setExpirationPermis(Date ExpirationPermis) {
        this.expirationPermis = ExpirationPermis;
    }

    public int GetAge() {
        throw new UnsupportedOperationException();
    }

//    public boolean SeConnecter() {
//        throw new UnsupportedOperationException();
//    }

//    public Personne CreerUtilisateur() {
//        throw new UnsupportedOperationException();
//    }

    public Personne() {

    }

}
