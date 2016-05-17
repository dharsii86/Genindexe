/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import nf.Order;
import nf.Sample;

/**
 *
 * @author DharSii
 */
public class SampleList {
    
    private static HashMap<Integer,Sample> sampleList;
    //la clé est l'id dans la DB

    public static void launchSampleList(){
        SampleList.sampleList = new HashMap<>();
    }
    
    
    
    
    public static boolean add(Sample spl){
        return false;
    }

    public static void printInfoDebug(){
        System.out.println("List order ");
        for(int k : sampleList.keySet()){
            System.out.println("order n° "+k);
        }
    }
    
    public static void put(int id,Sample spl  ){  
        sampleList.put(id, spl);
    }
    
    public static Sample get(int id){
        return sampleList.get(id);
    }

}

