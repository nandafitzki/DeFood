/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Nikho Sagala
 */
public class Application {

    private ArrayList<Pemesan> listPemesan;
    private ArrayList<Menu> listMenu;

    public Application() {
        listPemesan = new ArrayList<>();
        listMenu = new ArrayList<>();
    }

    public void addAccount(String username, String password, String alamat, String nohp) {
        Pemesan p = new Pemesan(username, password, alamat, nohp);
        listPemesan.add(p);
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

    public void editAlamat(String username, String alamat) {
        for (Pemesan temp : listPemesan) {
            if (temp.getUsername().equals(username)) {
                temp = new Pemesan(temp.getUsername(), temp.getPassword(), alamat, temp.getNohp());
                listPemesan.set(listPemesan.indexOf(temp), temp);
            }
        }
    }
}
