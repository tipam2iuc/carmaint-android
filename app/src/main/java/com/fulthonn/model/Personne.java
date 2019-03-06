package com.fulthonn.model;

import java.util.Date;
import java.util.Objects;

public class Personne {
    private long idCard;
    private String firsName;
    private String lastName;
    private Date birthday;
    private Role role;
    private String email;
    private Date dateEmbauche;
    private Date numeroPermis;
    private Date expirationPermis;

    public Personne(long idCard, String firsName, String lastName, Date birthday, Role role, String email, Date dateEmbauche, Date numeroPermis, Date expirationPermis) {
        this.idCard = idCard;
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role = role;
        this.email = email;
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

    private enum Role{
        responsableParc,
        mecanicien,
        agentReservation,
        agentParking,
        chauffeur,
        client
    }

    public long getIdCard() {
        return this.idCard;
    }

    public void setIdCard(long IdCard) {
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

    public Role getRole() {
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

    public void setRole(Role role) {
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
