import java.util.*;


class Person {
  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() { return this.firstName; }
  public String getLastName() { return this.lastName; }
}

public class Sample_Data {
  public static void main(String[] args) {
    // Implement class file or using the record class
    // records are immutable data class
    // A record cannot inherit from anything.
    // Records are final by specification. You may implement interfaces
    
    Person person = new Person("Thando", "Ncube");
    String message = "This is my name (f) and my last name is (l)";
      message.replace("(f)", person.getFirstName().toString());
      message.replaceFirst("(l)", person.getLastName());
    System.out.println(person.getFirstName() + "\n" + message);
  }
}
