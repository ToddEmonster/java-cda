package classes;

import static util.PrintFormat.FORMAT;

public class Baignoire {

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
        while (this.volumeActuel > 0) {
            this.volumeActuel -= this.volumeFuite;
            String prefix = "Volume baignoire après fuite :";
            String suffix = " L";
            System.out.printf(FORMAT, prefix, this.volumeActuel, suffix);
        }
    }
}
