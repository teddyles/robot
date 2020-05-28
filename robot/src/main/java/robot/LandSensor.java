package robot;

import java.util.Random;

public class LandSensor {

    private Random random;

    public LandSensor(Random random) {
        this.random = random;
    }

    public double getPointToPointEnergyCoefficient(Coordinates coordinate1, Coordinates coordinate2) {
        double distance = distance(coordinate1, coordinate2);
        return 1 + distance / (distance * random.nextDouble());
    }

    public static double distance(Coordinates coordinate1, Coordinates coordinate2) {
        return Math.sqrt(Math.pow(coordinate1.getX()-coordinate2.getX(), 2) + Math.pow(coordinate1.getY()-coordinate2.getY(),2));
    }
}
