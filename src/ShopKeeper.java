import java.util.Random;

public class ShopKeeper {

    private final int maxPancakesPerCycle;

    public ShopKeeper(int maxPancakesPerCycle) {

        this.maxPancakesPerCycle = maxPancakesPerCycle;
    }

    public int makePancakes(Random random) {

        return random.nextInt(maxPancakesPerCycle + 1);
    }
}
