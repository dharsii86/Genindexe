/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.OrderDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import nf.*;
/**
 *
 * @author Quentin Bonenfant
 */
public class CreateData {
    
    private static boolean possibilityToCreate = true;
    
    public static void createAllInfo(){
        //create order
        /*
        1- Category
        2- Species
        3- Analysis
        */
        if(possibilityToCreate){
            CategoryList.launchCategoryList();
            SpeciesList.launchSpeciesList();

            String[] catList = OrderDB.getCategory();
            System.out.println("category Creation");

            for (String cat: catList){
                // creation of the new category
                SpecieCategory category = new SpecieCategory(cat);
                // the object category is created
                String[] specList = OrderDB.getSpecies(cat);// get the species for that category
                //add the species for this category
                for(String spec : specList){
                    Specie sp = new Specie(spec);
                    SpeciesList.put(sp);
                    category.addSpecie(sp);
                }
                //Add the object category
                CategoryList.put(category);
            }
            System.out.println("Creation of all the information");
            possibilityToCreate = false;
        }else{
            System.out.println("All the data are already created");
        }
        
        
    }
    
   
    
    
    
}


