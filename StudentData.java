import java.io.Serializable;

public class StudentData implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // Field declarations
    String fullName;
    String course;
    String section;
    String studentNo;
    String sex;

    // Constructor for StudentData
    public StudentData(String fullName, String course, String section, String studentNo, String sex) {
        this.fullName = fullName;
        this.course = course;
        this.section = section;
        this.studentNo = studentNo;
        this.sex = sex;
    }


    // Getters 
    public String getFullName(){
        return fullName;
    }

    public String getCourse(){
        return course;
    }

    public String getSection(){
        return section;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getSex(){
        return sex;
    }

    // setters
    public void setFullName(String fullName) {
    this.fullName = fullName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

@Override
    public String toString() {
        return studentNo + " | " + fullName + " | " + sex + " | " + course + " | " + section;
    }
}