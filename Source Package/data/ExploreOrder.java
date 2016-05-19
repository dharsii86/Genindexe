package data;

import database.ConnectionDB;
import java.util.ArrayList;

/**
 * This class store functions to explore orders in the database.
 * 
 * @author SCRUM Group 2.
 */
public class ExploreOrder {
    
    /**
     * Get the list of order of a specified customer
     * 
     * @param Customer_Login The customer login (concat of name and town)
     * @return The arraylist of order.
     */
    public static ArrayList getOrderList(String Customer_Login){
        return ConnectionDB.requestStatic("select Order_Id from `order` where (Customer_Login = '"+Customer_Login+"');");
    }
    
    /**
     * Get the analysis finished for a specified order
     * 
     * @param OrderID The id of the order
     * @return the number of the analysis performed.
     */
    public static String getAnalysisName(int OrderID){
        // Complex request to get  the number of validated samples results.
        String res=ConnectionDB.requestOneResult("select count(*) from sample JOIN result ON (sample.Result1 = result.Result_Id or sample.Result2 = result.Result_Id or sample.Result3 = result.Result_Id ) where( Order_Id="+ OrderID +" and Status= \"VALIDATED\")");
        return(res);
    }
    
    /**
     * Get the status for a specified order
     * 
     * @param OrderID The id of the order
     * @return The status of the order.
     */
    public static String getOrderStatus(int OrderID){
        return ConnectionDB.requestOneResult("select `Order_Status` from `order` where (`Order_Id`="+OrderID+")");
    }
    
    /**
     * Get the total number of analysis to do for an order 
     * 
     * @param OrderID The id of the order
     * @return the number of analysis to perform on a specific order
     */
    public static int getTotalAnalysis(int OrderID){
        return Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `sample` WHERE (`Order_Id`="+OrderID+")"));
    } 
    
    /**
     * Get the  number of analysis done for an order
     * 
     * @param OrderID The id of the order
     * @return The number of analysis performed.
     */
    public static int getAnalysisDone(int OrderID){
        
        return Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from sample JOIN result on (sample.Result1 = result.Result_Id or sample.Result2 = result.Result_Id or sample.Result3 = result.Result_Id ) where( Order_Id="+OrderID+" and Status= \"VALIDATED\")"));
    }         
}