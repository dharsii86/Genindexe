/**
* Class allowing the creation of a new specie.
*/

package screen;

/**
 *
 * @author SCRUM Group 2.
 */
public class SpecieInput {

    /**
     * SpecieInput class constructor.
     */
    public SpecieInput() {
    }

    /**
     * Control the format of a specie name.
     *
     * @param specieName, the name of the specie.
     * @return the name formatted of the specie.
     */
    public static String specieInputContol(String specieName) {

        String speName = specieName.toLowerCase();

        char[] arraySpeName = speName.toCharArray();

        String result = "";

        for (int i = 0; i < arraySpeName.length; i++) {

            if (((int) arraySpeName[i] <= 122
                    && (int) arraySpeName[i] >= 97)
                    || (int) arraySpeName[i] == 32) {
                result += arraySpeName[i];

            }
        }
       
        result = result.trim();
        
        result = result.substring(0, 1).toUpperCase() + result.substring(1);

        return result;
    }
}
