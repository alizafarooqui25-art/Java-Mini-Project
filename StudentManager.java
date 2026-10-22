package studentmanagement;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (searchStudent(student.getId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, double marks) {
        Student student = searchStudent(id);
        if (student == null) return false;
        student.updateDetails(name, age, marks);
        return true;
    }

    public boolean deleteStudent(int id) {
        Student student = searchStudent(id);
        if (student == null) return false;
        students.remove(student);
        return true;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");
        for (Student student : students) {
            student.displayDetails(true);
            System.out.println("----------------------------------");
        }
        System.out.println("Students currently stored: " + students.size());
    }
}
