import java.util.Scanner;

public class Student extends User {

  public Student() {
  }

  public Student(String userName, String password, String name) {
    super.name = name;
    super.userName = userName;
    super.password = password;

  }

  public void enroll(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.println("Please enter the course ID: ");
    String course = scanner.next();
    FileHandler fileHandler = new FileHandler();
    if (!fileHandler.doesCourseExist(course) && fileHandler.isStudEnrolled(currentUser, course)
        && fileHandler.isOneTeacher(course)) {
      fileHandler.enrollStud(currentUser, course);
    } else if (fileHandler.doesCourseExist(course)) {
      System.out.println();
      System.out.println("Course does not exist.");
    } else if (!fileHandler.isStudEnrolled(currentUser, course)) {
      System.out.println("You are already enrolled in this course.");
    } else if (!fileHandler.isOneTeacher(course)) {
      System.out.println();
      System.out.println("No teacher is assigned to this course. Please try again at a later time.");
    }
  }

  public void drop(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the course ID: ");
    String course = scanner.next();
    FileHandler fileHandler = new FileHandler();
    fileHandler.dropStud(currentUser, course);
  }

  public void checkGrades(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.checkGrades(currentUser);
  }

  public void checkCourses(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.checkCourses(currentUser);
  }

}
