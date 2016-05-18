package database;

import java.util.ArrayList;
import nf.Analysis;
import nf.Specie;

/**
 * This class contain the functions to manage analysis. The goal is to manage
 * the interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
 */
public class AnalysisDB {

    /**
     * Add an analysis in the database.
     *
     * @param an, the analysis to add.
     * @return true if the analysis is added and false if not.
     */
    public static boolean addAnalysis(Analysis an) {
        if (checkAnalysisDuplicates(an)) {
            ConnectionDB.requestInsert("insert into `analysis` (`Analysis_Name`) values ('" + an.getName() + "')");
            return true;
        }
        return false;
    }

    /**
     * Add a relevant analysis for a specie.
     *
     * @param an, the analysis to add.
     * @param spe, the specie of the analysis to add.
     * @return true if the analysis is added and false if not.
     */
    public static boolean addRelevant(Specie spe, Analysis an) {
        if (checkRelevantDuplicates(spe, an)) {
            ConnectionDB.requestInsert("insert into `relevant` (`Specie_Name`, `Analysis_Name`) values ('" + spe.getName() + "', '" + an.getName() + "')");
            return true;
        }
        return false;
    }

    /**
     * Check if an analysis and a specie are relevant.
     *
     * @param spe, the specie to connect to the analysis.
     * @param an, the analysis to add.
     * @return false if there is duplicate and false if not.
     */
    public static boolean checkRelevantDuplicates(Specie spe, Analysis an) {
        if ((an.getName() != null) && (spe.getName() != null)) {
            String n = an.getName().toUpperCase();
            String s = spe.getName().toUpperCase();
            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `relevant` where `Analysis_Name` = '" + n + "' and `Specie_Name` = '" + s + "'"));
            switch (resultat) {
                case 0: // No duplicates
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Check if the analysis has a duplicate in the database.
     *
     * @param an, the analysis to add.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkAnalysisDuplicates(Analysis an) {
        if (an.getName() != null) {
            String n = an.getName().toUpperCase();
            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `analysis` where `Analysis_Name` = '" + n + "'"));
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
     * Return the list of analysis for a specie.
     *
     * @param spe, the specie to check.
     * @return a string table containing the name of the analysis.
     */
    public static String[] getAnalysis(String spe) {
        String req = "select `Analysis_Name` from `relevant` where `Specie_Name` = '" + spe + "'";
        ArrayList<ArrayList> arrayResult; // create the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);

        String[] result = formatResult(arrayResult);

        return (result);
    }

    /**
     * Return the list of all the analysis.
     *
     * @return a string table containing the name of the analysis.
     */
    public static String[] getAnalysis() {
        String req = "select `Analysis_Name` from `analysis`";
        ArrayList<ArrayList> arrayResult; // create the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);

        String[] result = formatResult(arrayResult);

        return (result);
    }

    /**
     * Convert a 2 dimensions ArrayList into a 2 dimensions table of String
     * containing the result of the analysis.
     *
     * @param arrayResult, the 2 dimensions ArrayList.
     * @return a 2 dimensions String table.
     */
    public static String[] formatResult(ArrayList<ArrayList> arrayResult) {

        // Temporary ArrayList, make it easier to extract results from a request
        ArrayList<String> tmp = new ArrayList();

        for (ArrayList<String> al : arrayResult) {
            // Here we get only one row, which is located at[0]
            tmp.add(al.get(0));
        }
        // Initialisation of the String array and conversion of the results
        String[] result = new String[tmp.size()];
        result = tmp.toArray(result);

        return (result);
    }

}
