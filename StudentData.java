import java.io.Serializable;

public class StudentData implements Serializable {

    String fullName;
    String course;
    String section;
    String studentNo;
    String sex;

    public StudentData(String fullName, String course, String section, String studentNo, String sex) {
        this.fullName = fullName;
        this.course = course;
        this.section = section;
        this.studentNo = studentNo;
        this.sex = sex;
    }


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
    
@Override
    public String toString() {
        return studentNo + " | " + fullName + " | " + " | " + sex + " | " + course + " | " + section;
    }
}