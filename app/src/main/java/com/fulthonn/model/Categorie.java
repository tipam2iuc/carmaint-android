package com.fulthonn.model;

import android.media.Image;

public class Categorie
{
    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    private int Thumbnail;
    private String nomCategorie;

    public Categorie(String nomCategorie, int thumbnail ) {
        this.nomCategorie = nomCategorie;
        Thumbnail = thumbnail;
    }
}
