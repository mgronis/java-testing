package domain.presentation;

public class BikeService {

    private final TyprePump pump;
    private final GreaseGun greaseGun;

    public BikeService(TyprePump pump, GreaseGun greaseGun) {
        this.pump = pump;
        this.greaseGun = greaseGun;
    }

    public boolean standardService(Bike bike) {
        return true;
    }
}
