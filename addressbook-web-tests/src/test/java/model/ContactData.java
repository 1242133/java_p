package model;

import java.util.Objects;

public final class ContactData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String group;

  public ContactData(String firstname, String lastname, String mobile, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }
  public ContactData(int id, String firstname, String lastname, String mobile, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname) {
  }

  public String getName() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname)
            && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, mobile, email);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  public String getGroup() {
    return group;
  }

  public String getFirstname() {
    return firstname;
  }
}