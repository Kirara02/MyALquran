package com.android.myalquran;

public class DetailModel {
    private String nomor,arab,terjemah;

    public DetailModel(String nomor, String arab, String terjemah) {
        this.nomor = nomor;
        this.arab = arab;
        this.terjemah = terjemah;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getArab() {
        return arab;
    }

    public void setArab(String arab) {
        this.arab = arab;
    }

    public String getTerjemah() {
        return terjemah;
    }

    public void setTerjemah(String terjemah) {
        this.terjemah = terjemah;
    }

}
