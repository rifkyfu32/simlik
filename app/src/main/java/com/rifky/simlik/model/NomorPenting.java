package com.rifky.simlik.model;

/**
 * Created by rifky on 07/05/17.
 */

public class NomorPenting {
    private String nama;
    private String telepon;

    public NomorPenting(String nama, String telepon) {
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
