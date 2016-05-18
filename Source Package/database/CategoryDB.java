package database;

import java.util.ArrayList;
import nf.SpecieCategory;

/**
 * This class contain the functions to manage categories.
 * The goal is to manage the interface of inputs and outputs.
 * 
 * @author SCRUM Group 2.
 */
public class CategoryDB {

    /**
     * CategoryDB class constructor.
     */
    public CategoryDB() {
    }

    /**
     * Add a category in the database.
     *
     * @param cat, the category to add.
     * @return true if the category is added and false if not.
     */
    public static boolean addCategory(SpecieCategory cat) {
        
        if (checkCategoryDuplicates(cat)) {
            ConnectionDB.requestInsert("insert into `category` (`Category_Name`) values ('" + cat.getName() + "')");
            return true;
        }
        return false;
    }

    /**
     * Check if the category has a duplicate in the database.
     *
     * @param cat, the category to add.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkCategoryDuplicates(SpecieCategory cat) {

        if (cat.getName() != null) {

            String n = cat.getName().toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `category` where `Category_Name` = '" + n + "'"));

            switch (resultat) {
                case 0:
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * Return all the categories of the database in an ArrayList.
     *
     * @return an ArrayList containing the categories.
     */
    public ArrayList getListCategory()
    {
        ArrayList results;
        results = ConnectionDB.requestStatic("select * from category");
        return results;
    }

}
