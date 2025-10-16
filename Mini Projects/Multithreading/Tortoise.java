public class Tortoise extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Race.raceOver) {
                System.out.println("Tortoise stopped racing.");
                break;
            }

            System.out.println("Tortoise ran meter: " + i);

            if (i == 100) {
                Race.raceOver = true;
                System.out.println("Tortoise wins the race!");
                break;
            }

            try {
                Thread.sleep(100);  // Tortoise runs slower with 100 ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
