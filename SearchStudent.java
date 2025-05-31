import java.util.List;

public class SearchStudent {
    private List<StudentData> studentList;

    public SearchStudent(List<StudentData> studentList) {
        this.studentList = studentList;
    }

public void searchStudent(String keyword) {
    boolean found = false;
    keyword = keyword.toLowerCase();

    for (StudentData student : studentList) {
        // Split full name to check both first and last names
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
}