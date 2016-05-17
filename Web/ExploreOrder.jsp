<%-- 
    Document   : ExploreOrder
    Created on : 17 mai 2016, 09:25:26
    Author     : thoma
--%>

<%@page import="java.sql.*" %> 
<%@page import="java.io.*" %>
<%@page import="nf.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Explore order</title>
    </head>
    <body>

        <jsp:useBean id = "sessionB"scope = "session" class = "bean.SessionBean" /> 

        <%
            try {
                String connectionURL = "jdbc:mysql://localhost/genindexe";
                Connection connection = null;
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(connectionURL, "root", "root");

                String user = sessionB.getUsername();

                Statement stmt = null;
                ResultSet result = null;
                stmt = connection.createStatement();
                result = stmt.executeQuery("select * from `Order` where `Customer_Login` = '" + user + "'");
        %>

        <table BORDER="1">
            <caption> Orders </caption> 
            <tr>
                <th> Order id </th> 
                <th> Date </th> 
                <th> Analysis </th> 
                <th> Status </th> 
                <th> Specie </th>
            </tr>

            <%
                while (result.next()) {
            %>
            <tr>
                <td> <%out.println(result.getString("Order_Id"));%> </td>
                <td> <%//out.println(result.getString("Order_Date"));%> </td>
                <td> <%out.println(result.getString("Analysis_Name"));%> </td>
                <td> <%out.println(result.getString("Order_Status"));%> </td>
                <%
                    Statement stmtS = connection.createStatement();
                    ResultSet resultS = stmtS.executeQuery("select `Specie_Name` from `Sample` where `Order_Id` = " + result.getString("Order_Id") + "");
                    resultS.next();
                %>
                <td> <%out.println(resultS.getString(1));%> </td>
            </tr> 
            <%
                }
            %>
        </table> 
        <%
                connection.close();
            } catch (SQLException ex) {
                out.println("SQLException: " + ex.getMessage());
                out.println("SQLState: " + ex.getSQLState());
                out.println("VendorError: " + ex.getErrorCode());
            }
        %>

    </body>
</html>
