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
        <title>Login form</title>
    </head>
    <body>
        <form id="op" name ="Connection" method="POST" action="ExploreOrder.jsp">
            <br/>
            <label>Username : </label> <input type="text" name="login" placeholder="your username"/>
            <br/>
            <label>Password : </label> <input type="text" name="password" placeholder="your password"/>
            <br/>
            <input type="submit" name="validate" value="Validate" class="bouton">
            <br/>

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

                        while (result.next()) {

                            if (result.getString(1).equals("1")) {
            %>

            <jsp:useBean id = "session"
                         scope = "session"
                         class = "bean.SessionBean">  
                <jsp:setProperty name="session" property="username" param="login"/>
            </jsp:useBean>

            <%
                            } else {
                                out.println("Wrong password or username");
                            }
                        }

                        connection.close();
                    } catch (Exception ex) {
                        out.println("Unable to connect to database");
                    }
                }
            %>           

    </body>
</html>
