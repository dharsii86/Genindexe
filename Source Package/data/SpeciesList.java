/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.SpecieDB;
 import java.util.HashMap;
 import nf.Specie;
import nf.SpecieCategory;

/**
 *
 * @author DharSii
 */
public class SpeciesList {
  
    private static HashMap<String,Specie> speciesList;

    public static void launchSpeciesList(){
        SpeciesList.speciesList = new HashMap<String, Specie>();
    }
    /**
     * Insert a new species on the application and on the database
     * @param spe 
     */
    public static boolean add(Specie spe,SpecieCategory cat){
        if(SpecieDB.addSpecie(spe, cat)){
            speciesList.put(spe.getName(),spe);
            //printInfoDebug();
            return true;
        }else{
            return false;
        }
            
    }
    
    public static void printInfoDebug(){
        System.out.println("Species Information ");
        for(String k : speciesList.keySet()){
            System.out.println("specie : "+k);
        }
    }
    
    /**
     * Insert a new species only on the application
     * @param cat 
     */
    public static void put(Specie spe){
        speciesList.put(spe.getName(),spe);
    }
    
    
    public static HashMap getSpecies(){
        return speciesList;
    }
}
