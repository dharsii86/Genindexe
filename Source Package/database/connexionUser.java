/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author willa
 */
public class connexionUser {
    
    public connexionUser(){
        
    }
    public static boolean checkMDP(String login, String mdp){
    
        int Correct;
        Correct = Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `user` WHERE `User_Login` =  '" + login + "' AND `User_Password` =  '" + mdp + "'"));
        if (Correct == 1){
            return true;
        }
        else{
            return false;
        }
            
    }
    
    public String getStatus(String login, String mdp){
        return ConnectionDB.requestOneResult("SELECT  `Status_Name` FROM `user` WHERE ( `User_Login` ='"+login+"' and `User_Password` ='"+mdp+"' )");
    }
    
}
