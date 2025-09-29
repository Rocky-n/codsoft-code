import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements Serializable {
    String name;
    String rollNo;
    String grade;

    Student(String name, String rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String toString() {
        return rollNo + " - " + name + " - " + grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();
    String fileName = "students.dat";

    StudentManagementSystem() {
        loadData();
    }

    void addStudent(Student s) {
        students.add(s);
        saveData();
    }

    void removeStudent(String roll) {
        Student temp = null;
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(roll)) {
                temp = s;
                break;
            }
        }
        if (temp != null) {
            students.remove(temp);
            saveData();
            System.out.println("Removed Successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    Student searchStudent(String roll) {
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(roll)) {
                return s;
            }
        }
        return null;
    }

    void displayAll() {
        if (students.size() == 0) {
            System.out.println("No Students Found");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(students);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error while saving: " + e);
        }
    }

    void loadData() {
        try {
            File f = new File(fileName);
            if (!f.exists()) return;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error while loading: " + e);
        }
    }
}

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int ch = 0;

        while (ch != 5) {
            System.out.println("\n*** Student Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    if (roll.isEmpty() || name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Fields cannot be empty!");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                        System.out.println("Student Added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    String r = sc.nextLine();
                    sms.removeStudent(r);
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    String rs = sc.nextLine();
                    Student s = sms.searchStudent(rs);
                    if (s != null) {
                        System.out.println("Found: " + s);
                    } else {
                        System.out.println("Not Found");
                    }
                    break;

                case 4:
                    sms.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
