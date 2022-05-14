import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Student {
  public static List<Student> students = new ArrayList<>();

  private int rating;
  private String name;

  public Student() {
    Student.students.add(this);
  }

  public Student(String name) {
    this.name = name;

    Student.students.add(this);
  }

  public Student(String name, int rating) {
    this.name = name;
    this.rating = rating;

    Student.students.add(this);
  }

  public static double getAvgRating() {
    if (students.size() == 0) {
      return 0.0d;
    }

    double totalRating = 0;
    for (Student student: students) {
      totalRating = totalRating + student.rating;
    }

    return totalRating / students.size();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRating() {
    return this.rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public boolean betterStudent(Student student) {
    return this.rating > student.rating;
  }

  public void changeRating(int rating) {
    this.rating = rating;
  }

  public static void removeStudent(Student student) {
    Student.students.remove(student);
  }

  @Override
  public String toString() {
    return String.format("%s, %s", this.name, this.rating);
  }

  public static void main(String[] args) {
    Student student1 = new Student("Olga");
    student1.setRating(15);

    Student student2 = new Student("Vladimir");
    student2.setRating(30);

    Student student3 = new Student("Anna");
    student3.setRating(30);

    System.out.println("AVG rating = " + Student.getAvgRating());

    student2.changeRating(51);
    System.out.println("AVG rating = " + Student.getAvgRating());
  }
}