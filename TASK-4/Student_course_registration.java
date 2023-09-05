import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseTitle, courseCode, courseDescription, courseSchedule;
    int courseCapacity, availableSlots;

    public Course(String title, String code, String description, String schedule, int capacity, int slots) {
        courseTitle = title;
        courseCode = code;
        courseDescription = description;
        courseSchedule = schedule;
        courseCapacity = capacity;
        availableSlots = slots;
    }

    public void showDetails() {
        System.out.println("Course Code: " + courseCode + "\nTitle: " + courseTitle + "\nDescription: "
                + courseDescription + "\nCapacity: " + courseCapacity + "\nSchedule: " + courseSchedule
                + "\nAvailable slots: " + availableSlots + "\n");
    }
}

class Student {
    String studentID, studentName;
    public List<Course> registeredCourses = new ArrayList<>();

    public void registerForThisCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.println("Already registered for this course");
        } else {
            course.availableSlots--;
            registeredCourses.add(course);
            System.out.println("You've Successfully registered for the course '" + course.courseTitle + "'.");
        }
    }

    public void dropFromThisCourse(Course course) {
        course.availableSlots++;
        registeredCourses.remove(course);
        System.out.println("Successfully dropped from the course '" + course.courseTitle + "'.");
    }

    public void showMyRegisteredCourses() {
        if (registeredCourses.size() > 0) {
            System.out.println(
                    "\nHere are the list of Courses you've registered earlier:\n*******************************************************");
            for (Course course : registeredCourses) {
                System.out.println("\n");
                course.showDetails();
            }
        } else {
            System.out.println("You haven't registered for any of the courses yet.");
        }
    }
}

public class Student_course_registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Course> availableCourses = new ArrayList<>();
        Student student = new Student();

        availableCourses.add(new Course("Multivariable Calculus", "MATH301",
                "Dive into calculus with multiple variables. Study functions, limits, and derivatives in higher dimensions.",
                "Mondays and Wednesdays, 1:00 PM - 2:30 PM", 15, 5));
        availableCourses.add(new Course("World History: 20th Century", "HIST202",
                "Explore the significant events and social changes that shaped the 20th century on a global scale.",
                "Tuesdays and Fridays, 10:00 AM - 11:30 AM", 8, 3));
        availableCourses.add(new Course("Introduction to Physics", "PHYS101",
                "Delve into the basics of physics, covering mechanics, energy, and motion. No prior physics knowledge required.",
                "Thursdays, 9:00 AM - 12:00 PM", 25, 15));
        availableCourses.add(new Course("Conversational Mandarin", "LANG401",
                "Learn practical Mandarin Chinese for daily conversations. Emphasis on speaking and listening skills.",
                "Wednesdays and Fridays, 4:00 PM - 5:30 PM", 12, 8));
        availableCourses.add(new Course("Entrepreneurship Essentials", "BUSN202",
                "Uncover the key principles of starting and managing a successful business venture. Guest speakers and case studies included.",
                "Tuesdays, 2:00 PM - 4:00 PM", 20, 6));

        System.out.println("\n\nStudent Registration:\n*********************");

        System.out.print("Enter Student Name:");
        student.studentName = scanner.nextLine();
        System.out.print("Enter Student ID:");
        student.studentID = scanner.nextLine();
        System.out.println("Student Registration Successful!");

        int choice = 0;
        while (choice != 5) {
            System.out.println(
                    "\nChoose an option:\n1.Register for a course\n2.drop from a course\n3.Show available courses\n4.Show my registered courses\n5.Exit");
            while (true) {
                System.out.print("Enter here:");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println(
                            "Bad input! choose numericals only and in range of 1 to 5 given as options above.");
                    continue;
                }
                if (!(choice > 0 && choice < 6)) {
                    System.out.println("Bad input! Enter numericals in range of 1 to 5 Only.");
                } else {
                    break;
                }
            }
            if (choice == 1) {
                System.out.println(
                        "\n\nSelect a course based on the index to register for it:\n****************************************************\n");
                for (int i = 0; i < availableCourses.size(); i++) {
                    System.out.print((i + 1) + ".");
                    availableCourses.get(i).showDetails();
                }
                System.out.print("Enter here:");
                int choice2 = 0;
                try {
                    choice2 = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Bad input! choose numericals only and in range of indexes above.");
                    continue;
                }
                if (choice2 > 0 && choice2 <= availableCourses.size()) {
                    student.registerForThisCourse(availableCourses.get(choice2 - 1));
                } else {
                    System.out.println("Bad input! You've choosen a course index that was unavailable.");
                    continue;
                }
            } else if (choice == 2) {
                if (student.registeredCourses.size() > 0) {
                    System.out.println(
                            "\n\nHere are your Registrations. Select one based on the index to drop it from your registered courses:\n***************************************************************************************************\n");
                    for (int i = 0; i < student.registeredCourses.size(); i++) {
                        System.out.print((i + 1) + ".");
                        student.registeredCourses.get(i).showDetails();
                    }
                    System.out.print("Enter here:");
                    int choice2 = 0;
                    try {
                        choice2 = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Bad input! choose numericals only and in range of indexes above.");
                        continue;
                    }
                    if (choice2 > 0 && choice2 <= student.registeredCourses.size()) {
                        student.dropFromThisCourse(student.registeredCourses.get(choice2 - 1));
                    } else {
                        System.out.println("Bad input! You've choosen a course index that was unavailable.");
                        continue;
                    }
                } else {
                    System.out.println("You haven't registered for any courses yet.");
                }
            } else if (choice == 3) {
                System.out.println(
                        "\n\nThese are the available courses for you to register:\n****************************************************");
                for (Course c : availableCourses) {
                    c.showDetails();
                }
            } else if (choice == 4) {
                student.showMyRegisteredCourses();
            } else if (choice == 5) {
                System.out.println("Thanks for spending your time here! Be sure to attend classes if registered.");
            }
        }
    }
}