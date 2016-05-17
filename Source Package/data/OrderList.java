/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.OrderDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import nf.Order;

/**
 *
 * @author DharSii
 */
public class OrderList {
    private static HashMap<Integer,Order> orderList;
    //la clé est l'id dans la DB

    public static void launchOrderList(){
        OrderList.orderList = new HashMap<>();
    }
    
    
    public static boolean add(Order ord){
        return false;
    }

    public static void printInfoDebug(){
        System.out.println("List order ");
        for(int k : orderList.keySet()){
            System.out.println("order n° "+k);
        }
    }
    
    public static void put(int id,Order ord  ){  
        orderList.put(id, ord);
    }
    
    public static Order getOrder(int id){
        return orderList.get(id);
    }
   
}
