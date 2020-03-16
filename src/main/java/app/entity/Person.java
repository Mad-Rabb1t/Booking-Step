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
    return Objects.equals(first.toLowerCase().trim(), person.first.toLowerCase().trim()) &&
            Objects.equals(last.toLowerCase().trim(), person.last.toLowerCase().trim());
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return String.format("%s %s", first, last);
  }
}
