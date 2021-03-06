package database;

import nf.Specie;
import nf.SpecieCategory;

/**
 * This class contain the functions to manage species. The goal is to manage the
 * interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
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
     * @param cat, the category of the specie.
     * @return true if the specie is added and false if not.
     */
    public static boolean addSpecie(Specie spe, SpecieCategory cat) {

        if (SpecieDB.checkSpecieDuplicates(spe)) {

            ConnectionDB.requestInsert("insert into `specie` (`Specie_Name`, `Category_Name`) values ('" + spe.getName() + "', '" + cat.getName() + "')");

            return true;
        }
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

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `specie` where `Specie_Name` = '" + n + "'"));

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
