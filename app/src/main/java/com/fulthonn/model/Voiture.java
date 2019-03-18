package com.fulthonn.model;

import android.media.Image;

import java.util.Date;

public class Voiture {

    private String matricule;
    private String mImageURL;



    private String marque;
    private String modele;
    private Date dateSortie;
    private Date miseEnService;
    private String photo;
    private int nombreAccident;
    private int nombrePanne;
    private double depenseTotalEntretien;
    private int vitesseMax;
    private String typeCarburant;
    private String statut;
    private int nombreDeSortie;

    public Voiture(String matricule, String mImageURL, String marque, String modele, Date dateSortie, Date miseEnService, String photo, int nombreAccident, int nombrePanne, double depenseTotalEntretien, int vitesseMax, String typeCarburant, String statut, int nombreDeSortie) {
        this.matricule = matricule;
        this.mImageURL = mImageURL;
        this.marque = marque;
        this.modele = modele;
        this.dateSortie = dateSortie;
        this.miseEnService = miseEnService;
        this.photo = photo;
        this.nombreAccident = nombreAccident;
        this.nombrePanne = nombrePanne;
        this.depenseTotalEntretien = depenseTotalEntretien;
        this.vitesseMax = vitesseMax;
        this.typeCarburant = typeCarburant;
        this.statut = statut;
        this.nombreDeSortie = nombreDeSortie;
    }

    public Voiture(String matricule, String mImageURL) {
        this.matricule = matricule;
        this.mImageURL = mImageURL;
    }


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        modele = modele;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Date getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(Date miseEnService) {
        this.miseEnService = miseEnService;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNombreAccident() {
        return nombreAccident;
    }

    public void setNombreAccident(int nombreAccident) {
        this.nombreAccident = nombreAccident;
    }

    public int getNombrePanne() {
        return nombrePanne;
    }

    public void setNombrePanne(int nombrePanne) {
        this.nombrePanne = nombrePanne;
    }

    public double getDepenseTotalEntretien() {
        return depenseTotalEntretien;
    }

    public void setDepenseTotalEntretien(double depenseTotalEntretien) {
        this.depenseTotalEntretien = depenseTotalEntretien;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNombreDeSortie() {
        return nombreDeSortie;
    }

    public void setNombreDeSortie(int nombreDeSortie) {
        this.nombreDeSortie = nombreDeSortie;
    }

    private enum Statut{
        accidenté,
        panne,
        sortie,
        disponible,
        occupee
    }
    private enum TypeCarburant{
        Essence,
        Gasoil,
        Electric
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }




}
