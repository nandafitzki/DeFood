/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Database;
import Model.Application;
import Model.Pemesan;
import java.sql.SQLException;

/**
 *
 * @author Nikho Sagala
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Application app = new Application();
        Database db = new Database();
        db.connect();
        app.addAccount("nikhosagala", "humbala", "Sukapura", "0813");
        Pemesan p = new Pemesan("username", "password", "alamat", "nohp");
        app.addAccount("nanda", "123456", "Mangga Dua", "0813");
        app.addAccount("qais", "qwerty", "Sukabirus", "0856");
        app.addAccount("fajarkm", "asdf", "Sukabirus", "0818");
        app.addMenu("Ma001", "Nasi", 3000);
        app.addMenu("Mi001", "Teh Manis", 2500);
        app.addMenu("Ma002", "Nasi Kuning", 5000);
        app.addPetugas("P001", "Paijo");
        app.addPetugas("P002", "Paimin");
        app.updateHarga("Ma001", 4000);
        System.out.println(app.getListPemesan().get(2).getUsername());
        System.out.println(app.getListMenu().get(1).getNamaMenu());
        System.out.println(app.getListPetugas().get(1).getNamaPetugas());
        System.out.println(app.getListMenu().get(2).getHarga());
        //db.savePemesan(p);
        System.out.println(db.loginFromDb("username", "password"));
    }

}
