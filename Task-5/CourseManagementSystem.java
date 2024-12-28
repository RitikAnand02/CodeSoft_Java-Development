import java.util.*;

class Course {
    String code;
    String title;
    String description;
    String schedule;
    int capacity;
    int registeredCount;

    public Course(String code, String title, String description, String schedule, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.capacity = capacity;
        this.registeredCount = 0;
    }

    public boolean hasSpace() {
        return registeredCount < capacity;
    }

    public void incrementRegistration() {
        if (hasSpace())
            registeredCount++;
    }

    public void decrementRegistration() {
        if (registeredCount > 0)
            registeredCount--;
    }

    public void displayCourse() {
        System.out.println("Course Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Schedule: " + schedule);
        System.out.println("Capacity: " + capacity + ", Registered: " + registeredCount);
        System.out.println("Available Slots: " + (capacity - registeredCount));
        System.out.println("-----------------------------");
    }
}

class Student {
    String studentID;
    String name;
    List<String> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses: " + registeredCourses);
        System.out.println("-----------------------------");
    }
}

public class CourseManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Course> courseList = new ArrayList<>();
    private static final List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        System.out.println("===== Welcome to Course Management System =====");

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addStudent();
                case 3 -> listCourses();
                case 4 -> registerCourse();
                case 5 -> dropCourse();
                case 6 -> System.out.println("Exiting the system. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Add a New Course");
        System.out.println("2. Add a New Student");
        System.out.println("3. List All Courses");
        System.out.println("4. Register Student for a Course");
        System.out.println("5. Drop a Course for a Student");
        System.out.println("6. Exit");
    }

    private static void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Course Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Course Schedule: ");
        String schedule = scanner.nextLine();
        System.out.print("Enter Course Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        courseList.add(new Course(code, title, description, schedule, capacity));
        System.out.println("Course added successfully!");
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        studentList.add(new Student(studentID, name));
        System.out.println("Student added successfully!");
    }

    private static void listCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available!");
            return;
        }

        System.out.println("===== Course List =====");
        for (Course course : courseList) {
            course.displayCourse();
        }
    }

    private static void registerCourse() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = findStudentByID(studentID);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code to Register: ");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Course not found!");
        } else if (!course.hasSpace()) {
            System.out.println("Course is full!");
        } else {
            student.registeredCourses.add(courseCode);
            course.incrementRegistration();
            System.out.println("Course registered successfully!");
        }
    }

    private static void dropCourse() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = findStudentByID(studentID);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code to Drop: ");
        String courseCode = scanner.nextLine();

        if (student.registeredCourses.remove(courseCode)) {
            Course course = findCourseByCode(courseCode);
            if (course != null)
                course.decrementRegistration();
            System.out.println("Course dropped successfully!");
        } else {
            System.out.println("Course not found in student's registered courses!");
        }
    }

    private static Student findStudentByID(String studentID) {
        for (Student student : studentList) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courseList) {
            if (course.code.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
