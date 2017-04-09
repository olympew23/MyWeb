package com.company;

import org.h2.tools.Server;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        // url to database, Driver
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        //Will create a statement object, construct statements to be sent to the database
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS players (id IDENTITY, name VARCHAR, is_alive BOOLEAN, score INT, health DOUBLE)");
        stmt.execute("INSERT INTO players VALUES (NULL, 'Alice', true, 0, 100.0)");

        stmt.execute("UPDATE players SET is_alive = FALSE WHERE name = 'Alice'");
        stmt.execute("DELETE FROM players WHERE name = 'Alice'");
        //setting before executing
        PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO players VALUES (NULL, ?, ?, ?, ?)");
        stmt2.setString(1, "David");//set name value
        stmt2.setBoolean(2, true);
        stmt2.setInt(3, 0);
        stmt2.setDouble(4, 100.0);
        stmt2.execute();

            PreparedStatement stmt3 = conn.prepareStatement("SELECT * FROM players");
            ResultSet results = stmt3.executeQuery();
            while (results.next()) {
            String playerName = results.getString("name");
            double health = results.getDouble("health");
            int score = results.getInt("score");
            System.out.printf("%s %s %s\n", playerName, health, score);
        }


    }



}
