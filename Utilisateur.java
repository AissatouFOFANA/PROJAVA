//package org.example;

import java.util.ArrayList;

public class Utilisateur {
    
     private String nom;
    private String numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;

    // Constructeur
    public Utilisateur(String nom, String numeroIdentification) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
    }

 // Getter pour le nom
 public String getNom() {
    return nom;
}

// Setter pour le nom
public void setNom(String nom) {
    this.nom = nom;
}

// Getter pour le numéro d'identification
public String getNumeroIdentification() {
    return numeroIdentification;
}

// Setter pour le numéro d'identification
public void setNumeroIdentification(String numeroIdentification) {
    this.numeroIdentification = numeroIdentification;
}

// Getter pour la liste des livres empruntés
public ArrayList<Livre> getLivresEmpruntes() {
    return livresEmpruntes;
}

// Setter pour la liste des livres empruntés
public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes) {
    this.livresEmpruntes = livresEmpruntes;
}






    // Méthode pour emprunter un livre
    public void emprunterLivre(Livre livre) {
        livresEmpruntes.add(livre);
    }

    // Méthode pour retourner un livre
    public void retournerLivre(Livre livre) {
        livresEmpruntes.remove(livre);
    }

    // Méthode pour afficher les livres empruntés par l'utilisateur
    public void afficherLivresEmpruntes() {
        for (Livre livre : livresEmpruntes) {
            System.out.println(livre);
        }
    }
    public boolean verifierIdentifiant(String identifiant) {
        return this.numeroIdentification.equals(identifiant);
    }

}
