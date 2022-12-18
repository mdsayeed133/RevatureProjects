<<<<<<< HEAD
package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project1";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);

    }

}

=======
package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project1";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);

    }

}

>>>>>>> 3942f9dff893bfca0e5140e0d277f91149ed87c0
