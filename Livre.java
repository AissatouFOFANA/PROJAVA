//package org.example;

public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;

    public Livre(String var1, String var2, int var3, String var4) {
        this.titre = var1;
        this.auteur = var2;
        this.anneePublication = var3;
        this.ISBN = var4;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String var1) {
        this.titre = var1;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String var1) {
        this.auteur = var1;
    }

    public int getAnneePublication() {
        return this.anneePublication;
    }

    public void setAnneePublication(int var1) {
        this.anneePublication = var1;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String var1) {
        this.ISBN = var1;
    }

    public String toString() {
        return "Livre{titre='" + this.titre + "', auteur='" + this.auteur + "', anneePublication=" + this.anneePublication + ", ISBN='" + this.ISBN + "'}";
    }
}
