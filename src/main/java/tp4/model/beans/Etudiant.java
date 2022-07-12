package tp4.model.beans;

public class Etudiant {

    // Définitions d'attributs et de méthodes get/set associées à chaque attribut

    // id :
    public static int id;
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Etudiant.id = id;
    }


    // nom :
    public static String nom;
    public static String getNom() {
        return nom;
    }
    public static void setNom(String nom) {
        Etudiant.nom = nom;
    }


    // prenom :
    public static String prenom;
    public static String getPrenom() {
        return prenom;
    }
    public static void setPrenom(String prenom) {
        Etudiant.prenom = prenom;
    }


    // filière :
    public static String filiere;
    public static String getFiliere() {
        return filiere;
    }
    public static void setFiliere(String filiere) {
        Etudiant.filiere = filiere;
    }

}
