import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display(scanner);
        
        int choice;

        display.display_interface();
        System.out.print("Your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline after nextInt()

        switch (choice) {
            case 1:
                display.addStudent();
                break;
        
            default:
                break;
        }

        scanner.close();
    }
}
