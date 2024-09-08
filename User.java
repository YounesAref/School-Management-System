public abstract class User {
  protected String name;
  protected String password;
  protected String userName;
  protected String userType;

  public String getName() {
    return name;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getUserType() {
    return userType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
