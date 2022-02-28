package classes;

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
            System.out.printf("%nVolume actuel de la baignoire : %s", this.baignoire.getVolumeActuel());
        }
    }
}
