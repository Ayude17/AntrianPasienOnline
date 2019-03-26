package com.simpus.antrianpasienonline.objects;

public class Dokter {
    private String id_jadwal;
    private String poli;
    private String nama;
    private String spesialis;
    private String start;
    private String end;
    private String kuota;
    private String terisi;

    public Dokter(String id_jadwal, String poli, String nama, String spesialis, String start, String end, String kuota, String terisi) {
        this.id_jadwal = id_jadwal;
        this.poli = poli;
        this.nama = nama;
        this.spesialis = spesialis;
        this.start = start;
        this.end = end;
        this.kuota = kuota;
        this.terisi = terisi;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getKuota() {
        return kuota;
    }

    public void setKuota(String kuota) {
        this.kuota = kuota;
    }

    public String getTerisi() {
        return terisi;
    }

    public void setTerisi(String terisi) {
        this.terisi = terisi;
    }
}
