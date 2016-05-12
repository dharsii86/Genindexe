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
    public static boolean addSpecie(Specie spe) {
        if (SpecieDB.checkSpecieDuplicates(spe)) {

            ConnectionDB.requestInsert("insert into `Specie` (`Specie_Name`) values ('" + spe.getName() + ")");
            //System.out.println("The customer has been added to the database");
            return true;
        }
        //System.out.println("This customer already exist in the database");
        return false;
    }

    /**
     * Check if the specie has a duplicate in the database.
     *
     * @param spe, the specie to check.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkSpecieDuplicates(Specie spe) {
        
        if (spe.getName() != null) {

            String n = spe.getName().toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from Customer where Customer_Name = " + n + "''" ));

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
}
