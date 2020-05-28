package battery;

public class Battery {

    public final long CHARGE_TOP = 1000;
    public final long CHARGE_STEP = 10;
    private long chargeClock;
    private float chargeLevel;

    public Battery() {
        chargeLevel = 100;
        setUp();
    }

    public void setUp() {
        chargeClock = System.currentTimeMillis();
    }

    public void charge() {
        long lastChargeClock = chargeClock;
        chargeClock = System.currentTimeMillis();
        chargeLevel = chargeFunction(chargeLevel, chargeClock - lastChargeClock);
    }

    private float chargeFunction(float charge, long time) {
        return charge + CHARGE_STEP * time / CHARGE_TOP;
    }

    private float chargeFunction(float charge) {
        return charge + CHARGE_STEP;
    }

    public float getChargeLevel() {
        charge();
        return chargeLevel;
    }

    public void use(double energy) throws InsufficientChargeException {
        charge();
        if (chargeLevel < energy) throw new InsufficientChargeException();
        chargeLevel -= energy;
    }

    public boolean canDeliver(double neededEnergy) {
        charge();
        return (chargeLevel >= neededEnergy);
    }

    public long timeToSufficientCharge(double neededEnergy) {
        int clock = 0;
        float charge = chargeLevel;
        while (charge < neededEnergy) {
            charge = chargeFunction(charge);
            clock++;
        }
        return clock * CHARGE_TOP;
    }
}
