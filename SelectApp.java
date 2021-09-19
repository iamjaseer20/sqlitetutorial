package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectApp {

   
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    
    public void selectAll(){
        String sql = "SELECT moviename,leadactor,leadactress,year,director FROM movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            while (rs.next()) {
                System.out.println(rs.getString("moviename") +  "\t" + 
                                   rs.getString("leadactor") + "\t" +
                                   rs.getString("leadactress")+ "\t" +
                                   rs.getInt("year") + "\t" +
                                   rs.getString("director"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}