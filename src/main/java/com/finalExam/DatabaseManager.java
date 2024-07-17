package com.finalExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://192.168.117.160:3306/customer";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kali";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean next() {
        try {
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getCustomerId() {
        try {
            return resultSet.getInt("customer_id");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getCustomerLastName() {
        try {
            return resultSet.getString("customer_last_name");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCustomerFirstName() {
        try {
            return resultSet.getString("customer_first_name");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCustomerPhone() {
        try {
            return resultSet.getString("customer_phone");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
