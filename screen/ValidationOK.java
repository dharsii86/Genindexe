package Screen;

import Screen.AutoCloseDialog;

/**
 * Managerthe frame which display the creation of a customer validation.
 *
 * @author SCRUM Group 2.
 */
public class ValidationOK {

    /**
     * ValidationOK class constructor.
     */
    public ValidationOK() {

        AutoCloseDialog.showAutoCloseDialog(null, "Success", "The customer creation is done", 3000L);
    }

}
