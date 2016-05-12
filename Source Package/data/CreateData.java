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
    
    private static boolean possibilityToCreate = false;
    
    //private static HashMap<String,SpecieCategory> categoryList;

    
    
    public static void createAllInfo(){
        //create order
        /*
        1- Category
        2- Species
        3- Analysis
        */
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
                SpeciesList.add(sp);
                category.addSpecie(sp);
            }
            //Add the object category
            CategoryList.add(category);
        }
        
    }
    
    
    
    
    
    
    /**
     * Creation of the Category hashmap from the database
     * 
     */
    public static void create(){
        
        categoryList= new HashMap();
        String[] catList = database.OrderDB.getCategory();
        for (String cat: catList){
            // creation of the new category
            SpecieCategory category = new SpecieCategory(cat);
            
            String[] specList = database.OrderDB.getSpecies(cat);
            for(String spec : specList){
                
                category.addSpecie(new Specie(spec));
                
            }
         categoryList.put(category.getName(),category);
        }
    }
    
    public static HashMap getCategories(){
        return(categoryList);
    }
    
    public String[] getListSpecieFromCat(String cat){
	ArrayList<String> res = new ArrayList<>();
	SpecieCategory sCat = categoryList.get(cat);
        Set<Specie> setSpe = sCat.getSpecies();
        List<Specie> list = new ArrayList<>(setSpe);
        for (Specie list1 : list) {
            res.add(list1.getName());
        }
        String[] result = new String[ res.size() ];
        return res.toArray( result );
    }
}


