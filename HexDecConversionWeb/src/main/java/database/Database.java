/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The Database class provides functionality to interact with a Derby database.
 * It includes methods for initializing the database, creating tables,
 * selecting and inserting conversion data.
 *
 * @author Adam Kuraczyński
 * @version 1.19
 */
public class Database {

    private Database database;
    private Connection connection;
    
    /**
     * Initializes a Database object and establishes a connection to the Derby database.
     */
    public Database() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error initializing the database: " + ex.getMessage());
        }
    }
    
    /**
     * Retrieves the Database instance.
     * @return The Database instance.
     */
    public Database getDb() {
        return database;
    }
         
    /**
     * Creates the ConvertedValues table in the database if it does not exist.
     */
    public void createConversionTables() {
        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "ConvertedValues", null);

            if (!resultSet.next()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE ConvertedValues "
                        + "(convertedvalue VARCHAR(50) )");
                System.out.println("Table ConvertedValues has been created");
            } else {
                System.out.println("Table ConvertedValues has not been created");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
    /**
     * Retrieves the conversion data from the ConvertedValues table.
     * @return A list of lists containing the conversion data.
     */
    public ArrayList<ArrayList<String>> selectConversionData() {
        ArrayList<ArrayList<String>> convertedValuesList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            String query = "SELECT * FROM ConvertedValues";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    ArrayList<String> convertedValuesData = new ArrayList<>();
                    convertedValuesData.add(rs.getString("convertedValue"));
                    convertedValuesList.add(convertedValuesData);
                }
                rs.close();
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        }

        return convertedValuesList;
    }
    
    /**
     * Inserts conversion data into the ConvertedValues table.
     * @param id The ID to insert.
     * @param valueToAdd The value to insert.
     */
    public void insertConversionData(int id, String valueToAdd) {
        try {
            Statement statement = connection.createStatement();
            System.out.println("TEST PRZED INSERTEM "+ valueToAdd);
            String query = "INSERT INTO ConvertedValues (convertedvalue) VALUES ('" + valueToAdd + "')";
            statement.executeUpdate(query);
            System.out.println("Data inserted into ConvertedValues");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
}