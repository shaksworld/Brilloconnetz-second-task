import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        final int MAX_PANCAKES_PER_USER = 5;
        final int MAX_PANCAKES_PER_CYCLE = 12;
        final int NUM_USERS = 3;
        final int CYCLE_DURATION_SECONDS = 30;
        final int TOTAL_CYCLES = 10; // Number of 30-second intervals to simulate

        Random random = new Random();

        User[] users = new User[NUM_USERS];
        for (int i = 0; i < NUM_USERS; i++) {
            users[i] = new User(MAX_PANCAKES_PER_USER);
        }

        ShopKeeper shopkeeper = new ShopKeeper(MAX_PANCAKES_PER_CYCLE);

        for (int cycle = 1; cycle <= TOTAL_CYCLES; cycle++) {
            int shopkeeperPancakes = shopkeeper.makePancakes(random);

            for (User user : users) {
                user.placeOrder(random);
            }

            int totalEatenPancakes = 0;
            for (User user : users) {
                totalEatenPancakes += user.eatPancakes();
            }

            int unmetOrders = 0;
            for (User user : users) {
                if (user.hasUnmetOrders()) {
                    unmetOrders++;
                }
            }

            int wastedPancakes = Math.max(0, shopkeeperPancakes - totalEatenPancakes);

            System.out.println("Interval " + cycle + " - " + (cycle * CYCLE_DURATION_SECONDS) + " seconds:");
            System.out.println("Shopkeeper made " + shopkeeperPancakes + " pancakes");
            System.out.println("Users ate " + totalEatenPancakes + " pancakes");
            System.out.println("Unmet orders: " + unmetOrders);
            System.out.println("Wasted pancakes: " + wastedPancakes);
            System.out.println();
        }
    }
}