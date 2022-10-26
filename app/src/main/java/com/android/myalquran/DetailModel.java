package com.android.myalquran;

public class DetailModel {
    private String nomor,arab,terjemah,audio;

    public DetailModel(String nomor, String arab, String terjemah, String audio) {
        this.nomor = nomor;
        this.arab = arab;
        this.terjemah = terjemah;
        this.audio = audio;
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

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
