package com.fulthonn.model;

import java.util.ArrayList;
import java.util.Date;

public final class LocalBd {
    public static ArrayList<Personne> personnes;
    public static ArrayList<Voiture> myVoitures;
    public static ArrayList<Voiture> myVoituresEnPanne=new ArrayList<>();
    public static ArrayList<Voiture> myVoituresAccident=new ArrayList<>();

    public void add(Personne personne)
    {
        personnes.add(personne);
    }

    public void remove(Personne personne)
    {
        personnes.remove(personne);
    }


   public static void initVoitureAccidentDatas(){

        for (Voiture voiture:LocalBd.myVoitures)
        {
            if(voiture.getStatut().equalsIgnoreCase("Accidentée")){

                LocalBd.myVoituresAccident.add(voiture);
            }

        }

    }

    public static void initVoitureEnPanneDatas(){

        for (Voiture voiture:LocalBd.myVoitures)
        {
            if(voiture.getStatut().equalsIgnoreCase("En panne")){

                LocalBd.myVoituresEnPanne.add(voiture);
            }

        }

    }


   public static void initDatas(){
        myVoitures = new ArrayList<>();

        myVoitures.add(new Voiture("NO0000","null","ML360","ML360",null, new Date(),null,2,2,4522,452,"Essence","En panne",77));
        myVoitures.add(new Voiture("CE584","null","DF360","DF360",null,null,null,2,2,4522,452,"Essence","Accidentée",77));
        myVoitures.add(new Voiture("LT762","null","HG550","HG550",null,null,null,2,2,4522,452,"Essence","Déplacement",77));
        myVoitures.add(new Voiture("NO952","null","KJ560","KJ560",null,null,null,2,2,4522,452,"Essence","Hors service",77));
        myVoitures.add(new Voiture("NW214","null","MG520","MG520",null,null,null,2,2,4522,452,"Essence","Hors service",77));
        myVoitures.add(new Voiture("NW8530000","null","JH360","JH360",null,null,null,2,2,4522,452,"Essence","En panne",77));
        myVoitures.add(new Voiture("SW853","null","YV560","YV560",null,null,null,2,2,4522,452,"Essence","Disponible",77));
        myVoitures.add(new Voiture("EN853","null","UT260","UT260",null,null,null,2,2,4522,452,"Essence","En panne",77));
        myVoitures.add(new Voiture("ES658","null","MB520","MB520",null,null,null,2,2,4522,452,"Essence","Accidentée",77));
        myVoitures.add(new Voiture("OU485","null","MIY560","MIY560",null,null,null,2,2,4522,452,"Essence","Disponible",77));
        myVoitures.add(new Voiture("CE258","null","MZ520","MZ520",null,null,null,2,2,4522,452,"Essence","Disponible",77));
        myVoitures.add(new Voiture("AD325","null","OI260","OI260",null,null,null,2,2,4522,452,"Essence","En panne",77));
        myVoitures.add(new Voiture("AD956","null","MGF60","MGF60",null,null,null,2,2,4522,452,"Essence","Déplacement",77));
        myVoitures.add(new Voiture("EN953","null","M5260","M5260",null,null,null,2,2,4522,452,"Essence","Déplacement",77));
        myVoitures.add(new Voiture("IT856","null","JH260","JH260",null,null,null,2,2,4522,452,"Essence","Déplacement",77));
        myVoitures.add(new Voiture("NO485","null","KM20","KM20",null,null,null,2,2,4522,452,"Essence","En panne",77));
        myVoitures.add(new Voiture("LT756","null","AG60","AG60",null,null,null,2,2,4522,452,"Essence","Déplacement",77));
    }


}
