package com.simpus.antrianpasienonline.objects;

public class Histori {
    private String no_antrian;
    private String tanggal_antri;
    private String poli;
    private String dokter;
    private String no_rujukan;

    public Histori(String no_antrian, String tanggal_antri, String poli, String dokter, String no_rujukan) {
        this.no_antrian = no_antrian;
        this.tanggal_antri = tanggal_antri;
        this.poli = poli;
        this.dokter = dokter;
        this.no_rujukan = no_rujukan;
    }

    public String getNo_antrian() {
        return no_antrian;
    }

    public void setNo_antrian(String no_antrian) { this.no_antrian = no_antrian;
    }

    public String getTanggal_antri() {
        return tanggal_antri;
    }

    public void setTanggal_antri(String tanggal_antri) { this.tanggal_antri = tanggal_antri;
    }

    public String getPoli() { return poli; }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getNo_rujukan() {
        return no_rujukan;
    }

    public void setNo_rujukan(String no_rujukan) {
        this.no_antrian = no_rujukan;
    }
}
