import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "";
        int subjects = 0;
        int[] marks = null;

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n=================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Display Result");
            System.out.println("3. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            // Option 1: Enter student details
            if (choice == 1) {

                System.out.print("Enter student name: ");
                name = sc.nextLine();

                System.out.print("Enter number of subjects: ");
                subjects = sc.nextInt();

                // Validate number of subjects
                while (subjects <= 0) {

                    System.out.println("Invalid number of subjects!");
                    System.out.print("Enter number of subjects again: ");

                    subjects = sc.nextInt();
                }

                // Create marks array
                marks = new int[subjects];

                // Enter marks
                for (int i = 0; i < subjects; i++) {

                    System.out.print(
                            "Enter marks for subject " + (i + 1) + ": "
                    );

                    int mark = sc.nextInt();

                    // Validate marks
                    while (mark < 0 || mark > 100) {

                        System.out.println(
                                "Invalid marks! Please enter marks between 0 and 100."
                        );

                        System.out.print("Enter marks again: ");
                        mark = sc.nextInt();
                    }

                    marks[i] = mark;
                }

                System.out.println("\nStudent details saved successfully!");
            }

            // Option 2: Display result
            else if (choice == 2) {

                if (marks == null) {

                    System.out.println(
                            "\nPlease enter student details first!"
                    );

                } else {

                    // Calculate total
                    int total = 0;

                    for (int i = 0; i < subjects; i++) {
                        total = total + marks[i];
                    }

                    // Calculate average
                    double average = (double) total / subjects;

                    // Find highest and lowest
                    int highest = marks[0];
                    int lowest = marks[0];

                    for (int i = 1; i < subjects; i++) {

                        if (marks[i] > highest) {
                            highest = marks[i];
                        }

                        if (marks[i] < lowest) {
                            lowest = marks[i];
                        }
                    }

                    // Calculate grade
                    String grade;

                    if (average >= 90) {
                        grade = "A+";
                    } else if (average >= 80) {
                        grade = "A";
                    } else if (average >= 70) {
                        grade = "B";
                    } else if (average >= 60) {
                        grade = "C";
                    } else if (average >= 50) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    // Display report
                    System.out.println("\n=================================");
                    System.out.println("       STUDENT GRADE REPORT");
                    System.out.println("=================================");

                    System.out.println("Student Name  : " + name);
                    System.out.println("Subjects      : " + subjects);

                    System.out.println("\nSubject-wise Marks:");

                    for (int i = 0; i < subjects; i++) {
                        System.out.println(
                                "Subject " + (i + 1) + "     : " + marks[i]
                        );
                    }

                    System.out.println("\n---------------------------------");

                    System.out.println("Total Marks   : " + total);
                    System.out.println("Average Marks : " + average);
                    System.out.println("Highest Marks : " + highest);
                    System.out.println("Lowest Marks  : " + lowest);
                    System.out.println("Grade         : " + grade);

                    System.out.println("=================================");
                }
            }

            // Option 3: Exit
            else if (choice == 3) {

                System.out.println(
                        "\nThank you for using Student Grade Tracker!"
                );

            }

            // Invalid choice
            else {

                System.out.println(
                        "\nInvalid choice! Please choose 1, 2, or 3."
                );
            }
        }

        sc.close();
    }
}
