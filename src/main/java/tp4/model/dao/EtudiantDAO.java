package tp4.model.dao;
import tp4.model.beans.Etudiant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//DAO (Data Access Object) pour le bean Etudiant.
/*
* On va ranger dans cette classe tout le code permettant de faire le lien avec
la table Etudiant dans notre base de données. Pour cela, on va extensivement utiliser
* notre bean Etudiant.
*
* On va retrouver dans le DAO les méthodes abstraites du template DAO<T>:
* - find - encapsule des SELECT
* - create - encapsule un INSERT
* - update - encapsule un UPDATE
* - delete - encapsule un requete DELETE
*
* On trouvera très souvent plusieurs méthodes find() qui permettront de faire des
requetes diverses
* (Select...) sur la BDD.
*
*/

// Herite de la classe abstraite DAO<Etudiant>
public class EtudiantDAO extends DAO<Etudiant> {

    // Recherche d'un étudiant_____________________________________________________________________

    //Premiere méthode find. Renvoie un Etudiant, connaissant son identifiant.
    @Override
    public Etudiant find(long id) {

        Etudiant etud = new Etudiant();

        try {

            Statement stmt = connect.createStatement();
            // TODO : écrire la requête SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM etudiant WHERE id="+id);

            while (rs.next()) { // Tant que j'ai des résultats (mais normalement y'en a qu'un)

                //Je récupère les données de ma base
                int bd_id = rs.getInt("id");
                String bd_nom = rs.getString("Nom");
                String bd_prenom = rs.getString("Prenom");
                String bd_filiere = rs.getString("fil");

                //Et je remplis mon objet etud avec les données récupérée depuis la BDD
                etud.setId(bd_id);
                etud.setNom(bd_nom);
                etud.setPrenom(bd_prenom);
                etud.setFiliere(bd_filiere);
            }
            return etud;
        }
        catch (Exception e) {
            System.out.println("EtudiantDAO: find() failed:"+e.getLocalizedMessage());
        }
        return null;
    }



    // Ajout d'un étudiant_________________________________________________________________________

    // Je prends en paramètre l'objet Etudiant qui contient les informations à insérer.
    @Override
    public Etudiant create(Etudiant obj) {

        String nom = Etudiant.getNom();
        String prenom = Etudiant.getPrenom();
        String filiere = Etudiant.getFiliere();

        try {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO etudiant (Nom, Prenom, fil) VALUES (?, ?, ?)");
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, filiere);
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    //_____________________________________________________________________________________________
    // TODO: reprendre le créate pour cette fois mettre à jour un étudiant et le retourner.
    @Override
    public Etudiant update(Etudiant obj) {
        try {
            Statement stmt = connect.createStatement();
            String sql = "UPDATE etudiant SET fil = Littéraire WHERE id = 4";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }



    //_____________________________________________________________________________________________
    //TODO: reprendre le create pour effacer un étudiant (on ne le retourne pas du coup)
    @Override
    public void delete(Etudiant obj) {
        try {
            Statement stmt = connect.createStatement();
            String sql = "DELETE FROM etudiant WHERE id = 6";
            stmt.execute(sql);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}