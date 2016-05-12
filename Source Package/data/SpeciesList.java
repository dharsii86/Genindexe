/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

 import java.util.HashMap;
 import nf.Specie;

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
    public static void add(Specie spe){
        speciesList.put(spe.getName(),spe);
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