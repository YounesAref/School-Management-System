public class Enrollment {
  private String userName;
  private String courseID;
  private String grade;

  public Enrollment(String userName, String courseID, String grade) {
    this.userName = userName;
    this.courseID = courseID;
    this.grade = grade;
  }

  public Enrollment(String userName, String courseID) {
    this.userName = userName;
    this.courseID = courseID;
  }

  public String getUserName() {
    return userName;
  }

  public String getCourseID() {
    return courseID;
  }

  public String getGrade() {
    return grade;
  }

  public void setStudUserName(String userName) {
    this.userName = userName;
  }

  public void setCourseID(String courseID) {
    this.courseID = courseID;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }
}
