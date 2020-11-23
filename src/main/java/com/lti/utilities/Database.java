package com.lti.utilities;

import com.lti.constants.DBConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName(DBConstants.ORACLE_DRIVER);
            return DriverManager.getConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
