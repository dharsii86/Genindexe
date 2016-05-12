/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.OrderDB;
import java.util.HashMap;
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
    
    public static void add(SpecieCategory cat){
        categoryList.put(cat.getName(),cat);
    }
    
    public static HashMap getCategory(){
        return categoryList;
    }
    
}
