package data;

import java.util.HashMap;
import nf.Sample;

/**
 * This class manage the static list of samples.
 * It is used to access categories objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class SampleList {
    // Static Hashmap of samples, the key is the sample id (in database)
    private static HashMap<Integer,Sample> sampleList;
 
    /**
     * Initialisation of the sample hashmap.
     */
    public static void launchSampleList(){
        SampleList.sampleList = new HashMap<>();
    }
 
     /**
     * Print the categories in the list and their information.
     * This function is used for debug.
     */
    public static void printInfoDebug(){
        System.out.println("List order ");
        for(int k : sampleList.keySet()){
            System.out.println("order n° "+k);
        }
    }
    
    /**
     * Insert a new sample only in the application
     * 
     * @param id The id of the sample in database
     * @param spl The sample object to add.
     */
    public static void put(int id,Sample spl  ){  
        sampleList.put(id, spl);
    }
    
    /**
     * Getter for hashmap  elements of the sample list.
     * 
     * @param id The id of the sample
     * @return The sample object
     */
    public static Sample get(int id){
        return sampleList.get(id);
    }

}

