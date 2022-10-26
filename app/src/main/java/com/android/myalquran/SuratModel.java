package com.android.myalquran;

public class SuratModel {
    private String no,nama,latin,turun,ayat,arti;

    public SuratModel(String no, String nama, String latin, String turun, String ayat, String arti) {
        this.no = no;
        this.nama = nama;
        this.latin = latin;
        this.turun = turun;
        this.ayat = ayat;
        this.arti = arti;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getTurun() {
        return turun;
    }

    public void setTurun(String turun) {
        this.turun = turun;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
}
