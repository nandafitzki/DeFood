/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nikho Sagala
 */
public class Restoran {

    private String idRestoran;
    private String namaRestoran;
    private String alamat;

    public Restoran() {
    }

    public Restoran(String namaRestoran, String alamat) {
        this.namaRestoran = namaRestoran;
        this.alamat = alamat;
    }

    public Restoran(String idRestoran, String namaRestoran, String alamat) {
        this.idRestoran = idRestoran;
        this.namaRestoran = namaRestoran;
        this.alamat = alamat;
    }

    public String getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(String idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNamaRestoran() {
        return namaRestoran;
    }

    public void setNamaRestoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
