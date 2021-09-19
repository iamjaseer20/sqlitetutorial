package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Inserttotable {

   
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

  
    public void insert(String moviename,String leadactor,String leadactress,int year,String director ) {
        String sql = "INSERT INTO movies VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, moviename);
            pstmt.setString(2, leadactor);
            pstmt.setString(3, leadactress);
            pstmt.setInt(4, year);
            pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {

        Inserttotable app = new Inserttotable();
     
        app.insert("Cold Case","Prithviraj","Divya",2021,"Tanu Balak");
        app.insert("Paagal","Vishwak","Nivetha",2021,"Naresh");
        app.insert("Minnal Murali","Tovino","Hridya",2021,"Basil Joseph");
        app.insert("Kane Kane","Suraj","Aishwarya",2021,"Rohan");
    }

}