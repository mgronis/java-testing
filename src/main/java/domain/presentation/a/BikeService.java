package domain.presentation.a;

public class BikeService {

    private final TyrePump pump;
    private final GreaseGun greaseGun;

    public BikeService(TyrePump pump, GreaseGun greaseGun) {
        this.pump = pump;
        this.greaseGun = greaseGun;
    }

    public boolean standardService(Bike bike) {
        return true;
    }
}
