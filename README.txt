STUDENT MANAGEMENT SYSTEM - JAVA MINI PROJECT

WHAT THIS PROJECT DOES
- Add a student
- Search a student by ID
- Update student details
- Delete a student
- Display all students
- Calculate a grade and generate a result
- Display the number of Student objects created

JAVA CONCEPTS COVERED
1. Classes and Objects: Student, Person, StudentManager, and Main.
2. Constructors: Student has two constructors.
3. Method Overloading: updateDetails() and displayDetails() have overloaded versions.
4. Inheritance: Student extends Person.
5. Interface: Student implements Result.
6. Package: All source files are in the studentmanagement package.
7. Static Members: studentCount and getStudentCount() belong to the Student class.
8. Access Specifiers: private, protected, and public are used.

HOW TO RUN IN VS CODE
1. Extract Student_Management_System.zip.
2. Open the extracted Student_Management_System folder in VS Code.
3. Make sure the Java JDK is installed.
4. Open Terminal > New Terminal.
5. Run these commands from the project root folder:

   javac studentmanagement/*.java
   java studentmanagement.Main

If the wildcard command does not work in your terminal, compile all four .java files using VS Code's Java support or run:
   javac studentmanagement/Person.java studentmanagement/Result.java studentmanagement/Student.java studentmanagement/StudentManager.java studentmanagement/Main.java
   java studentmanagement.Main

SAMPLE TEST
Choose 1 and enter:
ID: 101
Name: Ayesha
Age: 18
Marks: 66

Then choose 5 to display the student, or 6 and enter ID 101 to generate the result.
Expected grade for 86 marks: A
Expected status: PASS

NOTES
- Student IDs must be unique.
- Marks must be between 0 and 100.
- Data is stored in memory while the program is running. When you exit, the data is not saved to a database or file.
