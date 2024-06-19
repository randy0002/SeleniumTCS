import java.util.Random;

public class Student {
    private int studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob; // Date of Birth

    // Constructor
    public Student(String firstName, String middleName, String lastName, String dob) {
        this.studentId = new Random().nextInt(10000); // Random number as Student ID
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
    }

    // Method to concatenate first, middle, and last name
    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Display method
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + dob);
    }

    // Main method to create instances and display details
    public static void main(String[] args) {
        Student student1 = new Student("John", "A.", "Doe", "01/01/2000");
        Student student2 = new Student("Jane", "B.", "Smith", "02/02/2001");
        Student student3 = new Student("Jim", "C.", "Brown", "03/03/2002");

        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student3.displayStudentDetails();
    }
}
