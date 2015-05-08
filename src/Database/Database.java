/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Application;
import Model.Menu;
import Model.Pemesan;
import Model.Petugas;
import Model.Restoran;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        try {
            String query = "insert into pemesan(username,password,alamat,nohp) values ('" + p.getUsername() + "','" + p.getPassword() + "','" + p.getAlamat() + "','" + p.getNohp() + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public ArrayList<Pemesan> getPemesan() throws SQLException {
        ArrayList<Pemesan> listPemesan = new ArrayList<>();
        Pemesan p;
        try {
            resultSet = statement.executeQuery("select * from pemesan");
            while (resultSet.next()) {
                p = new Pemesan(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                listPemesan.add(p);
            }
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
        return listPemesan;
    }

    public void deletePemesan(String username) throws SQLException {
        try {
            String query = "delete from pemesan where username = '" + username + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }

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

    public void saveMenu(Menu m) throws SQLException {
        try {
            String query = "insert into menu(id_menu,nama_menu,harga) values ('" + m.getIdMenu() + "','" + m.getNamaMenu() + "'," + m.getHarga() + ")";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public ArrayList<Menu> getMenu() throws SQLException {
        ArrayList<Menu> listMenu = new ArrayList<>();
        Menu m;
        try {
            resultSet = statement.executeQuery("select * from menu");
            while (resultSet.next()) {
                m = new Menu(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3));
                listMenu.add(m);
            }
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
        return listMenu;
    }

    public void deleteMenu(String idMenu) throws SQLException {
        try {
            String query = "delete from menu where id_menu = '" + idMenu + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Excepcion.");
        }
    }

    public void savePetugas(Petugas p) throws SQLException {
        try {
            String query = "insert into petugas(id_petugas,nama_petugas) values ('" + p.getIdPetugas() + "','" + p.getNamaPetugas() + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public ArrayList<Petugas> getPetugas() throws SQLException {
        ArrayList<Petugas> listPetugas = new ArrayList<>();
        Petugas p;
        try {
            resultSet = statement.executeQuery("select * from petugas");
            while (resultSet.next()) {
                p = new Petugas(resultSet.getString(1), resultSet.getString(2));
                listPetugas.add(p);
            }
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
        return listPetugas;
    }

    public void deletePetugas(String idPetugas) throws SQLException {
        try {
            String query = "delete from menu where id_petugas = '" + idPetugas + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Excepcion.");
        }
    }

    public void saveRestoran(Restoran r) throws SQLException {
        try {
            String query = "insert into restoran(nama_restoran,alamat) values ('" + r.getNamaRestoran() + "','" + r.getAlamat() + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public ArrayList<Restoran> getRestoran() throws SQLException {
        ArrayList<Restoran> listRestoran = new ArrayList<>();
        Restoran r;
        try {
            resultSet = statement.executeQuery("select * from restoran");
            while (resultSet.next()) {
                r = new Restoran(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                listRestoran.add(r);
            }
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
        return listRestoran;
    }

}
