import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class StudentDataBase {

    private List<StudentData> studentList = new ArrayList<>();
    private static final String FILE_NAME = "studentData.dat";
    
    // Method that reads the student data from the file and load it
    public StudentDataBase() {
        loadStudentData();
    }

    // Method for adding a student to the Array and saves it to the file
    public void addStudent(String fullName, String course, String section, String studentNo, String sex) {
        StudentData student = new StudentData(fullName, course, section, studentNo, sex);

        if (!studentList.contains(student)) {
            studentList.add(student);
            System.out.println("Student added.");
            saveStudentData();
        } else {
            System.out.println("Student already exists.");
        }
        
    }

    // Method for adding the student to the file
    private void saveStudentData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
            System.out.println("Student data saved.");
        } catch (IOException e) {
            System.out.println("Error saving student data." + e.getMessage());
        }
    }

    // Method for loading the student data from the file
    private void loadStudentData() {

        File file = new File(FILE_NAME);
        
        // Check if the file exists
        if (!file.exists() || file.length() == 0) {
            System.out.println("There is no " + FILE_NAME + " file.");
            studentList = new ArrayList<>();
            return;
        }

        // Try to load the data from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<StudentData>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading student data." + e.getMessage());
            e.printStackTrace();
        }
    }

    // ✅ Method to search for students
    public void searchStudent(String keyword) {
        
        // Check if the keyword is empty
        boolean found = false;
        keyword = keyword.toLowerCase();

        // Iterate through the list of students
        for (StudentData student : studentList) {
             String[] nameParts = student.getFullName().toLowerCase().split("[,\\s]+");

        boolean nameMatches = false;

        // Check if the keyword matches any part of the student's name
        for (String part : nameParts) {
            if (part.contains(keyword)) {
                nameMatches = true;
                break;
            }
        }

        // Check if the keyword matches the student's Section
        boolean sectionMatches = student.getSection().toLowerCase().contains(keyword);

        // If the keyword matches either the name or the section, print the student's data
        if (nameMatches || sectionMatches) {
            System.out.println(student); // uses toString()
            found = true;
        }
    }

    // If no students were found, print a message
    if (!found) {
        System.out.println("No matching student found.");
    }
}

    // (Optional) Method to get all students — useful for displayAllStudent()
    public List<StudentData> getAllStudents() {
        return studentList;
    }
}