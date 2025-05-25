import java.io.*;
import java.util.*;

public class StudentDataBase {

    private ArrayList<StudentData> studentDataList = new ArrayList<>(); // ArrayList to store StudentData objects
    private HashMap<String, StudentData> studentMap = new HashMap<>(); // HashMap to store StudentData objects with student ID as key and easy to find student data by ID

    public void main(String fullName, String course, String section, String studentNo, String sex) {
        if (studentMap.containsKey(studentNo)){ // Check if student ID already exists in HashMap
            System.out.println("Student already exists.");
            return;
        }

        StudentData student = new StudentData(fullName, course, section, studentNo, sex); // Create a new StudentData object

        studentDataList.add(student); // Add the new StudentData object to the ArrayList
        studentMap.put(studentNo, student); // Add the new StudentData object to the HashMap with student ID as key
        System.out.println("Student Added Successfully!\n");
    }

    // Method for saving student data to a file3
    public void saveToFile(String studentData) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("studentData.txt"))) {
            for (StudentData s : studentDataList) {
                writer.println(String.join(s.getFullName(), s.getCourse(), s.getSection(), s.getStudentNo(), s.getSex()));
            }
        } catch (IOException e) {

        }
    }
}