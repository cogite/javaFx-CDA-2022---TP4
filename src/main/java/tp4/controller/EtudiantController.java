package tp4.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tp4.model.beans.Etudiant;
import tp4.model.dao.EtudiantDAO;

public class EtudiantController {

    // Rechercher un étudiant______________________________________________________________________

    // Récupération des éléments depuis le FXML (@FXML)
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelFiliere;
    @FXML
    private TextField textfieldSaisie;


    // Méthodes déclenchées par le boutons "fetch !"
    @FXML
    public void fillView(Etudiant e) {
        labelNom.setText(Etudiant.nom);
        labelPrenom.setText(Etudiant.prenom);
        labelFiliere.setText(Etudiant.filiere);
    }
    @FXML
    public void onFetchButtonClicked() {
        int id = Integer.valueOf(textfieldSaisie.getText());
        EtudiantDAO bdEtudiant = new EtudiantDAO();
        fillView(bdEtudiant.find(id));
    }

    // Ajouter un étudiant_________________________________________________________________________

    @FXML
    private TextField addNom;
    @FXML
    private TextField addPrenom;
    @FXML
    private TextField addFiliere;

    @FXML
    public void onAddButtonClicked() {
        Etudiant etudiantToAdd = new Etudiant();
        etudiantToAdd.setNom(String.valueOf(addNom.getText()));
        etudiantToAdd.setPrenom(String.valueOf(addPrenom.getText()));
        etudiantToAdd.setFiliere(String.valueOf(addFiliere.getText()));

        EtudiantDAO bdEtudiant = new EtudiantDAO();
        bdEtudiant.create(etudiantToAdd);

        addNom.setText(null);
        addPrenom.setText(null);
        addFiliere.setText(null);
    }

}