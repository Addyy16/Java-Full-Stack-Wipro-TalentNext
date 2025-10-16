package OOPSProject ;
public class VideoStore {
    private Video[] store = new Video[10];
    private int count = 0;

    public void addVideo(String name) {
        if (count < store.length) {
            store[count++] = new Video(name);
            System.out.println("Video \"" + name + "\" added successfully.");
        } else {
            System.out.println("Store is full. Cannot add more videos.");
        }
    }

    public void doCheckout(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void doReturn(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void receiveRating(String name, int rating) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void listInventory() {
        System.out.println("Video Name | Checkout Status | Rating");
        for (int i = 0; i < count; i++) {
            System.out.println(store[i].getName() + " | " + store[i].getCheckout() + " | " + store[i].getRating());
        }
    }
}
