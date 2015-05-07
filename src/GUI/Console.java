/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Application;

/**
 *
 * @author Nikho Sagala
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application app = new Application();
        app.addAccount("nikhosagala", "humbala", "Sukapura", "0813");
        app.addMenu("Ma001", "Nasi", 3000);
        app.addPetugas("P001", "Paijo");
        app.updateHarga("Ma001", 4000);
        System.out.println(app.getListPemesan().get(0).getUsername());
        System.out.println(app.getListMenu().get(0).getNamaMenu());
        System.out.println(app.getListPetugas().get(0).getNamaPetugas());
        System.out.println(app.getListMenu().get(0).getHarga());
    }

}
