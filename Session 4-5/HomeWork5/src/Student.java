import java.util.Random;

public class Student {
    private int studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob; // Date of Birth

    public Student(String firstName, String middleName, String lastName, String dob) {
        this.studentId = new Random().nextInt(10000); // Random number as Student ID
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + dob);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Randy", "Chilpa.", "Camacho", "02/12/1995");
        Student student2 = new Student("Lucero", "Maqueda.", "Valdez", "28/06/1998");
        Student student3 = new Student("Marcos", "Castro.", "castro", "03/03/2002");

        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student3.displayStudentDetails();
    }
}
