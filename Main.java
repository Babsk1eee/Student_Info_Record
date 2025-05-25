import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display();
        
        int choice;

        do {
            display.display_interface();
            System.out.println("Your choice: ");
            choice = scanner.nextInt();

            scanner.close();
        } while (choice != 0);


        scanner.close();
    }
}