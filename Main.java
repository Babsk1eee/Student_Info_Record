import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDataBase db = new StudentDataBase();
        Display display = new Display(scanner, db);
        
        int choice;
while (true){
        display.display_interface();
        System.out.print("Your choice: ");

        if (!scanner.hasNext()){
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            continue;
        }

        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline after nextInt()

        switch (choice) {
            case 1:
                display.addStudent();
                break;
            case 2:
                display.displayAllStudent();
                break;
            case 3:
                display.searchStudent();
                break;
            case 4:
                display.searchStudent(); //please change display.searchStudent() to display.deleteStudent()
                break;
            case 0:
                System.out.println("Exiting the program...");
                scanner.close();
                return;
        
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        System.out.println();
    }
}
}