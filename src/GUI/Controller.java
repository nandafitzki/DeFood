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
public class Controller {

    Application app = new Application();

    public void setCon() {
        app.addAccount("nikhosagala", "humbala", "Sukapura", "0813");
        app.addMenu("Ma001", "Nasi", 3000);
        app.addPetugas("P001", "Paijo");
        app.editAlamat("nikhosagala", "Sukabirus");
    }

}
