import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
        if (!file.exists() || file.length() == 0) {
            System.out.println("There is no " + FILE_NAME + " file.");
            studentList = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<StudentData>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading student data." + e.getMessage());
            e.printStackTrace();
        }
    }

    // ✅ Method to search for students
    public void searchStudent(String keyword) {
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (StudentData student : studentList) {
             String[] nameParts = student.getFullName().toLowerCase().split("[,\\s]+");

        boolean nameMatches = false;
        for (String part : nameParts) {
            if (part.contains(keyword)) {
                nameMatches = true;
                break;
            }
        }

        boolean sectionMatches = student.getSection().toLowerCase().contains(keyword);

        if (nameMatches || sectionMatches) {
            System.out.println(student); // uses toString()
            found = true;
        }
    }

    if (!found) {
        System.out.println("No matching student found.");
    }
}

    // (Optional) Method to get all students — useful for displayAllStudent()
    public List<StudentData> getAllStudents() {
        return studentList;
    }
    
 
    // edit sutdent function
    public boolean editStudent(String studentNoToEdit, String newFullName, String newCourse, String newSection, String newSex) {
            StudentData studentToEdit = findStudentByStudentNo(studentNoToEdit);

            if (studentToEdit == null) {
                return false; // Student not found
            }

            // Update fields only if new value is provided and not empty
            if (newFullName != null && !newFullName.trim().isEmpty()) {
                try {
                    ((StudentData) studentToEdit).setFullName(newFullName.trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (newCourse != null && !newCourse.trim().isEmpty()) {
                studentToEdit.setCourse(newCourse.trim());
            }
            if (newSection != null && !newSection.trim().isEmpty()) {
                studentToEdit.setSection(newSection.trim());
            }
            if (newSex != null && !newSex.trim().isEmpty()) {
                studentToEdit.setSex(newSex.trim());
            }
            saveStudentData();
            return true; // Student updated successfully
    }

    StudentData findStudentByStudentNo(String studentNoToEdit) {
        for (StudentData student : studentList) {
            if (student.getStudentNo().equalsIgnoreCase(studentNoToEdit)) {
                return student;
            } 
        }
        return null;
    }


    // NEW: Method to delete a student
    public boolean deleteStudent(String studentNoToDelete) {
        Iterator<StudentData> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            StudentData student = iterator.next();
            if (student.getStudentNo().equalsIgnoreCase(studentNoToDelete)) {
                iterator.remove(); // Safe removal during iteration
                return true; // Student found and deleted
            }
        }
        return false; // Student not found
    }
    
    // Check if the student list is empty (useful for UI)
    public boolean isStudentListEmpty() {
        return studentList.isEmpty();
    }
}

