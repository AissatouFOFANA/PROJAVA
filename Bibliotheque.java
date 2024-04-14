//package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;
    

    // Constructeur
    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    // Méthode pour supprimer un livre de la bibliothèque
    public void supprimerLivre(Livre livre) {
        listeLivres.remove(livre);
    }

    // Méthode pour rechercher un livre par titre, auteur ou ISBN
    public Livre rechercherLivre(String termeRecherche) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equals(termeRecherche) || livre.getAuteur().equals(termeRecherche) || livre.getISBN().equals(termeRecherche)) {
                return livre;
            }
        }
        return null;
    }

  

  // Méthode pour enregistrer l'emprunt d'un livre par un utilisateur
  public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
    if (empruntsUtilisateurs.containsKey(utilisateur)) {
        empruntsUtilisateurs.get(utilisateur).add(livre);
    } else {
        ArrayList<Livre> livresEmpruntes = new ArrayList<>();
        livresEmpruntes.add(livre);
        empruntsUtilisateurs.put(utilisateur, livresEmpruntes);
    }
}

// Méthode pour enregistrer le retour d'un livre par un utilisateur
public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
    if (empruntsUtilisateurs.containsKey(utilisateur)) {
        empruntsUtilisateurs.get(utilisateur).remove(livre);
    }
}




    // Méthode pour vérifier l'éligibilité d'un utilisateur à emprunter un livre
    public boolean verifierEligibilite(Utilisateur utilisateur) {
        
        return true; // Retourne vrai pour l'exemple
    }

    // Méthode pour afficher les statistiques de la bibliothèque
    public void afficherStatistiques() {
        int totalLivres = listeLivres.size();
        int totalEmprunts = 0;
        for (ArrayList<Livre> livresEmpruntes : empruntsUtilisateurs.values()) {
            totalEmprunts += livresEmpruntes.size();
        }
        System.out.println("Nombre total de livres: " + totalLivres);
        System.out.println("Nombre total d'exemplaires empruntés: " + totalEmprunts);
    }


    public Utilisateur rechercherUtilisateur(String identifiant) {
        // Parcourir la liste des utilisateurs pour trouver celui correspondant à l'identifiant
        for (Utilisateur utilisateur : empruntsUtilisateurs.keySet()) {
            if (utilisateur.getNumeroIdentification().equals(identifiant)) {
                return utilisateur;
            }
        }
        // Si aucun utilisateur correspondant n'est trouvé, afficher un message
        System.out.println("Utilisateur introuvable !!!");
    
        return null;
    }





    // Méthode pour afficher les livres empruntés par un utilisateur
public void afficherLivresEmpruntes(Utilisateur utilisateur) {
    ArrayList<Livre> livresEmpruntes = empruntsUtilisateurs.getOrDefault(utilisateur, new ArrayList<>());
    if (!livresEmpruntes.isEmpty()) {
        System.out.println("Livres empruntés par " + utilisateur.getNom() + " :");
        for (int i = 0; i < livresEmpruntes.size(); i++) {
            System.out.println((i + 1) + ". " + livresEmpruntes.get(i));
        }
    } else {
        System.out.println("Aucun livre emprunté par " + utilisateur.getNom());
    }
}



public ArrayList<Livre> getListeLivres() {
    return listeLivres;
}

//////////////////////////////////////////////////////////////////////////////////////////////////


}
    

