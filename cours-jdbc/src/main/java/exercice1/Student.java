package exercice1;

import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String dateDegree;
    private String classNumber;

    public Student(String firstName, String lastName, String dateDegree, String classNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateDegree = dateDegree;
        this.classNumber = classNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateDegree() {
        return dateDegree;
    }

    public void setDateDegree(String dateDegree) {
        this.dateDegree = dateDegree;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public boolean save() {
        return false;
    }

    public boolean delete() {
        return false;
    }

    public List<Student> getAll() {
        return null;
    }

    public List<Student> getByClass(int classNumber) {
        return null;
    }
}
