/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.HashMap;
import nf.Customer;
import nf.Order;
import nf.OrderStatus;

/**
 * This class contain the necessary functions to manage orders.
 * The goal is to manage the interface inputs and outputs.
 * 
 * @author Quentin Bonenfant
 */
public class OrderDB {

    public static HashMap getOrder(Customer cust){
        HashMap<Integer,Order> resultat = new HashMap<>();
        
        String custId = cust.getName()+cust.getTown();
        ArrayList<ArrayList> res = ConnectionDB.requestStatic("Select `Order_Id`, `Order_Status`, `Analysis_Name`, `Customer_Login` FROM `order`");
        
        for(ArrayList<String> res2 : res){
            Order ord = new Order(cust);
            //ArrayList<ArrayList> listSamp = ConnectionDB.requestStatic("SELECT `Sample_Id`, `Specie_Name`, `result`, `state` FROM `sample` WHERE `Order_Id` = "+res.get(0));
            ord.setStatus(OrderStatus.valueOf(res2.get(1)));
            cust.addOrder(ord);
            resultat.put(Integer.parseInt(res2.get(0)), ord);
                    
        }
        return resultat;
    }
    
    
    /**   
     *  Function to format the results from request containg a string column.  
     *  The results from requestStatic are ArrayList of ArrayList (two dimensional).
     *  That's why we need to extract the values using a for loop
     *  and tmp variable.
     * 
     * @param arrayResult The arraylist to convert in String[]
     * @return The string array containing the result
     */ 
    public static String[] formatResult(ArrayList<ArrayList> arrayResult){

         // Temporary arraylist, make it easier to extract results from request
         ArrayList<String> tmp = new ArrayList();
         
         for( ArrayList<String> al: arrayResult ){
             //Here we get only one row, which is located at[0]
             tmp.add(al.get(0)); 
         }
        // Initialisation of the String array and conversion of the results
        String[] result = new String[tmp.size()];
        result = tmp.toArray(result);
        
        return(result);
  }

}
