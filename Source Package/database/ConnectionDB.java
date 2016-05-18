package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * Manage the connection to the database.
 *
 * @author SCRUM Group 2.
 */
public class ConnectionDB {

    Connection conn = null; // Set in the constructor, create the connection with the database
    Statement stmt = null;
    ResultSet result = null;
    static String DRIVERCONNECTION_ROAD = "jdbc:mysql://localhost/genindexe";
    static final String DRIVERCONNECTION_USER = "root";
    static final String DRIVERCONNECTION_PWD = "root";
    private static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * ConnexionDB class constructor. Create a connexion to the database.
     */
    public ConnectionDB() {

        try {
            conn = DriverManager.getConnection(DRIVERCONNECTION_ROAD, DRIVERCONNECTION_USER, DRIVERCONNECTION_PWD);
            // connection successful
            stmt = conn.createStatement();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * Allow the connection to the database from a mac.
     */
    public static void changePort() {

        if (OS.indexOf("mac") >= 0) {
            DRIVERCONNECTION_ROAD = "jdbc:mysql://localhost:8889/genindexe";
            System.out.println("This is a MAC");
        }
    }

    /**
     * Allow to perform a request on the database.
     *
     * @param req, the request to perform.
     * @return result, the ResultSet of the request.
     */
    public ResultSet request(String req) {
        try {
            result = stmt.executeQuery(req);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            result = null;
        }
        return result;
    }

    /**
     * Allow to end the connection to the database.
     */
    public void delete() {

        if (result != null) {
            try {
                result.close();
            } catch (SQLException sqlEx) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqlEx) {
            }
        }
    }

    /**
     * Allow to perform a request of insertion on the database.
     *
     * @param req, the request to perform.
     */
    public static void requestInsert(String req) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection(DRIVERCONNECTION_ROAD, DRIVERCONNECTION_USER, DRIVERCONNECTION_PWD);
            // connection successful
            stmt = conn.createStatement();
            stmt.executeUpdate(req);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * Allow to perform a request of insertion on the database.
     *
     * @param req, the request to perform.
     */
    public static void requestUpdateCaseSensitive(String req) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection(DRIVERCONNECTION_ROAD, DRIVERCONNECTION_USER, DRIVERCONNECTION_PWD);
            // connection successful
            stmt = conn.createStatement();
            stmt.executeUpdate(req);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * Allow to perform a request on the database and get a single result.
     *
     * @param req, the request to perform.
     * @return res, a string that contains the result of the request.
     */
    public static String requestOneResult(String req) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        String res = "";

        try {
            conn = DriverManager.getConnection(DRIVERCONNECTION_ROAD, DRIVERCONNECTION_USER, DRIVERCONNECTION_PWD);
            // connection successful
            stmt = conn.createStatement();
            result = stmt.executeQuery(req);
            result.next();
            res = result.getString(1);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                }
            }

        }

        return res;
    }

    /**
     * Allow to perform a request on the database with a static method.
     *
     * @param req, the request to perform.
     * @return resultList, a list that contains for each line of the result a
     * list of the column values for the current line.
     */
    public static ArrayList requestStatic(String req) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        ArrayList<ArrayList> resultList = new ArrayList();
        String data = "";

        try {
            conn = DriverManager.getConnection(DRIVERCONNECTION_ROAD, DRIVERCONNECTION_USER, DRIVERCONNECTION_PWD);
            // connection successful
            stmt = conn.createStatement();
            result = stmt.executeQuery(req);
            ResultSetMetaData metadata = result.getMetaData();
            int nbCol = metadata.getColumnCount();
            while (result.next()) {
                ArrayList tempList = new ArrayList();
                for (int i = 1; i <= nbCol; i++) {
                    tempList.add(result.getString(i));
                }
                resultList.add(tempList);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return resultList;
    }

    /**
     * Allow to display the SQL errors.
     *
     * @param ex, the exception to manage.
     */
    public static void printSQLError(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

}
