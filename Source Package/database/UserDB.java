package database;

/**
 * This class contain the functions to manage the users. The goal is to manage the
 * interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
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
     * @return true if the user is added and false if not.
     */
    public static boolean addUser(String login, String password, String mail, String name, String lastName, String status) {

        if (UserDB.checkUserDuplicates(login)) {

            ConnectionDB.requestInsert("insert into `user` (`User_Login`, `User_Password`, `User_Mail`, `User_Name`, `User_LastName`, `Status_Name`) "
                    + "values ('" + login + "', '" + password + "', '" + mail + "', '" + name + "', '" + lastName + "', '" + status + "')");
            System.out.println("The customer has been added to the database");
            return true;
        }
        System.out.println("This customer already exist in the database");
        return false;
    }

    /**
     * Check if the user has a duplicate in the database.
     *
     * @param login, the login of the user to check.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkUserDuplicates(String login) {

        if (login != null) {

            String log = login.toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `user` where `User_Login` = '" + log + "'"));

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
     * Check if the user can connect.
     *
     * @param login, the login of the user to check.
     * @param password, the password of the user to check.
     * @return the status if the user can connect and "none" if not.
     */
    public static String checkUserConnection(String login, String password) {

        if (login != null && password != null) {

            String log = login.toUpperCase();
            String pass = password.toUpperCase();

            if (!checkUserDuplicates(login)) {

                return ConnectionDB.requestOneResult("select `Status_Name` from `user` where `User_Login` = '" + log + "' "
                        + "and `User_Password` = '" + pass + "'");
            }
        }
        return "none";
    }
}
