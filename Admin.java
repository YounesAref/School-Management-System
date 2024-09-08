import java.util.Scanner;

public class Admin extends User {

  public void createTeacher() {
    String name, userName, password;
    FileHandler fileHandler = new FileHandler();
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("Enter teacher name: ");
      name = scanner.nextLine();
      System.out.println();
      System.out.println("Enter username for teacher: ");
      userName = scanner.nextLine();
      System.out.println();
      System.out.println("Enter password for teacher: ");
      password = scanner.nextLine();
      System.out.println();
      if (!fileHandler.doesTeacherExist(userName) && fileHandler.isStudUnq(userName)
          && fileHandler.isTeacherUnq(userName)) {
        fileHandler.createTeacherAcc(userName, password, name);
        keepGoing = false;
      } else {
        System.out.println("Teacher already exists. Please try again.\n");
        System.out.println("Do you want to try again? Enter 1 for yes, 0 for no: ");
        int choice = scanner.nextInt();
        if (choice == 0) {
          keepGoing = false;
        }
      }
    }
  }

  public void createStudent() {
    String name, userName, password;
    FileHandler fileHandler = new FileHandler();
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("Enter student name: ");
      name = scanner.nextLine();
      System.out.println("Enter username for student: ");
      userName = scanner.nextLine();
      System.out.println("Enter password for stduent: ");
      password = scanner.nextLine();
      if (fileHandler.isStudUnq(userName) && fileHandler.isTeacherUnq(userName)) {
        fileHandler.createStudAcc(userName, password, name);
        keepGoing = false;
      } else {
        System.out.println("Student already exists. Please try again.");
        System.out.println("Do you want to try again? Enter 1 for yes, 0 for no: ");
        int choice = scanner.nextInt();
        if (choice == 0) {
          keepGoing = false;
        }
      }
    }
  }

  public void createCourse() {
    String name, courseID;
    FileHandler fileHandler = new FileHandler();
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("Enter course name: ");
      name = scanner.nextLine();
      System.out.println();
      System.out.println("Enter course ID: ");
      courseID = scanner.nextLine();
      System.out.println();
      if (fileHandler.doesCourseExist(courseID)) {
        fileHandler.createCourse(name, courseID);
        keepGoing = false;
      } else {
        System.out.println("Course ID already exists. Please try again.");
        System.out.println("Do you want to try again? Enter 1 for yes, 0 for no: ");
        int choice = scanner.nextInt();
        if (choice == 0) {
          keepGoing = false;
        }
      }
    }
  }

  public void viewStuds() {
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.viewStuds();
  }

  public void viewTeachers() {
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.viewTeachers();
  }

  public void viewCourses() {
    FileHandler fileHandler = new FileHandler();
    System.out.println();
    fileHandler.viewCourses();
  }

  public void delTeacher() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Enter username of teacher to delete: ");
    String userName = scanner.nextLine();
    fileHandler.deleteTeacher(userName);
    fileHandler.delTeacherEnrollments(userName);
  }

  public void delStud() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Enter username of Student to delete: ");
    String userName = scanner.nextLine();
    fileHandler.deleteStud(userName);
    fileHandler.delStudEnrollments(userName);

  }

  public void delCourse() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Enter course ID to delete: ");
    String courseName = scanner.nextLine();
    fileHandler.deleteCourse(courseName);
    fileHandler.delCourseTeacherEnroll(courseName);
    fileHandler.delCourseStudEnroll(courseName);
  }
}
