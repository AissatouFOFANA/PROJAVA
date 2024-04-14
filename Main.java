 //package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
    {
        // Création de la bibliothèque et des livres
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre1 = new Livre("Harry Potter", "J.K. Rowling", 2001, "9780545069670");
        Livre livre2 = new Livre("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "9782070612855");
        Livre livre3 = new Livre("1984", "George Orwell", 1949, "9780451524935");
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        bibliotheque.ajouterLivre(livre3);

        // Création de quelques utilisateurs
        Utilisateur utilisateur1 = new Utilisateur("Assane", "Gueye2001");
        Utilisateur utilisateur2 = new Utilisateur("Aissatou", "Fofana2003");

        // Enregistrement des emprunts
        bibliotheque.enregistrerEmprunt(utilisateur1, livre1);
        bibliotheque.enregistrerEmprunt(utilisateur1, livre2);
        bibliotheque.enregistrerEmprunt(utilisateur2, livre3);


//FAIRE UN CHOIX ENTRE INTERFACE BIBLIOTHECAIRE OU INTERFACE UTILISATEUR
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENUE DANS NOTRE BIBLIOTHEQUE");
        System.out.println("Qui etes vous?\n 1-Emprunteur\n 2-Bibliothecaire");
        int role= scanner.nextInt();

        switch(role)
        {
            case 1:
                // Demander l'identifiant de l'utilisateur emprunteur

                System.out.println("Veuillez entrer votre identifiant : ");
                String identifiant = scanner.nextLine();
                String ident= scanner.nextLine();
                System.out.println("Identifiant Utilisateur "+ ident);
                // Vérifier l'éligibilité de l'utilisateur
//                Utilisateur utilisateur = bibliotheque.rechercherUtilisateur(identifiant);
                Utilisateur utilisateur=null;
                if (utilisateur1.verifierIdentifiant(ident)) {
                    utilisateur = utilisateur1;
                } else if (utilisateur2.verifierIdentifiant(ident)) {
                    utilisateur = utilisateur2;
                }
                if (utilisateur != null && bibliotheque.verifierEligibilite(utilisateur))
                {
                    System.out.println("Bienvenue, " + utilisateur.getNom() + "!");

                    // Afficher la liste des livres empruntés par l'utilisateur
                    System.out.println("Voici la liste des livres que vous avez empruntés :");
                    System.out.println("\n");
                    bibliotheque.afficherLivresEmpruntes(utilisateur);

                    // Demander ce que l'utilisateur souhaite faire
                    System.out.println("\n");
                    System.out.println("Que désirez-vous faire ? \n1-> Rendre un livre\n 2-> Emprunter un livre)");
                    int choix = scanner.nextInt();
                    switch (choix) {
                        case 1:
                            // Rendre un livre
                            System.out.println("Veuillez entrer le titre du livre que vous souhaitez rendre : ");
                            scanner.nextLine(); // Pour consommer le saut de ligne restant
                            String titreRendre = scanner.nextLine();
                            Livre livreRendre = bibliotheque.rechercherLivre(titreRendre);
                            if (livreRendre != null) {
                                bibliotheque.enregistrerRetour(utilisateur, livreRendre);
                                bibliotheque.ajouterLivre(livreRendre);
                                System.out.println("Livre rendu avec succès.");
                                System.out.println("MERCI DE VOTRE FIDELITE");
                            } else {
                                System.out.println("Livre non trouvé dans la bibliothèque.");
                            }
                            // Afficher la nouvelle liste des livres empruntés par l'utilisateur
                            System.out.println("Voici la nouvelle liste des livres que vous avez empruntés :");
                            System.out.println("\n");
                            bibliotheque.afficherLivresEmpruntes(utilisateur);

                            break;

                        case 2:
                            // Emprunter un livre
                            System.out.println("Veuillez entrer le titre du livre que vous souhaitez emprunter : ");
                            scanner.nextLine(); // Pour consommer le saut de ligne restant
                            String titreEmprunter = scanner.nextLine();
                            Livre livreEmprunter = bibliotheque.rechercherLivre(titreEmprunter);
                            if (livreEmprunter != null) {
                                bibliotheque.enregistrerEmprunt(utilisateur, livreEmprunter);
                                bibliotheque.supprimerLivre(livreEmprunter);
                                System.out.println("Emprunt enregistré avec succès.");
                                System.out.println("BONNE LECTURE A VOUS");
                            } else {
                                System.out.println("Livre non trouvé dans la bibliothèque.");
                            }
                            // Afficher la nouvelle liste des livres empruntés par l'utilisateur
                            System.out.println("Voici la nouvelle liste des livres que vous avez empruntés :");
                            System.out.println("\n");
                            bibliotheque.afficherLivresEmpruntes(utilisateur);

                            break;

                        default:
                            System.out.println("Choix invalide.");
                    }
                }
                break;
            case 2:
                boolean continuer = true;
                while (continuer)
                {
                    System.out.println("Que souhaitez-vous faire ?");
                    System.out.println("1. Ajouter un nouveau livre");
                    System.out.println("2. Supprimer un livre de la bibliothèque");
                    System.out.println("3. Enregistrer un emprunt");
                    System.out.println("4. Enregistrer un retour d'emprunt");
                    System.out.println("5. Ajouter un nouvel utilisateur");
                    System.out.println("0. Quitter");

                    int choix = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer le saut de ligne

                    switch (choix) {
                        case 1:
                            System.out.println("Entrez le titre du livre :");
                            String titre = scanner.nextLine();
                            System.out.println("Entrez l'auteur du livre :");
                            String auteur = scanner.nextLine();
                            System.out.println("Entrez l'année de publication du livre :");
                            int annee = scanner.nextInt();
                            scanner.nextLine(); // Pour consommer le saut de ligne
                            System.out.println("Entrez l'ISBN du livre :");
                            String ISBN = scanner.nextLine();

                            Livre nouveauLivre = new Livre(titre, auteur, annee, ISBN);
                            bibliotheque.ajouterLivre(nouveauLivre);
                            System.out.println("Livre ajouté avec succès !");
                            break;

                        case 2:
                            System.out.println("Entrez le titre, l'auteur ou l'ISBN du livre à supprimer :");
                            String termeRecherche = scanner.nextLine();
                            Livre livreASupprimer = bibliotheque.rechercherLivre(termeRecherche);
                            if (livreASupprimer != null) {
                                bibliotheque.supprimerLivre(livreASupprimer);
                                System.out.println("Livre supprimé avec succès !");
                            } else {
                                System.out.println("Livre non trouvé !");
                            }
                            break;


                    case 3:
                        System.out.println("Veuillez entrer votre identifiant : ");
//                        String identifiants = scanner.nextLine();
                        String identi= scanner.nextLine();
//                        System.out.println("Identifiant Utilisateur "+ identi);
                        // Vérifier l'éligibilité de l'utilisateur
//                Utilisateur utilisateur = bibliotheque.rechercherUtilisateur(identifiant);
                        Utilisateur utilisateurs=null;
                        if (utilisateur1.verifierIdentifiant(identi)) {
                            utilisateurs = utilisateur1;
                        } else if (utilisateur2.verifierIdentifiant(identi)) {
                            utilisateurs = utilisateur2;
                        }
                        if (utilisateurs != null && bibliotheque.verifierEligibilite(utilisateurs))
                        {
                            System.out.println("Veuillez entrer le titre du livre que vous souhaitez emprunter : ");
                            //scanner.nextLine(); // Pour consommer le saut de ligne restant
                            String titreEmprunter = scanner.nextLine();
                            Livre livreEmprunter = bibliotheque.rechercherLivre(titreEmprunter);
                            if (livreEmprunter != null) {
                                bibliotheque.enregistrerEmprunt(utilisateurs, livreEmprunter);
                                bibliotheque.supprimerLivre(livreEmprunter);
                                System.out.println("Emprunt enregistré avec succès.");
                            } else {
                                System.out.println("Livre non trouvé dans la bibliothèque.");
                            }
                            /*  Afficher la nouvelle liste des livres empruntés par l'utilisateur
                            System.out.println("Voici la nouvelle liste des livres que vous avez empruntés :");
                            System.out.println("\n");
                            bibliotheque.afficherLivresEmpruntes(utilisateurs);
                            */
                        }
//                    bibliotheque.enregistrerEmprunt(utilisateur, bibliotheque.getListeLivres().get(0));
                    System.out.println("Emprunt enregistré avec succès !");
                    break;

                    case 4:
                        System.out.println("Veuillez entrer votre identifiant : ");
//                        String identifiants = scanner.nextLine();
                        String identif= scanner.nextLine();
//                        System.out.println("Identifiant Utilisateur "+ identi);
                        // Vérifier l'éligibilité de l'utilisateur
//                Utilisateur utilisateur = bibliotheque.rechercherUtilisateur(identifiant);
                        Utilisateur util=null;
                        if (utilisateur1.verifierIdentifiant(identif)) {
                            util = utilisateur1;
                        } else if (utilisateur2.verifierIdentifiant(identif)) {
                            util = utilisateur2;
                        }
                        if (util != null && bibliotheque.verifierEligibilite(util))
                        {
                            bibliotheque.afficherLivresEmpruntes(util);
                            System.out.println("Veuillez entrer le titre du livre que vous souhaitez rendre : ");
                            //scanner.nextLine(); // Pour consommer le saut de ligne restant
                            String titreRendre = scanner.nextLine();
                            Livre livreRendre = bibliotheque.rechercherLivre(titreRendre);
                            if (livreRendre != null) {
                                bibliotheque.enregistrerRetour(util, livreRendre);
                                bibliotheque.ajouterLivre(livreRendre);
                                System.out.println("Livre rendu avec succès.");
                            } else {
                                System.out.println("Livre non trouvé dans la bibliothèque.");
                            }
                            /*  Afficher la nouvelle liste des livres empruntés par l'utilisateur
                            System.out.println("Voici la nouvelle liste des livres que vous avez empruntés :");
                            System.out.println("\n");
                            bibliotheque.afficherLivresEmpruntes(utilisateurs);
                            */
                        }
//                    bibliotheque.enregistrerRetour(utilisateur, bibliotheque.getListeLivres().get(0));
                    System.out.println("Retour d'emprunt enregistré avec succès !");
                    break;
                        case 5:
                            // Ajout d'un nouvel utilisateur
                            System.out.println("Entrez le nom de l'utilisateur :");
                            String nomUtilisateur = scanner.nextLine();
                            System.out.println("Entrez le numéro d'identification de l'utilisateur :");
                            String numeroIdentification = scanner.nextLine();

                            Utilisateur nouvelUtilisateur = new Utilisateur(nomUtilisateur, numeroIdentification);
                            System.out.println("Nouvel utilisateur ajouté avec succes: " + nouvelUtilisateur.getNom());
                            break;
                        case 0:
                        System.out.println("A BIENTOOOOOT");
                            continuer = false;
                            break;

                        default:
                            System.out.println("Choix invalide !");
                    }
                }
                break;
        }

    }
}