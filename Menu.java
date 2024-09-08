import java.util.Scanner;

public class Menu {

  private String currentUser;
  private String userType;

  public boolean auth() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("Enter your username");
      String username = scanner.nextLine();
      System.out.println();
      System.out.println("Enter your password");
      String password = scanner.nextLine();
      if (username.equals("admin") && password.equals("admin")) {
        setCurrentUser("admin");
        setUserType("admin");
        return true;
      } else if (fileHandler.authTeacher(username, password)) {
        setCurrentUser(username);
        setUserType("teacher");
        return true;
      } else if (fileHandler.authStud(username, password)) {
        setCurrentUser(username);
        setUserType("student");
        return true;
      } else {
        System.out.println();
        System.out.println("Incorrect Username or Password." + "\n" + "Do you want to try again? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("N")) {
          keepGoing = false;
          return false;
        }
      }
    }
    return false;
  }

  public void mainProgram() {
    if (auth()) {
      if (userType == "admin") {
        adminMenu();
      } else if (userType == "teacher") {
        teacherMenu();
      } else if (userType == "student") {
        studentMenu();
      }
    }
  }

  public void adminMenu() {
    Scanner scanner = new Scanner(System.in);
    int userChoice;
    Admin admin = new Admin();
    System.out.println("Welcome " + currentUser + "!");
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println();
    System.out.println("1. Add new Tecaher");
    System.out.println("2. Add new Student");
    System.out.println("3. Add new Course");
    System.out.println("4. Remove a Teacher");
    System.out.println("5. Remove a Student");
    System.out.println("6. Remove a Course");
    System.out.println("7. View all Teachers");
    System.out.println("8. View all Students");
    System.out.println("9. View all Courses");
    System.out.println("10. Log out \n");
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println();
      System.out.println("Please enter your choice: ");
      userChoice = scanner.nextInt();
      System.out.println();
      if (userChoice == 1) {
        admin.createTeacher();
      } else if (userChoice == 2) {
        admin.createStudent();
      } else if (userChoice == 3) {
        admin.createCourse();
      } else if (userChoice == 4) {
        admin.delTeacher();
      } else if (userChoice == 5) {
        admin.delStud();
      } else if (userChoice == 6) {
        admin.delCourse();
      } else if (userChoice == 7) {
        admin.viewTeachers();
      } else if (userChoice == 8) {
        admin.viewStuds();
      } else if (userChoice == 9) {
        admin.viewCourses();
      } else if (userChoice == 10) {
        keepGoing = false;
        System.exit(0);
      } else {
        System.out.println();
        System.out.println("Invalid input. Please try again.");
      }
    }
  }

  void teacherMenu() {
    Scanner scanner = new Scanner(System.in);
    Teacher teacher = new Teacher();
    int userChoice;
    System.out.println();
    System.out.println("Welcome " + currentUser + "!");
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println();
    System.out.println("1. Enroll in a course");
    System.out.println("2. Drop a course");
    System.out.println("3. Add student to courses ");
    System.out.println("4. Remove a student from course");
    System.out.println("5. Assign grade to student");
    System.out.println("6. View all students");
    System.out.println("7. My enrollments");
    System.out.println("8. Log out \n");
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println();
      System.out.println("Please enter your choice: ");
      userChoice = scanner.nextInt();
      System.out.println();
      if (userChoice == 1) {
        teacher.enroll(currentUser);
      } else if (userChoice == 2) {
        teacher.drop(currentUser);
      } else if (userChoice == 3) {
        teacher.addStud(currentUser);
      } else if (userChoice == 4) {
        teacher.dropStud(currentUser);
      } else if (userChoice == 5) {
        teacher.updateGrade(currentUser);
      } else if (userChoice == 6) {
        teacher.viewStuds(currentUser);
      } else if (userChoice == 7) {
        teacher.viewEnrollments(currentUser);
      } else if (userChoice == 8) {
        keepGoing = false;
        System.exit(0);
      } else {
        System.out.println();
        System.out.println("Invalid input. Please try again.");
      }
    }
  }

  void studentMenu() {
    Scanner scanner = new Scanner(System.in);
    Student student = new Student();
    int userChoice;
    System.out.println();
    System.out.println("Welcome " + currentUser + "!");
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println();
    System.out.println("1. Enroll in a course");
    System.out.println("2. Drop a course");
    System.out.println("3. My Grades");
    System.out.println("4. Enrolled Courses");
    System.out.println("5. Log out \n");
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println();
      System.out.println("Please enter your choice: ");
      userChoice = scanner.nextInt();
      System.out.println();
      if (userChoice == 1) {
        student.enroll(currentUser);
      } else if (userChoice == 2) {
        student.drop(currentUser);
      } else if (userChoice == 3) {
        student.checkGrades(currentUser);
      } else if (userChoice == 4) {
        student.checkCourses(currentUser);
      } else if (userChoice == 5) {
        keepGoing = false;
        System.exit(0);
      } else {
        System.out.println();
        System.out.println("Invalid input. Please try again.");
      }
    }
  }

  public void setCurrentUser(String currentUser) {
    this.currentUser = currentUser;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

}
