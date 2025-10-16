public class Hare extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Race.raceOver) {
                System.out.println("Hare stopped racing.");
                break;
            }

            System.out.println("Hare ran meter: " + i);

            if (i == 60) {
                System.out.println("Hare is sleeping now...");
                try {
                    Thread.sleep(1000);  // Hare sleeps for 1000 milliseconds at 60 meters
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (i == 100) {
                Race.raceOver = true;
                System.out.println("Hare wins the race!");
                break;
            }

            try {
                Thread.sleep(50);  // Small delay to simulate running speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
