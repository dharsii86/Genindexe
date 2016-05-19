package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import nf.*;
/**
 * This class manage the static list of orders.
 * It is used to access order objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class OrderData {
    
    // Hashmap of order objects, the key is the order id (as a string).
    private static HashMap<String,SpecieCategory> categoryList;

    
    /**
     * Getter for the static hashmap of orders.
     * 
     * @return The hashmap containing order objects.
     */
    public static HashMap getCategories(){
        return(categoryList);
    }
    
    /**
     * Function that return the list of species that are parts of a category.
     * It use the inner methods of order objects to return the set of species.
     * The result is converted to String array before return.
     * 
     * @param cat The category of species
     * @return The list of species as a String array
     */
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