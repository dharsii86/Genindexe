package genindexe;

import screen.MenuWindow;
import data.CreateData;
import database.ConnectionDB;
import screen.connexionInterface;

/**
 * Launch the menu of the application.
 *
 * @author SCRUM Group 2.
 */
public class Main {

    /** Commentaire 9:23
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionDB.changePort();//Ne pas toucher a ca
        
        CreateData.createAllInfo();
        connexionInterface cm = new connexionInterface();
        //MenuWindow m = new MenuWindow();
        
        /*
        String aux = "aaaAaaeE";
        aux = aux.toLowerCase();
        aux = aux.substring(0, 1).toUpperCase() + aux.substring(1);
        System.out.println(aux);
        */
    }

}
