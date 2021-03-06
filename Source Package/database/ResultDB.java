package database;

import java.util.ArrayList;
import nf.RawData;
import nf.Result;
import nf.ResultStatus;
import nf.ScrapieResult;
import nf.SexingResult;

/**
 * This class contain the functions to manage results. The goal is to manage the
 * interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
 */
public class ResultDB {

    /**
     * Creation of the result object from the database. The result is fetched
     * using the id from a sample result attribute.
     *
     * @param id, the sample id.
     * @param analysis, the type of analysis.
     * @return the Result object.
     */
    public static Result getResult(int id, String analysis) {
        // initialisation
        Result result = null;
        String request = "Select `RD_pos1`, `RD_val1`, `RD_pos2`, `RD_val2`, `Result_interpretation`, `FirstRead`, `SecondRead`, `Status` "
                + "from `result` where `Result_Id` =  '" + id + "'";
        ArrayList<ArrayList> arrayResult;
        arrayResult = ConnectionDB.requestStatic(request);

        if (arrayResult.size() == 1) {
            ArrayList<String> dbRes = arrayResult.get(0);

            Boolean firstRead = Boolean.parseBoolean(dbRes.get(5));
            Boolean secondRead = Boolean.parseBoolean(dbRes.get(6));
            String status = dbRes.get(7);
            ResultStatus Rstat = ResultStatus.valueOf(status);

            String interpretation = dbRes.get(4);

            int rd_pas1 = Integer.parseInt(dbRes.get(0));
            int rd_pas2 = Integer.parseInt(dbRes.get(2));
            int rd_val1 = Integer.parseInt(dbRes.get(1));
            int rd_val2 = Integer.parseInt(dbRes.get(3));

            RawData rd1 = new RawData(rd_pas1, rd_val1);
            RawData rd2 = new RawData(rd_pas2, rd_val2);

            if (null != analysis) {
                switch (analysis) {
                    case "Scrapie":
                        result = new ScrapieResult();
                        ScrapieResult resultScp = (ScrapieResult) result;
                        resultScp.setScrapieValue(rd1);
                        result = resultScp;
                        break;
                    case "Sexing":
                        result = new SexingResult();
                        SexingResult resultSex = (SexingResult) result;
                        resultSex.setMaleValue(rd1);
                        resultSex.setFemaleValue(rd2);
                        break;
                }
            }

            if (result != null) {
                result.setInterpretation(interpretation);
                if (Rstat == ResultStatus.UNREADABLE) {
                    // unreadable
                    if (secondRead) {
                        result.firstRead(true, interpretation);
                        result.validate(false);
                    } else {
                        result.firstRead(true, null);
                    }
                    result.setStatus(ResultStatus.UNREADABLE);
                } else // readable or in progress
                {
                    if (firstRead) {
                        result.firstRead(true, interpretation);
                        // readable automatically
                        if (secondRead) {
                            result.validate(true);
                            result.setStatus(ResultStatus.VALIDATED);
                        }
                    }
                }
            }
        }
        return (result);
    }

}
