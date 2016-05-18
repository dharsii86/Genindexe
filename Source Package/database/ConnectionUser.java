
package database;

/**
 * This class contain the functions to manage the users' connection. The goal is to manage the
 * interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
 */
public class ConnectionUser {
    
    /**
     * Check if the user can connect.
     *
     * @param login, the login of the user to check.
     * @param mdp, the password of the user to check.
     * @return true if the user can connect and false if not.
     */
    public static boolean checkMDP(String login, String mdp){
    
        int Correct;
        Correct = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `user` where `User_Login` =  '" + login + "' and `User_Password` = '" + mdp + "'"));
        if (Correct == 1) {
            return true;
        } 
        else {
            return false;
        }
            
    }
    
    /**
     * Return the status of a user.
     *
     * @param login, the login of the user to check.
     * @param mdp, the password of the user to check.
     * @return the status of the user.
     */
    public String getStatus(String login, String mdp){
        return ConnectionDB.requestOneResult("select  `Status_Name` from `user` where `User_Login` ='"+login+"' and `User_Password` = '"+mdp+"'");
    }
    
    /**
     * Return the name of a user.
     *
     * @param login, the login of the user to check.
     * @param mdp, the password of the user to check.
     * @return the name of the user.
     */
    public String getName(String login, String mdp){
        return ConnectionDB.requestOneResult("select  `User_Name` from `user` where `User_Login` ='"+login+"' and `User_Password` = '"+mdp+"'");
    }
    
    /**
     * Return the last name of a user.
     *
     * @param login, the login of the user to check.
     * @param mdp, the password of the user to check.
     * @return the last name of the user.
     */
    public String getLastName(String login, String mdp){
        return ConnectionDB.requestOneResult("select  `User_LastName` from `user` where `User_Login` ='"+login+"' and `User_Password` = '"+mdp+"'");
    }
    
}
