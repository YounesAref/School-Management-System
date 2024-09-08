public class Course {
  private String courseID;
  private String courseName;

  public Course(String courseName, String courseID) {
    this.courseID = courseID;
    this.courseName = courseName;
  }

  public String getCourseID() {
    return courseID;
  }

  public String getCourseName() {
    return courseName;
  }
}
