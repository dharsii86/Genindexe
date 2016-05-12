/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import nf.Specie;
import nf.SpecieCategory;

/**
 *
 * @author DharSii
 */
public class CategoryList {
    
    private static HashMap<String,SpecieCategory> categoryList;

    
    public static void launchCategoryList(){
        CategoryList.categoryList = new HashMap<String, SpecieCategory>();
    }
    
    /**
     * Insert a new species category to the application and into the database
     * @param cat 
     */
    public static void add(SpecieCategory cat){
        categoryList.put(cat.getName(),cat);
    }
    
    /**
     * Insert a new species category only on the application
     * @param cat 
     */
    public static void put(SpecieCategory cat){
        categoryList.put(cat.getName(),cat);
    }
    
    public static HashMap getCategory(){
        return categoryList;
    }
    
    public static String[] getListSpecieFromCat(String cat){
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

