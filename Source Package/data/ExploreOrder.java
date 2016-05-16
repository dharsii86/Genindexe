/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.ConnectionDB;
import java.util.ArrayList;

/**
 *
 * @author willa
 */
public class ExploreOrder {
    
    public static ArrayList getOrderList(String Customer_Login){
        return ConnectionDB.requestStatic("select Order_Id from `order` where (Customer_Login = '"+Customer_Login+"');");
    }
    
    public static String getAnalysisName(int OrderID){
        return ConnectionDB.requestOneResult("select `Analysis_Name` from `order` where (`Order_Id`="+OrderID+")");
    }
    
    public static String getOrderStatus(int OrderID){
        return ConnectionDB.requestOneResult("select `Order_Status` from `order` where (`Order_Id`="+OrderID+")");
    }
    
    public static int getTotalAnalysis(){
        return Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `order` WHERE (`Order_Status`='Done')"));
    } 
    
    public static int getAnalysisDone(int OrderID){
        return Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `order` WHERE (`Order_Status`='Done' AND `Order_Id`="+OrderID+");"));
    }
          
}
