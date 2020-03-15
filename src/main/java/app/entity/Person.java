package app.entity;

import java.util.Objects;

public class Person {
  String first;
  String last;

  public Person(String first, String last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(first, person.first) &&
            Objects.equals(last, person.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return String.format("%s %s\n", first, last);
  }
}
