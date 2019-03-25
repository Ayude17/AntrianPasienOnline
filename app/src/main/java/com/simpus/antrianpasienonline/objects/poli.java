package com.simpus.antrianpasienonline.objects;

public class poli {
    private String id;
    private String poli;
    private String huruf;

    public poli(String id, String poli, String huruf) {
        this.id = id;
        this.poli = poli;
        this.huruf = huruf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getHuruf() {
        return huruf;
    }

    public void setHuruf(String huruf) {
        this.huruf = huruf;
    }
}
