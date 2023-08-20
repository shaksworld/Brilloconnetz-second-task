import java.util.Random;

public class User {

    private final int maxPancakesPerUser;
    private int remainingPancakes;

    public User(int maxPancakesPerUser) {
        this.maxPancakesPerUser = maxPancakesPerUser;
        this.remainingPancakes = 0;
    }

    public void placeOrder(Random random) {
        remainingPancakes = random.nextInt(maxPancakesPerUser + 1);
    }

    public int eatPancakes() {
        int pancakesEaten = Math.min(maxPancakesPerUser, remainingPancakes);
        remainingPancakes -= pancakesEaten;
        return pancakesEaten;
    }

    public boolean hasUnmetOrders() {
        return remainingPancakes > 0;
    }
}
