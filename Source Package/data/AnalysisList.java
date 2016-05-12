/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.AnalysisDB;
import java.util.HashMap;
import nf.Analysis;
import nf.Specie;

/**
 *
 * @author DharSii, Quentin Bonenfant
 */
public class AnalysisList {
    private static HashMap<String,Analysis> anaList;

    public static void add(Analysis analysis){
        anaList.put(analysis.getName(),analysis);
    }
    
    public static HashMap getAnalysis(){
        return anaList;
    }
}
