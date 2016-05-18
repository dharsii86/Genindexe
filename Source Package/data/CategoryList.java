package data;

import database.CategoryDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import nf.Specie;
import nf.SpecieCategory;

/**
 * This class manage the static list of categories.
 * It is used to access categories objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class CategoryList {
    
    // The Static hashmap of categories
    private static HashMap<String, SpecieCategory> categoryList;

    
    /**
     * Initialise the static list of the categories.
     */
    public static void launchCategoryList(){
        CategoryList.categoryList = new HashMap<>();
    }
    
    /**
     * Insert a new specie category in the list and in the database.
     * 
     * @param cat, the category to insert. 
     * @return Success or fail of the insertion.
     */
    public static boolean add(SpecieCategory cat){        
        if(CategoryDB.addCategory(cat)){
            categoryList.put(cat.getName(),cat);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Return the SpecieCategory using the category name.
     * 
     * @param categoryName, the name of the category to retrieve. 
     * @return the SpecieCategory to retrieve.
     */
    public static SpecieCategory getCategory(String categoryName){
        return categoryList.get(categoryName);
    }
    
    /**
     * Return the list of categories in a HashMap.
     * 
     * @return the HashMap containing the categories.
     */
    public static HashMap getCategory(){
        return categoryList;
    }
    
    /**
     * Return the list of categories in a String table.
     * 
     * @return the String[] containing the categories.
     */
    public static String[] getCategoryList(){
        Set<String> catSet = categoryList.keySet();
        String[] catlist = catSet.toArray( new String[catSet.size()] );
        return catlist;
    }
    
    /**
     * Print the categories in the list and their information.
     * This function is used for debug.
     */
    public static void printInfoDebug(){
        System.out.println("Category Information ");
        for (String k : categoryList.keySet()) {
            System.out.println("category : "+k);
        }
    }
    
    /**
     * Insert a new specie category only in the application
     * 
     * @param cat, the category to insert.
     */
    public static void put(SpecieCategory cat){
        categoryList.put(cat.getName(),cat);
    }
    
    /**
     * Return the list of specie of a category.
     * 
     * @param cat, the category to retrieve the species from.
     * @return 
     */
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

