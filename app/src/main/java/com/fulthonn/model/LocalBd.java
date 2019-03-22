package com.fulthonn.model;

import android.media.Image;
import android.net.Uri;

import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;
import java.util.Date;

public final class LocalBd {
    public static ArrayList<Personne> personnes;
    public static ArrayList<Voiture> myVoitures;
    public static ArrayList<Model>myModels;
    public static ArrayList<Categorie>myCategories;
    public static ArrayList<Voiture> myVoituresEnPanne=new ArrayList<>();
    public static ArrayList<Voiture> myVoituresAccident=new ArrayList<>();
    public static int nombreTotal;

    public void add(Personne personne)
    {
        personnes.add(personne);
    }

    public void remove(Personne personne)
    {
        personnes.remove(personne);
    }


    public static int getNombreTotalVoiture()
    {
        initDatas();
         return myVoitures.size();
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

    public static void initCategories(){
        myCategories=new ArrayList<>();
        myCategories.add(new Categorie("Aberth",R.drawable.abarth));
        myCategories.add(new Categorie("Alfer_Romeo",R.drawable.alfaromeo));
        myCategories.add(new Categorie("Audi",R.drawable.audi));
        myCategories.add(new Categorie("Bentley",R.drawable.bentley));
        myCategories.add(new Categorie("BMW",R.drawable.bmw));
        myCategories.add(new Categorie("Chevrolet",R.drawable.chevrolet));
        myCategories.add(new Categorie("Dodge",R.drawable.dodge));
        myCategories.add(new Categorie("Fiat",R.drawable.fiat));
        myCategories.add(new Categorie("Ford",R.drawable.ford));
        myCategories.add(new Categorie("Honda",R.drawable.honda));
        myCategories.add(new Categorie("Hyundai",R.drawable.hyundai));
        myCategories.add(new Categorie("Citroen",R.drawable.citroen));
        myCategories.add(new Categorie("Daewoo",R.drawable.daewoo));
        myCategories.add(new Categorie("ISUZU",R.drawable.isuzu));
        myCategories.add(new Categorie("Jaguar",R.drawable.jaguar));
        myCategories.add(new Categorie("Jeep",R.drawable.jeep));
        myCategories.add(new Categorie("KIA",R.drawable.kia));
        myCategories.add(new Categorie("Lamborghnini",R.drawable.lamborghini));
        myCategories.add(new Categorie("Lancia",R.drawable.lancia));
        myCategories.add(new Categorie("Leaf",R.drawable.leaf));
        myCategories.add(new Categorie("Mazda",R.drawable.mazda));
        myCategories.add(new Categorie("Mitsubishi",R.drawable.mitsubishi));
        myCategories.add(new Categorie("Nissan",R.drawable.nissan));
        myCategories.add(new Categorie("Opel",R.drawable.opel));
        myCategories.add(new Categorie("Peugeot",R.drawable.peugeot));
        myCategories.add(new Categorie("Renault",R.drawable.renault));
        myCategories.add(new Categorie("Seat",R.drawable.seat));
        myCategories.add(new Categorie("Skoda",R.drawable.skoda));
        myCategories.add(new Categorie("Toyota",R.drawable.toyota));
        myCategories.add(new Categorie("Volkswagen",R.drawable.volkswagen));
        myCategories.add(new Categorie("Volvo",R.drawable.volvo));

    }

    public static ArrayList<Model> initModelDatas(){
        myModels=new ArrayList<>();
        myModels.add(new Model("ML360",null,"Toyota"));
        myModels.add(new Model("TV608",null,"BMW"));
        myModels.add(new Model("AF628",null,"Volvo"));
        myModels.add(new Model("HP325",null,"Skoda"));
        myModels.add(new Model("JN785",null,"Seate"));
        myModels.add(new Model("AT865",null,"Renault"));
        myModels.add(new Model("AB915",null,"Albert"));
        myModels.add(new Model("ANK85",null,"Bentley"));
        myModels.add(new Model("WYI75",null,"Alfer_Romeo"));
        myModels.add(new Model("ABT92",null,"Audi"));
        myModels.add(new Model("LG255",null,"Opel"));
        myModels.add(new Model("ASN45",null,"Nissan"));
        myModels.add(new Model("WHR67",null,"Peugeot"));
        myModels.add(new Model("VYZ97",null,"Ford"));
        myModels.add(new Model("MRS36",null,"Dodge"));
        myModels.add(new Model("MRS84",null,"Dodge"));
        myModels.add(new Model("RDT28",null,"Fiat"));
        myModels.add(new Model("RDT82",null,"Fiat"));
        myModels.add(new Model("BTD75",null,"Volswagen"));
        myModels.add(new Model("BTD96",null,"Volswagen"));
        myModels.add(new Model("CTB35",null,"Honda"));
        myModels.add(new Model("AET36",null,"Hyundai"));
        myModels.add(new Model("AET96",null,"Hyundai"));
        myModels.add(new Model("PTE75",null,"Citroen"));
        myModels.add(new Model("QHU96",null,"Isuzu"));
        myModels.add(new Model("QHU95",null,"Isuzu"));
        myModels.add(new Model("BGT48",null,"Jaguar"));
        myModels.add(new Model("BGT98",null,"Jaguar"));
        myModels.add(new Model("CFT12",null,"Jep"));
        myModels.add(new Model("IUO96",null,"Toyota"));
        myModels.add(new Model("ZST45",null,"Lombaghnini"));
        myModels.add(new Model("CRT26",null,"Kia"));
        myModels.add(new Model("QRV48",null,"Lancia"));
        myModels.add(new Model("QRV95",null,"Lancia"));
        myModels.add(new Model("OYE92",null,"Leaf"));
        myModels.add(new Model("QMU88",null,"Mazda"));
        myModels.add(new Model("QMU18",null,"Mazda"));
        myModels.add(new Model("MHI86",null,"Mitsubishi"));
        myModels.add(new Model("DTY12",null,"Toyota"));
        myModels.add(new Model("ADR75",null,"Toyota"));
        return  myModels;
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
