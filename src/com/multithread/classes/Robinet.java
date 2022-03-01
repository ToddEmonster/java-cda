package com.multithread.classes;

import static java.lang.Thread.sleep;
import static util.PrintFormat.FORMAT;

public class Robinet implements Runnable {

    private Baignoire baignoire;
    private int volumeDebit;

    public Robinet(Baignoire baignoire, int volumeDebit) {
        this.baignoire = baignoire;
        this.volumeDebit = volumeDebit;
    }

    public void debite() {
        while (this.baignoire.getVolumeActuel() + this.volumeDebit <= this.baignoire.getVolumeMax()) {
            synchronized(this.baignoire) {
                this.baignoire.setVolumeActuel(this.baignoire.getVolumeActuel() + this.volumeDebit);
                String prefix = "Volume baignoire après débit :";
                System.out.printf(FORMAT, prefix, this.baignoire.getVolumeActuel());
            }

            try {
                sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {
        this.debite();
    }
}
