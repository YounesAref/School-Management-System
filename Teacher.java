import java.util.Scanner;

public class Teacher extends User {

  public Teacher() {
  }

  public Teacher(String userName, String password, String name) {
    super.name = name;
    super.userName = userName;
    super.password = password;
  }

  public void addStud(String currentUser) {
    boolean keepGoing = true;
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    while (keepGoing) {
      System.out.println();
      System.out.println("Please enter student's username: ");
      String studUserName = scanner.nextLine();
      System.out.println();
      System.out.println("Please enter course ID: ");
      String courseID = scanner.nextLine();
      if (fileHandler.doesStudExist(studUserName) && !fileHandler.doesCourseExist(courseID)
          && fileHandler.isStudEnrolled(studUserName, courseID)
          && !fileHandler.isTeacherEnrolled(currentUser, courseID)) {
        fileHandler.enrollStud(studUserName, courseID);
        keepGoing = false;
      } else if (fileHandler.isTeacherEnrolled(currentUser, courseID)) {
        System.out.println();
        System.out.println("You are not enrolled in this course.");
      } else if (!fileHandler.isStudEnrolled(studUserName, courseID)) {
        System.out.println();
        System.out.println("Student is already enrolled in this course.");
      } else {
        System.out.println();
        System.out.println("Student does not exist or course does not exis");
        System.out.println();
        System.out.println("If you want to try again, enter 1. If you want to exit, enter 0.");
        int choice = scanner.nextInt();
        if (choice == 0) {
          keepGoing = false;
        }
      }
    }
  }

  public void enroll(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.println("Please enter the course ID: ");
    String course = scanner.next();
    FileHandler fileHandler = new FileHandler();
    if (!fileHandler.doesCourseExist(course) && fileHandler.isTeacherEnrolled(currentUser, course)
        && !fileHandler.isOneTeacher(course)) {
      fileHandler.enrollTeacher(currentUser, course);
    } else if (fileHandler.doesCourseExist(course)) {
      System.out.println();
      System.out.println("Course does not exist.");
    } else if (!fileHandler.isStudEnrolled(currentUser, course)) {
      System.out.println();
      System.out.println("You are already enrolled in this course.");
    } else if (fileHandler.isOneTeacher(course)) {
      System.out.println();
      System.out.println("Another teacher is already enrolled in this course.");
    }
  }

  public void drop(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.println("Please enter the course ID: ");
    String course = scanner.next();
    System.out.println();
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.dropTeacher(currentUser, course);
    fileHandler.delCourseStudEnroll(course);
  }

  public void dropStud(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    System.out.println("Please enter the student's username: ");
    String studUserName = scanner.next();
    System.out.println();
    System.out.println("Please enter the course ID: ");
    String courseID = scanner.next();
    System.out.println();
    if (!fileHandler.isTeacherEnrolled(currentUser, courseID)) {
      fileHandler.dropStud(studUserName, courseID);
    }
  }

  public void updateGrade(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    System.out.println("Please enter the student's username: ");
    String studUserName = scanner.next();
    System.out.println();
    System.out.println("Please enter the course ID: ");
    String courseID = scanner.next();
    System.out.println();
    System.out.println("Please enter the new grade: ");
    String newGrade = scanner.next();
    System.out.println();
    if (!fileHandler.isTeacherEnrolled(currentUser, courseID)) {
      fileHandler.updateGrade(studUserName, courseID, newGrade);
    } else if (fileHandler.isTeacherEnrolled(currentUser, courseID)) {
      System.out.println();
      System.out.println("You are not enrolled in this course.");
    } else {
      System.out.println();
      System.out.println("Student is not enrolled in this course.");
    }
  }

  public void viewStuds(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.viewStudsTeacher(currentUser);
  }

  public void viewEnrollments(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.checkEnrollments(currentUser);
  }

}
