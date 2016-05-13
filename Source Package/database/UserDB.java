package database;

/**
 *
 * @author thoma
 */
public class UserDB {

    /**
     * UserDB class constructor.
     */
    public UserDB() {
    }

    /**
     * Add a user in the database.
     *
     * @param login, the login of the user user to add.
     * @param password, the password of the user to add.
     * @param mail, the mail of the user to add.
     * @param name, the name of the user to add.
     * @param lastName, the last name of the user to add.
     * @param status, the status of the user to add.
     * @return true if the customer is added and false if not.
     */
    public static boolean addUser(String login, String password, String mail, String name, String lastName, String status) {

        if (UserDB.checkUserDuplicates(login)) {

            ConnectionDB.requestInsert("insert into `User` (`User_Login`, `User_Password`, `User_Name`, `User_LastName`, `Status_Name`) "
                    + "values ('" + login + "', '" + password + "', '" + mail + "', '" + name + "', '" + lastName + "', '" + status + "')");
            System.out.println("The customer has been added to the database");
            return true;
        }
        System.out.println("This customer already exist in the database");
        return false;
    }

    /**
     * Check if the customer has a duplicate in the database.
     *
     * @param login, the login of the user to check.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkUserDuplicates(String login) {

        if (login != null) {

            String log = login.toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `User` where `User_Login` = '" + log + "'"));

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
