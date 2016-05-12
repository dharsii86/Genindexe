/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

 import database.OrderDB;
 import java.util.HashMap;
 import nf.Specie;

/**
 *
 * @author DharSii
 */
public class SpeciesList {
  
    private static HashMap<String,Specie> speciesList;

    public static void add(Specie spe){
        speciesList.put(spe.getName(),spe);
    }
    
    public static HashMap getSpecies(){
        return speciesList;
    }
}