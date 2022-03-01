package com.multithread.classes;

import static java.lang.Thread.sleep;
import static util.PrintFormat.FORMAT;

public class Baignoire implements Runnable {

    private int volumeMax;
    private int volumeActuel;
    private int volumeFuite;

    // Baignoire qui ne fuit pas
    public Baignoire(int volumeMax) {
        this.volumeMax = volumeMax;
        this.volumeActuel = 0;
        this.volumeFuite = 0;
    }

    // Baignoire qui fuit
    public Baignoire(int volumeMax, int volumeFuite) {
        this.volumeMax = volumeMax;
        this.volumeActuel = 0;
        this.volumeFuite = volumeFuite;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public int getVolumeActuel() {
        return volumeActuel;
    }

    public void setVolumeActuel(int volumeActuel) {
        this.volumeActuel = volumeActuel;
    }

    public int getVolumeFuite() {
        return volumeFuite;
    }

    public void fuite() {
        while (this.volumeFuite > 0) {
            while (this.volumeActuel > 0) {
                synchronized (this) {
                    if (this.volumeActuel > 0) this.volumeActuel -= this.volumeFuite;
                    String prefix = "Volume baignoire après fuite :";
                    System.out.printf(FORMAT, prefix, this.volumeActuel);
                }
                try {
                    sleep(2);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void colmater() {
        while (this.volumeFuite > 0) {
            if (this.volumeActuel == 0) {
                synchronized (this) {
                    this.volumeFuite -= 1;
                    String prefix = "Volume fuite après colmater :";
                    System.out.printf(FORMAT, prefix, this.volumeFuite);
                }
            }
        }
    }

    @Override
    public void run() {
        this.colmater();
        this.fuite();
    }

}
