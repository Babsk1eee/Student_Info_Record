import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Display {

    private Scanner scanner;
    private StudentDataBase studentDB;

    // Constructor for Display class
    public Display(Scanner scanner, StudentDataBase studentDB) {
        // Initialize the scanner and studentDB
        this.scanner = scanner;
        this.studentDB = studentDB;
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

        studentDB.addStudent(fullName, course, section, studentNo, sex);
    }

    // Method to search student
    public void searchStudent() {
        System.out.print("Enter name, student number, or section to search: ");
        String keyword = scanner.nextLine();
        studentDB.searchStudent(keyword); // This method must exist in StudentDataBase
    }

    // Method to display the menu
    public void display_interface() {

        System.out.println("\n\n\n========== Student Information System ==========");
        
        System.out.println();
        
        System.out.println("[1] Add Student");
        System.out.println("[2] Display All Student");
        System.out.println("[3] Search Student");
        System.out.println("[4] Delete/Edit Student");
        System.out.println("[0] Exit");
        
        System.out.println();
    }

    // Displays All Students
    /**
     * 
     */
    public void displayAllStudent() {
        List<StudentData> students = studentDB.getAllStudents(); // get the list from DB

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        // Sort alphabetically by last name
        students.sort(Comparator.comparing(s -> {
            String[] parts = s.getFullName().split(",");
            return parts[0].trim().toLowerCase(); // assuming "LastName, FirstName MI"
        }));

        System.out.println("\n============== Student Data: ==============");
        System.out.printf("%-10s | %-25s | %-4s | %-10s | %-10s\n", "Student No", "Name", "Sex", "Course", "Section");
        System.out.println("---------------------------------------------------------------");

        for (StudentData s : students) {
            System.out.printf("%-10s | %-25s | %-4s | %-10s | %-10s\n",
                    s.getStudentNo(),
                    s.getFullName(),
                    s.getSex(),
                    s.getCourse(),
                    s.getSection());
        }
    }

    // Method for deleting student information
    public void deleteStudent() {
        System.out.print("Enter Student No. to delete: ");
        String studentNo = scanner.nextLine();

        boolean deleted = studentDB.deleteStudent(studentNo);
        if (deleted) {
            System.out.println("Student successfully deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // method for editing student information
    public void editStudent() {
        System.out.print("Enter Student No. to edit: ");
        String studentNo = scanner.nextLine();

        System.out.print("Enter new full name (leave blank to keep current): ");
        String newFullName = scanner.nextLine();

        System.out.print("Enter new course (leave blank to keep current): ");
        String newCourse = scanner.nextLine();

        System.out.print("Enter new section (leave blank to keep current): ");
        String newSection = scanner.nextLine();

        System.out.print("Enter new sex (leave blank to keep current): ");
        String newSex = scanner.nextLine();

        boolean updated = studentDB.editStudent(studentNo, newFullName, newCourse, newSection, newSex);
        
        if (updated) {
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}