package database;

import nf.Specie;

/**
 *
 * @author JCGx
 */
public class SpecieDB {

    /**
     * SpecieDB class constructor.
     */
    public SpecieDB() {
    }

    /**
     * Add a specie in the database.
     *
     * @param spe, the specie to add.
     * @return true if the specie is added and false if not.
     */
    //public static boolean addSpecie(Specie spe) {
    //    if (SpecieDB.checkSpecieDuplicates(cust)) {

    //        ConnectionDB.requestInsert("insert into `Customer` (`Customer_Name`, `Customer_Town`) values ('" + cust.getName() + "','" + cust.getTown() + "')");
            //System.out.println("The customer has been added to the database");
    //        return true;
    //    }
        //System.out.println("This customer already exist in the database");
    //    return false;
    //}

    /**
     * Check if the specie has a duplicate in the database.
     *
     * @param spe, the specie to check.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkSpecieDuplicates(Specie spe) {
        return true;
    }

    /**
     * Check if the specie's format is correct.
     *
     * @param spe, the specie to check.
     * @return true if the format is correct and false if not.
     */
    public static boolean checkSpecieFormat(Specie spe) {
        return true;
    }

}
