package model;

import java.util.Objects;

public final class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String group;

  public ContactData(String firstname, String lastname, String mobile, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
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
    var that = (ContactData) obj;
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
    return "GroupContact[" +
            "firstname=" + firstname + ", " +
            "lastname=" + lastname + ", " +
            "mobile=" + mobile + ", " +
            "email=" + email + ']';
  }

  public String getGroup() {
    return group;
  }
}