package com.simpus.antrianpasienonline.objects;

public class Histori {
    private String id;
    private String id_poli;
    private String id_dokter;
    private String id_jadwal;
    private String no_antrian;
    private String no_rm;
    private String no_rujukan;
    private String tanggal;
    private String waktu_antri;
    private String hadir;
    private String batal;
    private String start;
    private String dokter;
    private String poli;
    private String estimasi;

    public Histori(String id, String id_poli, String id_dokter, String id_jadwal, String no_antrian, String no_rm, String no_rujukan, String tanggal, String waktu_antri, String hadir, String batal, String start, String dokter, String poli, String estimasi) {
        this.id = id;
        this.id_poli = id_poli;
        this.id_dokter = id_dokter;
        this.id_jadwal = id_jadwal;
        this.no_antrian = no_antrian;
        this.no_rm = no_rm;
        this.no_rujukan = no_rujukan;
        this.tanggal = tanggal;
        this.waktu_antri = waktu_antri;
        this.hadir = hadir;
        this.batal = batal;
        this.start = start;
        this.dokter = dokter;
        this.poli = poli;
        this.estimasi = estimasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_poli() {
        return id_poli;
    }

    public void setId_poli(String id_poli) {
        this.id_poli = id_poli;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getNo_antrian() {
        return no_antrian;
    }

    public void setNo_antrian(String no_antrian) {
        this.no_antrian = no_antrian;
    }

    public String getNo_rm() {
        return no_rm;
    }

    public void setNo_rm(String no_rm) {
        this.no_rm = no_rm;
    }

    public String getNo_rujukan() {
        return no_rujukan;
    }

    public void setNo_rujukan(String no_rujukan) {
        this.no_rujukan = no_rujukan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu_antri() {
        return waktu_antri;
    }

    public void setWaktu_antri(String waktu_antri) {
        this.waktu_antri = waktu_antri;
    }

    public String getHadir() {
        return hadir;
    }

    public void setHadir(String hadir) {
        this.hadir = hadir;
    }

    public String getBatal() {
        return batal;
    }

    public void setBatal(String batal) {
        this.batal = batal;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }
}
