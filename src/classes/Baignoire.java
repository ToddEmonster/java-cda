package classes;

public class Baignoire {

    private int volumeMax;
    private int volumeActuel;

    public Baignoire(int volumeMax) {
        this.volumeMax = volumeMax;
        this.volumeActuel = 0;
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
}
