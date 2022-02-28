package classes;

import static util.PrintFormat.FORMAT;

public class Robinet {

    private Baignoire baignoire;
    private int volumeDebit;

    public Robinet(Baignoire baignoire, int volumeDebit) {
        this.baignoire = baignoire;
        this.volumeDebit = volumeDebit;
    }

    public void debite() {
        while (this.baignoire.getVolumeActuel() + this.volumeDebit <= this.baignoire.getVolumeMax()) {
            this.baignoire.setVolumeActuel(this.baignoire.getVolumeActuel() + this.volumeDebit);
            String prefix = "Volume baignoire après débit :";
            String suffix = " L";
            System.out.printf(FORMAT, prefix, this.baignoire.getVolumeActuel(), suffix);
        }
    }
}
