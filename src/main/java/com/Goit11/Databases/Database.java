package com.Goit11.Databases;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String CONNECTION_URL = "jdbc:h2:~/GoIt11/Projects/Gradle/JDBC/jdbc-migration/jdbc-migr/migration";
    private static final String CONNECTION_USERNAME = "admin";
    private static final String CONNECTION_PASSWORD = "asd";
    Connection connection;

    public Database() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(CONNECTION_URL,CONNECTION_USERNAME,CONNECTION_PASSWORD);

    }

    public static Database getInstance(){
        try {
            return new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public boolean check(){
        try {
            return !connection.isClosed();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}