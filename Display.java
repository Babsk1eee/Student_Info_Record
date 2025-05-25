import java.util.Scanner;

public class Display {
    
    private Scanner scanner;
    StudentData studentData = new StudentData(null, null, null, null, null);

    public Display(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to display the menu
    public void display_interface() {

        System.out.println("\n\n\n========== Student Information System ==========");
        
        System.out.println();
        
        System.out.println("[1] Add Student");
        System.out.println("[2] Display All Student");
        System.out.println("[3] Search Student");
        System.out.println("[4] Delete Student");
        System.out.println("[0] Exit");
        
        System.out.println();
    }

    // Method to add student
    public void addStudent() {
        // Use the scanner field instead of creating a new Scanner

        System.out.println("Enter your name (Last Name, First Name M.I.)");
        System.out.print("Your Input: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter your sex (M/F)");
        System.out.print("Your Input: ");
        String sex = scanner.nextLine();

        System.out.println("Enter your Student No.");
        System.out.print("Your Input: ");
        String studentNo = scanner.nextLine();

        System.out.println("Enter your course");
        System.out.print("Your Input: ");
        String course = scanner.nextLine();

        System.out.println("Enter your section");
        System.out.print("Your Input: ");
        String section = scanner.nextLine();

        studentData = new StudentData(fullName, course, section, studentNo, sex);
    }

    // Displays All Students
    public void displayAllStudent() {

    }
}
