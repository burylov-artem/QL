package mail.test;

public class DateAuthorization {
  private final String username;
  private final String userpassword;

  public DateAuthorization(String username, String userpassword) {
    this.username = username;
    this.userpassword = userpassword;
  }

  public String getUsername() {
    return username;
  }

  public String getUserpassword() {
    return userpassword;
  }
}
