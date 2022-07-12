package tp4.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// IL EST POSSIBLE DE COPIER COLLER LE CODE DE CETTE CLASSE DANS VOTRE PROJET
// AINSI QUE LA CLASSE TEMPLATE DAO<T>
// VEILLEZ SIMPLEMENT A MODIFIER LES PARAMETRES DE CONNEXION A LA BDD
//Classe unique permettant d'assurer la connexion à la base de données.
// Pas grand chose à changer ici, juste les paramètres de connexion.
// Le pattern singleton représenté ici permet de ne pas avoir à constamment
// créer des connexions vers la BDD.
// vous pouvez vous passer de cette classe si vous vous connectez à chaque fois
// à la BDD dans les différents DAO.
public class MySqlConnection {

    /** * paramètres de connexion: URL de connection et login, pass pour la BDD */
    /* A réutiliser tel quel, juste ces 3 paramètres à changer */
    // il faut garder les paramètres ajoutés en fin d'URL; gardez donc bien ce bout
    // lorsque vous modifier le host, port et nom de Bdd:

    // jdbc:mysql://ipdelhote:numerodeport/nomdelabase?useUnicode=true&useJDBCCompliantTi
    // mezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    private static String url =
            "jdbc:mysql://localhost:3306/cda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String passwd = "29342908";


    /** * Objet Connection */
    private static Connection connect;


    /** * Méthode qui va nous retourner notre instance * et la créer si elle
     n'existe pas... * @return */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}

