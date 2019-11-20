package io.github.deleuze199;

import java.util.regex.Pattern;

public class Employee {

  StringBuilder name;
  String username;
  String password;
  String email;

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
    StringBuilder nameSB = new StringBuilder(name);
    this.name = nameSB;
    if (name.contains(" ")) {
      return true;
    } else {
      return false;
    }
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
