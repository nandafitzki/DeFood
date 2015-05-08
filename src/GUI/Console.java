/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Database;
import Model.Application;
import Model.Menu;
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
        Pemesan p;
        Menu m;
        db.connect();
        app.addPetugas("P001", "Paijo");
        app.addPetugas("P002", "Paimin");
        //p = new Pemesan("username", "password", "alamat", "nohp");
        //db.savePemesan(p);
        //p = new Pemesan("nikhosagala", "humbala", "Sukapura", "0813");
        //db.savePemesan(p);
        //db.deletePemesan("username");
        app.loadPemesan();
        System.out.println(app.getListPemesan().get(1).getUsername());
        System.out.println(app.getListPetugas().get(1).getNamaPetugas());
        //m = new Menu("Ma001", "Nasi", 3000);
        //db.saveMenu(m);
        //m = new Menu("Mi001", "Teh Manis", 2500);
        //db.saveMenu(m);
        app.loadMenu();
        System.out.println(app.getListMenu().get(0).getNamaMenu());
        System.out.println(app.getListMenu().get(1).getHarga());
        System.out.println(db.loginFromDb("nikhosagala", "humbala"));
        db.disconnect();
    }
}