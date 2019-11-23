package io.github.deleuze199;

/**
 * This is the Employee Class it is responsible for setting username, password, and email for a
 * employee.
 *
 * @author Benjamin Deleuze
 * @version a.1.3 11/23/2019
 */
class Employee {

  // The employee's credentials.
  private StringBuilder name;
  private String username;
  private String password;
  private String email;

  /**
   * This is a Constructor for the Employee class. It sets the username, password, and email for the
   * employee.
   *
   * @param name is the name of the employee(First and Last)
   * @param password is the password for the employee(at least 1 Uppercase, 1 Lowercase, and 1
   *     special character).
   */
  Employee(String name, String password) {
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * This is the checkName method. I check to see if the name given contains a space.
   *
   * @param name is the name(First and last) give by the employee.
   * @return true is the name contains a space.
   */
  private boolean checkName(String name) {
    this.name = new StringBuilder(name);
    return name.contains(" ");
  }

  /**
   * this is the setUsername method. If the name given contained a space then the username is set to
   * the first character of the first name followed by last name. if the name does not contain a
   * space the username is set to "default".
   *
   * @param name is the name given by the employee.
   */
  private void setUsername(String name) {
    username = name.toLowerCase().charAt(0) + name.substring(name.indexOf(" ") + 1).toLowerCase();
  }

  /**
   * This is the setEmail method. If the name given contains a space then the email is set to the
   * first name + "." + the last name + "@oracleacademy.Test". If the name given does not contains a
   * space then the email is set to "user@oracleacademy.Test".
   *
   * @param name is the name given by the employee.
   */
  private void setEmail(String name) {
    String firstName = name.substring(0, name.indexOf(" ")).toLowerCase();
    String lastName = name.substring(name.indexOf(" ") + 1).toLowerCase();
    email = firstName + "." + lastName + "@oracleacademy.Test";
  }

  /**
   * this is the isValidPassword method. It check to see if the password contain at least 1
   * Uppercase, 1 Lowercase, and 1 special character. If is does then the password is set to
   * password given by the employee. if it does not then the password is set to "pw".
   *
   * @param password is the password given by the employee.
   * @return true is the password contains at least 1 * Uppercase, 1 Lowercase, and 1 special
   *     character.
   */
  private boolean isValidPassword(String password) {
    if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).+$")) {
      this.password = password;
      return true;
    } else {
      this.password = "pw";
      return false;
    }
  }

  /**
   * This is the overridden toString method. It returns the name, username, email, and password as a
   * String.
   *
   * @return String containing employee's information.
   */
  @Override
  public String toString() {
    return "Employee Details\nName : "
        + name
        + "\nUsername : "
        + username
        + "\nEmail : "
        + email
        + "\nInitial Password : "
        + password;
  }
}
