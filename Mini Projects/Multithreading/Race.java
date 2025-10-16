public class Race {
    public static volatile boolean raceOver = false;

    public static void main(String[] args) {
        Hare hare = new Hare();
        Tortoise tortoise = new Tortoise();

        // Set thread priority: Hare is faster, so higher priority
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);

        hare.start();
        tortoise.start();

        try {
            hare.join();
            tortoise.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Race finished!");
    }
}
