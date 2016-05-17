package database;

import java.util.ArrayList;
import java.util.HashMap;
import nf.Result;
import nf.ScrapieResult;
import nf.SexingResult;

/**
 * @author Quentin Bonenfant
 */
public class ResultDB {

   
    /**
     * Creation of the result object from the database.
     * The result is feteched using the id from a sample result attribute.
     * @param id the sample id
     * @param analysis The type of analysis
     * @return The result object
     */
    public static Result getResult(int id, String analysis) {
        // initialisation
        Result result = null;
        String request = "SELECT Result_FirstRead, Result_SecondRead, Result_Status, Result_Interpretation, Result_RD_pas_1,Result_RD_pas_2,Result_RD_val_1,Result_RD_val_2 from result where Result_Id =  '"+id+"'";
        ArrayList<ArrayList> arrayResult; 
        arrayResult = ConnectionDB.requestStatic(request); // Creat
        
        if(arrayResult.size()==1){
            ArrayList<String> dbRes= arrayResult.get(0);
            
            Boolean firstRead  = Boolean.parseBoolean( dbRes.get(0) );
            Boolean secondRead = Boolean.parseBoolean( dbRes.get(1) );
            String status = dbRes.get(2);
            String interpretation = dbRes.get(3);
            
            int rd_pas1 = Integer.parseInt(dbRes.get(4));
            int rd_pas2 = Integer.parseInt(dbRes.get(5));
            int rd_val1 = Integer.parseInt(dbRes.get(6));
            int rd_val2 = Integer.parseInt(dbRes.get(7));
                    
            
            if (null != analysis)switch (analysis) {
                
                case "Scrapie":
                    result = new ScrapieResult();
                    break;
                case "Sexing":
                    result = new SexingResult();
                    break;
            }
        }
        return (result);
    }
}