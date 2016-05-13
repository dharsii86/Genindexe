package database;

import java.util.ArrayList;
import nf.SpecieCategory;

/**
 *
 * @author thoma
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
        
        if (CategoryDB.checkCategoryDuplicates(cat)) {
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
    
    public ArrayList getListCategory()
    {
        ArrayList results;
        results = ConnectionDB.requestStatic("select * from category");
        return results;
    }

}
