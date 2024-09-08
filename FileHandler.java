import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

  public boolean authStud(String userName, String password) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("student.csv"));
      String line;
      ArrayList<Student> list = new ArrayList<Student>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userNameF = data[0];
        String passwordF = data[1];
        String nameF = data[2];
        Student student = new Student(userNameF, passwordF, nameF);
        list.add(student);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName) && list.get(i).getPassword().equals(password)) {
          return true;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean authTeacher(String userName, String password) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacher.csv"));
      String line;
      ArrayList<Teacher> list = new ArrayList<Teacher>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userNameF = data[0];
        String passwordF = data[1];
        String nameF = data[2];
        Teacher teacher = new Teacher(userNameF, passwordF, nameF);
        list.add(teacher);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName) && list.get(i).getPassword().equals(password)) {
          return true;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean doesStudExist(String studUserName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("student.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains(studUserName)) {
          return true;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean doesCourseExist(String iD) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courseInfo.csv"));
      String line;
      ArrayList<Course> list = new ArrayList<Course>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String courseName = data[0];
        String courseID = data[1];
        Course course = new Course(courseName, courseID);
        list.add(course);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCourseID().equals(iD)) {
          return false;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public boolean doesTeacherExist(String userName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacher.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains(userName)) {
          return true;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean isTeacherEnrolled(String userName, String iD) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        list.add(enroll);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName) && list.get(i).getCourseID().equals(iD)) {
          return false;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public boolean isStudEnrolled(String studUserName, String iD) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        list.add(enroll);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(studUserName) && list.get(i).getCourseID().equals(iD)) {
          return false;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public void createStudAcc(String userName, String password, String name) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("student.csv", true));
      writer.write(userName + "," + password + "," + name + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void createTeacherAcc(String userName, String password, String name) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacher.csv", true));
      writer.write(userName + "," + password + "," + name + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void createCourse(String courseName, String courseID) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("courseInfo.csv", true));
      writer.write(courseName + "," + courseID + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewStuds() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("student.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        for (String index : data) {
          System.out.printf("%-15s", index);
        }
        System.out.println();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewTeachers() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacher.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        for (String index : data) {
          System.out.printf("%-15s", index);
        }
        System.out.println();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewCourses() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courseInfo.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        for (String index : data) {
          System.out.printf("%-15s", index);
        }
        System.out.println();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteTeacher(String teacherUserName) {
    String line = "";
    ArrayList<Teacher> list = new ArrayList<Teacher>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacher.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userName = data[0];
        String password = data[1];
        String name = data[2];
        Teacher teacher = new Teacher(userName, password, name);
        if (!teacher.getUserName().equals(teacherUserName)) {
          list.add(teacher);
        }
      }
      reader.close();
      String fileName = "teacher.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacher.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getPassword() + "," + list.get(i).getName() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteStud(String studUserName) {
    String line = "";
    ArrayList<Student> list = new ArrayList<Student>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("student.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userName = data[0];
        String password = data[1];
        String name = data[2];
        Student student = new Student(userName, password, name);
        if (!student.getUserName().equals(studUserName)) {
          list.add(student);
        }
      }
      reader.close();
      String fileName = "student.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("student.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getPassword() + "," + list.get(i).getName() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteCourse(String id) {
    String line = "";
    ArrayList<Course> list = new ArrayList<Course>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courseInfo.csv"));
      while ((line = reader.readLine()) != null) {
        String data[] = line.split(",");
        String courseName = data[0];
        String courseID = data[1];
        Course course = new Course(courseName, courseID);
        if (!course.getCourseID().equals(id)) {
          list.add(course);
        }
      }
      reader.close();
      String fileName = "courseInfo.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("courseInfo.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getCourseName() + "," + list.get(i).getCourseID() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isStudUnq(String newUserName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("student.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userName = data[0];
        String password = data[1];
        String name = data[2];
        Student student = new Student(userName, password, name);
        if (student.getUserName().equals(newUserName)) {
          return false;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public boolean isTeacherUnq(String newUserName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacher.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userName = data[0];
        String password = data[1];
        String name = data[2];
        Teacher teacher = new Teacher(userName, password, name);
        if (teacher.getUserName().equals(newUserName)) {
          return false;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public void enrollStud(String studUserName, String courseID) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("courses.csv", true));
      writer.write(studUserName + "," + courseID + "," + "N/A" + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void enrollTeacher(String teacherUserName, String courseID) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacherEnroll.csv", true));
      writer.write(teacherUserName + "," + courseID + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void dropStud(String studUserName, String id) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        if (enroll.getUserName().equals(studUserName) && enroll.getCourseID().equals(id)) {
        } else {
          list.add(enroll);
        }
      }

      reader.close();
      String fileName = "courses.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("courses.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "," + list.get(i).getGrade() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void dropTeacher(String teacherUserName, String id) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        if (enroll.getUserName().equals(teacherUserName) && enroll.getCourseID().equals(id)) {
        } else {
          list.add(enroll);
        }
      }
      reader.close();
      String fileName = "teacherEnroll.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacherEnroll.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void checkGrades(String userName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        list.add(enroll);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName)) {
          System.out.println(list.get(i).getCourseID() + ": " + list.get(i).getGrade());
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void checkCourses(String userName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        list.add(enroll);
      }
      System.out.println();
      System.out.println("Courses: ");
      System.out.println();
      int k = 0;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName)) {
          k++;
          System.out.println(k + ") " + list.get(i).getCourseID());
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void checkEnrollments(String currentUser) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        list.add(enroll);
      }
      int k = 0;
      System.out.println();
      System.out.println("Courses: ");
      System.out.println();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(currentUser)) {
          k++;
          System.out.println(k + ") " + list.get(i).getCourseID());
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void emptyFile(String fileName) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateGrade(String userName, String id, String newGrade) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        list.add(enroll);
      }
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getUserName().equals(userName) && list.get(i).getCourseID().equals(id)) {
          list.get(i).setGrade(newGrade);
        }
      }
      reader.close();
      emptyFile("courses.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter("courses.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "," + list.get(i).getGrade() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isOneTeacher(String id) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      String line;
      ArrayList<Enrollment> list = new ArrayList<Enrollment>();
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        list.add(enroll);
      }

      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCourseID().equals(id)) {
          return true;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void delTeacherEnrollments(String teacherUserName) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        if (!enroll.getUserName().equals(teacherUserName)) {
          list.add(enroll);
        }
      }
      reader.close();
      String fileName = "teacherEnroll.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacherEnroll.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void delStudEnrollments(String studUserName) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        if (enroll.getUserName().equals(studUserName)) {
        } else {
          list.add(enroll);
        }
      }

      reader.close();
      String fileName = "courses.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("courses.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "," + list.get(i).getGrade() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void delCourseStudEnroll(String id) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("courses.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        String grade = data[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        if (enroll.getCourseID().equals(id)) {
        } else {
          list.add(enroll);
        }
      }

      reader.close();
      String fileName = "courses.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("courses.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "," + list.get(i).getGrade() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void delCourseTeacherEnroll(String id) {
    String line = "";
    ArrayList<Enrollment> list = new ArrayList<Enrollment>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        if (enroll.getCourseID().equals(id)) {
        } else {
          list.add(enroll);
        }
      }

      reader.close();
      String fileName = "teacherEnroll.csv";
      emptyFile(fileName);
      BufferedWriter writer = new BufferedWriter(new FileWriter("teacherEnroll.csv", true));
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i).getUserName() + "," + list.get(i).getCourseID() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewStudsTeacher(String currentUser) {
    String line;
    ArrayList<Enrollment> teacherList = new ArrayList<Enrollment>();
    try {
      BufferedReader teacherReader = new BufferedReader(new FileReader("teacherEnroll.csv"));
      while ((line = teacherReader.readLine()) != null) {
        String[] data = line.split(",");
        String name = data[0];
        String courseID = data[1];
        Enrollment enroll = new Enrollment(name, courseID);
        if (enroll.getUserName().equals(currentUser)) {
          teacherList.add(enroll);
        }
      }
      BufferedReader studReader = new BufferedReader(new FileReader("courses.csv"));
      while ((line = studReader.readLine()) != null) {
        String[] studData = line.split(",");
        String name = studData[0];
        String courseID = studData[1];
        String grade = studData[2];
        Enrollment enroll = new Enrollment(name, courseID, grade);
        for (int i = 0; i < teacherList.size(); i++) {
          if (enroll.getCourseID().equals(teacherList.get(i).getCourseID())) {
            System.out.println("Student: " + name + " Course: " + courseID + " Grade: " + grade);
          }
        }
      }
      teacherReader.close();
      studReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
