import java.util.List;
import java.util.ArrayList;

public class StudentDataBase {

    private List<StudentData> studentList = new ArrayList<>();
    
    public StudentDataBase() {
        studentList = new ArrayList<>();
    }

    public void addStudent(String fullName, String course, String section, String studentNo, String sex) {
    studentList.add(new StudentData(fullName, course, section, studentNo, sex));
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
}