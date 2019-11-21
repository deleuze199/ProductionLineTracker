package io.github.deleuze199;

class Employee {

  private StringBuilder name;
  private String username;
  private String password;
  private String email;

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

  private boolean checkName(String name) {
    this.name = new StringBuilder(name);
    return name.contains(" ");
  }

  private void setUsername(String name) {
    username = name.toLowerCase().charAt(0) + name.substring(name.indexOf(" ") + 1).toLowerCase();
  }

  private void setEmail(String name) {
    String firstname = name.substring(0, name.indexOf(" ")).toLowerCase();
    String Lastname = name.substring(name.indexOf(" ") + 1).toLowerCase();
    email = firstname + "." + Lastname + "@oracleacademy.Test";
  }

  private boolean isValidPassword(String password) {
    if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).+$")) {
      this.password = password;
      return true;
    } else {
      this.password = "pw";
      return false;
    }
  }

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
