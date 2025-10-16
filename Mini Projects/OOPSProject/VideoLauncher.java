package OOPSProject ;
import java.util.Scanner;
public class VideoLauncher {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMAIN MENU\n========");
            System.out.println("1.Add Videos:");
            System.out.println("2. Check Out Video :");
            System.out.println("3. Return Video :");
            System.out.println("4. Receive Rating :");
            System.out.println("5. List Inventory :");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice (1..6): ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    String name = sc.nextLine();
                    store.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    String checkOutName = sc.nextLine();
                    store.doCheckout(checkOutName);
                    break;
                case 3:
                    System.out.print("Enter the name of the video you want to Return: ");
                    String returnName = sc.nextLine();
                    store.doReturn(returnName);
                    break;
                case 4:
                    System.out.print("Enter the name of the video you want to Rate: ");
                    String rateName = sc.nextLine();
                    System.out.print("Enter the rating for this video: ");
                    int rating = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    store.receiveRating(rateName, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

