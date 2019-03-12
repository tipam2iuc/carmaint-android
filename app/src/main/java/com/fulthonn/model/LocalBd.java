package com.fulthonn.model;

import java.util.ArrayList;

public final class LocalBd {
    public static ArrayList<Personne> personnes;

    public void add(Personne personne)
    {
        personnes.add(personne);
    }

    public void remove(Personne personne)
    {
        personnes.remove(personne);
    }


}
