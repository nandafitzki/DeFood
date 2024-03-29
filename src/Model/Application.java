/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nikho Sagala
 */
public class Application {

    private ArrayList<Pemesan> listPemesan;
    private ArrayList<Menu> listMenu;
    private ArrayList<Petugas> listPetugas;
    private ArrayList<Restoran> listRestoran;
    private Database data;

    public Application() {
        listPemesan = new ArrayList<>();
        listMenu = new ArrayList<>();
        listPetugas = new ArrayList<>();
        listRestoran = new ArrayList<>();
        data = new Database();
    }

    public void addAccount(String username, String password, String alamat, String nohp) {
        Pemesan p = new Pemesan(username, password, alamat, nohp);
        listPemesan.add(p);
    }

    public Pemesan returnPemesan(String username) {
        Pemesan p = null;
        for (Pemesan temp : listPemesan) {
            if (temp.getUsername().equals(username)) {
                p = temp;
            }
        }
        return p;
    }

    public void editAlamat(String username, String alamat) {
        for (Pemesan temp : listPemesan) {
            if (temp.getUsername().equals(username)) {
                Pemesan p = new Pemesan(temp.getUsername(), temp.getPassword(), alamat, temp.getNohp());
                listPemesan.set(listPemesan.indexOf(temp), p);
            }
        }
    }

    public void loadPemesan() throws SQLException {
        try {
            data.connect();
            listPemesan = data.getPemesan();
            data.disconnect();
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public boolean login(String username, String password) {
        boolean cek = false;
        for (Pemesan temp : listPemesan) {
            cek = temp.getUsername().equals(username) && temp.getPassword().equals(password);
        }
        return cek;
    }

    public void addMenu(String idMenu, String namaMenu, double harga) {
        Menu m = new Menu(idMenu, namaMenu, harga);
        listMenu.add(m);
    }

    public Menu returnMenu(String idMenu) {
        Menu m = null;
        for (Menu temp : listMenu) {
            if (temp.getIdMenu().equals(idMenu)) {
                m = temp;
            }
        }
        return m;
    }

    public void deleteMenu(String idMenu) {
        for (Menu temp : listMenu) {
            if (temp.getIdMenu().equals(idMenu)) {
                listMenu.remove(listMenu.indexOf(temp));
            }
        }
    }

    public void updateHarga(String idMenu, double harga) {
        for (Menu temp : listMenu) {
            if (temp.getIdMenu().equals(idMenu)) {
                Menu m = new Menu(temp.getIdMenu(), temp.getNamaMenu(), harga);
                listMenu.set(listMenu.indexOf(temp), m);
            }
        }
    }

    public void loadMenu() throws SQLException {
        try {
            data.connect();
            listMenu = data.getMenu();
            data.disconnect();
        } catch (SQLException ex) {
            throw new SQLException("SQL Exception.");
        }
    }

    public void addPetugas(String idPetugas, String namaPetugas) {
        Petugas p = new Petugas(idPetugas, namaPetugas);
        listPetugas.add(p);
    }

    public Petugas returnPetugas(String idPetugas) {
        Petugas p = null;
        for (Petugas temp : listPetugas) {
            if (temp.getIdPetugas().equals(idPetugas)) {
                p = temp;
            }
        }
        return p;
    }

    public void deletePetugas(String idPetugas) {
        for (Petugas temp : listPetugas) {
            if (temp.getIdPetugas().equals(idPetugas)) {
                listPetugas.remove(listPetugas.indexOf(temp));
            }
        }
    }

    public ArrayList<Pemesan> getListPemesan() {
        return listPemesan;
    }

    public ArrayList<Menu> getListMenu() {
        return listMenu;
    }

    public ArrayList<Petugas> getListPetugas() {
        return listPetugas;
    }

}
