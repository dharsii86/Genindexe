/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import nf.Analysis;
import nf.Specie;

/**
 *
 * @author DharSii
 */
public class AnalysisDB {
    
    /**
     * Add an Analysis in the database.
     *
     * @param ana, the analysis to add.
     * @return true if the analysis is added and false if not.
     */
    public static boolean addAnalysis(Analysis ana) {
        if (checkAnalysisDuplicates(ana)) {
            ConnectionDB.requestInsert("insert into `analysis` (`Analysis_Name`) values ('" + ana.getName() + "')");
            return true;
        }
        return false;
    }
    
    /**
     * Add the relevant analysis for a specie
     *
     * @param ana, the analysis to add.
     * @return true if the analysis is added and false if not.
     */
    public static boolean addRelevant(Specie spe, Analysis ana) {
        if (checkRelevantDuplicates(spe,ana)) {
            ConnectionDB.requestInsert("insert into `relevant` (`specie_name`,`analysis_name`) values ('" + spe.getName() + "','" + ana.getName() + "')");
            return true;
        }
        return false;
    }
    /**
     * Check if this relevant couple
     *
     * @param spe, the specie to conect to the analysis
     * @param ana, the analysis.
     * @return false if there is duplicate and false if not.
     */
    public static boolean checkRelevantDuplicates(Specie spe, Analysis ana) {
        if ((ana.getName() != null)&&(spe.getName() != null)) {
            String n = ana.getName().toUpperCase();
            String s = spe.getName().toUpperCase();
            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `relevant` where `analysis_name` = '" + n + "' and `specie_name` = '" + s + "'"));
            switch (resultat) {
                case 0:// pas de doublons
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
     * @param ana, the analysis to add.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkAnalysisDuplicates(Analysis ana) {
        if (ana.getName() != null) {
            String n = ana.getName().toUpperCase();
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
    
    public static String[] getAnalysis(String species){
        String req = "SELECT Analysis_Name from relevant WHERE Specie_Name = '"+ species+"'";
        ArrayList<ArrayList> arrayResult; // creating the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
    } 
    
    public static String[] getAnalysis(){
        String req = "SELECT Analysis_Name from analysis";
        ArrayList<ArrayList> arrayResult; // creating the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
    } 
    
    
    public static String[] formatResult(ArrayList<ArrayList> arrayResult){

         // Temporary arraylist, make it easier to extract results from request
         ArrayList<String> tmp = new ArrayList();
         
         for( ArrayList<String> al: arrayResult ){
             //Here we get only one row, which is located at[0]
             tmp.add(al.get(0)); 
         }
        // Initialisation of the String array and conversion of the results
        String[] result = new String[tmp.size()];
        result = tmp.toArray(result);
        
        return(result);
  }
}
