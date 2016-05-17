<%-- 
    Document   : CustomerConnection
    Created on : 13 mai 2016, 11:00:28
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
        <link rel="stylesheet" href="style.css">
        <title>Login form</title>
    </head>
    <body>

        <div id="page" class="container">

            <jsp:useBean id = "sessionB" scope = "session" class = "bean.SessionBean" />

            <center>
                <h1> Connection </h1>
            </center>

            <%
                if (request.getParameter("validate") != null) {

                    try {
                        String connectionURL = "jdbc:mysql://localhost/genindexe";
                        Connection connection = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(connectionURL, "root", "root");

                        Statement stmt = null;
                        ResultSet result = null;
                        stmt = connection.createStatement();
                        result = stmt.executeQuery("select count(*) from `Customer` where `Customer_Login` = '" + request.getParameter("login") + "'"
                                + " and `Customer_Password` = '" + request.getParameter("password") + "'");

                        result.next();

                        if (result.getString(1).equals("1")) {

                            sessionB.setUsername(request.getParameter("login"));
            %> 
            <meta http-equiv="refresh" content="0; URL=ExploreOrder.jsp">
            <%
                        } else {
                            out.println("Wrong password or username");
                        }

                        connection.close();
                    } catch (SQLException ex) {
                        out.println("SQLException: " + ex.getMessage());
                        out.println("SQLState: " + ex.getSQLState());
                        out.println("VendorError: " + ex.getErrorCode());
                    }
                }
            %>   

            <form id="op" name ="Connection" method="POST" action="#">
                <br/>
                <legend>Username : </legend> <input type="text" name="login" placeholder="your username"/>
                <br/>
                <legend>Password : </legend> <input type="text" name="password" placeholder="your password"/>
                <br/>
                <input type="submit" name="validate" value="Validate" class="bouton">
                <br/>           
            </form>
        </div>
    </body>
</html>
