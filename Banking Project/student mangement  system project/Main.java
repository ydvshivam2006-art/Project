import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("----------------------");
    }
}

public class Main {

    static ArrayList<Student> list = new ArrayList<Student>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student s = new Student(id, name, age, course);
                list.add(s);

                System.out.println("Student Added");
            }

            else if (choice == 2) {
                for (Student s : list) {
                    s.display();
                }
            }

            else if (choice == 3) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                for (Student s : list) {
                    if (s.id == id) {
                        s.display();
                    }
                }
            }

            else if (choice == 4) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                Iterator<Student> it = list.iterator();
                while (it.hasNext()) {
                    Student s = it.next();
                    if (s.id == id) {
                        it.remove();
                        System.out.println("Student Deleted");
                    }
                }
            }

        } while (choice != 5);

        sc.close();
    }
}
