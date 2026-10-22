package studentmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Generate Student Result");
            System.out.println("7. Show Student Count");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number: ");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = readInt(input);
                    if (manager.searchStudent(id) != null) {
                        System.out.println("This ID already exists. Use another ID.");
                        break;
                    }
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter age: ");
                    int age = readInt(input);
                    System.out.print("Enter marks out of 100: ");
                    double marks = readDouble(input);

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100. Student not added.");
                        break;
                    }
                    Student newStudent = new Student(id, name, age, marks);
                    manager.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID to search: ");
                    Student found = manager.searchStudent(readInt(input));
                    if (found == null) {
                        System.out.println("Student not found.");
                    } else {
                        found.displayDetails(true);
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = readInt(input);
                    if (manager.searchStudent(updateId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter new name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = readInt(input);
                    System.out.print("Enter new marks out of 100: ");
                    double newMarks = readDouble(input);
                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println("Marks must be between 0 and 100. Details not updated.");
                        break;
                    }
                    if (manager.updateStudent(updateId, newName, newAge, newMarks)) {
                        System.out.println("Student updated successfully!");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    if (manager.deleteStudent(readInt(input))) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    System.out.print("Enter student ID to generate result: ");
                    Student resultStudent = manager.searchStudent(readInt(input));
                    if (resultStudent == null) {
                        System.out.println("Student not found.");
                    } else {
                        resultStudent.generateResult();
                    }
                    break;

                case 7:
                    System.out.println("Total Student objects created: " + Student.getStudentCount());
                    break;

                case 0:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        input.close();
    }

    private static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a valid whole number: ");
            input.next();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    private static double readDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            input.next();
        }
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }
}
