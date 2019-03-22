package com.fulthonn.model;

import android.media.Image;

public class Model {

    private String nomModel;
    private Image photoModel;
    private String categorie;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    public Image getPhotoModel() {
        return photoModel;
    }

    public void setPhotoModel(Image photoModel) {
        this.photoModel = photoModel;
    }

    public Model(String nomModel, Image photoModel, String categorie) {
        this.nomModel = nomModel;
        this.photoModel = photoModel;
        this.categorie=categorie;
    }
}
