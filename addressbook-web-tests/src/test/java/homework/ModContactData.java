package homework;

import java.util.Objects;

public final class ModContactData {
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;

  public ModContactData(String firstname, String lastname, String mobile, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
  }

  public String firstname() {
    return firstname;
  }

  public String lastname() {
    return lastname;
  }

  public String mobile() {
    return mobile;
  }

  public String email() {
    return email;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (ModContactData) obj;
    return Objects.equals(this.firstname, that.firstname) &&
            Objects.equals(this.lastname, that.lastname) &&
            Objects.equals(this.mobile, that.mobile) &&
            Objects.equals(this.email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, mobile, email);
  }

  @Override
  public String toString() {
    return "ModContactData[" +
            "firstname=" + firstname + ", " +
            "lastname=" + lastname + ", " +
            "mobile=" + mobile + ", " +
            "email=" + email + ']';
  }


}