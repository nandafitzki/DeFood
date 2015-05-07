/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Application;
import Model.Pemesan;
import Model.Petugas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nikho Sagala
 */
public class Database {

    private String dbuser;
    private String dbpassword;
    private Application app;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect() throws SQLException {
        try {
            dbuser = "root";
            dbpassword = "";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/defood", dbuser, dbpassword);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public void disconnect() throws SQLException {
        try {
            dbuser = "root";
            dbpassword = "";
            connection.close();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/defood", dbuser, dbpassword);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public void savePemesan(Pemesan p) throws SQLException {
        //Pemesan p = app.returnPemesan(username);
        String query = "insert into pemesan(username,password,alamat,nohp) values ('" + p.getUsername() + "','" + p.getPassword() + "','" + p.getAlamat() + "','" + p.getNohp() + "')";
        statement.execute(query);
    }

    public boolean loginFromDb(String username, String password) throws SQLException {
        boolean cek = false;
        String query = "select * from pemesan";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(username) && resultSet.getString(2).equals(password)) {
                cek = true;
            }
        }
        return cek;
    }

}
