package implementation;

import list.SinglyLinkedList;

import java.util.NoSuchElementException;
import java.util.Scanner;

//----------------------------------------------------------------------------------------------------------------------

/**
 * Requirement3Executable is the main class for a clothing management program.
 */
public class Classroom {
    private Scanner kbd = new Scanner(System.in);
    SinglyLinkedList<Class> singlyList = new SinglyLinkedList<>();

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The main method is the entry point of the program.
     * @param args
     */
    public static void main(String[] args) {
        Classroom program = new Classroom();
        try {
            program.run();
        } catch (NoSuchElementException e) {
            System.out.println("\nProgram terminated.\n");
            e.printStackTrace();
        }
    } // end of main method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The run method contains the main program logic.
     */
    public void run() {
        int choice = 0;
        while (choice != 6) {
            mainMenu();
            choice = Integer.parseInt(readString("Please select from the options above: "));
            switch (choice) {
                case 1 -> addClassroom();
                case 2 -> deleteClassroom();
                case 3 -> renameClassroom();
                case 4 -> viewList();
                case 5 -> selectClassroom();
            }
        }
        System.out.println("\nProgram terminated.\n");
        System.exit(0);
    } // end of run method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The addClassroom method allows the user to add clothing items to the list.
     */
    public void addClassroom() {
        String courseName, courseCode, topicName;

        System.out.println("\nAdd a classroom: ");
        do {
            courseName = readString("Course Name: ");
            courseCode = readString("Course No.: ");
            topicName = readString("Topic Name: ");

            singlyList.insert(new Class(courseName, courseCode, topicName));

            System.out.print("\nDo you want to add another classroom? <y/n>: ");
        } while (kbd.nextLine().equalsIgnoreCase("y"));
    } // end of addClassroom method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The deleteClassroom method allows the user to delete clothing items from the list.
     */
    public void deleteClassroom() {
        String courseName, courseCode, topicName;

        System.out.println("\nDelete a classroom:");
        do {
            viewList();
            courseName = readString("Course Name: ");
            courseCode = readString("Course No.: ");
            topicName = readString("Topic Name: ");

            Class classroomToDelete = new Class(courseName, courseCode, topicName);
            boolean deletion = singlyList.delete(classroomToDelete);
            if (deletion) {
                System.out.println("\n" + topicName + " has been deleted.");
            } else {
                System.out.println("\n" + topicName + " has not been deleted. No match found.");
            }

            System.out.print("\nDo you want to delete another classroom? <y/n>: ");
        } while (kbd.nextLine().equalsIgnoreCase("y"));
    } // end of deleteClassroom method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The renameClassroom method allows the user to search for clothing items in the list.
     */
    public void renameClassroom() {
        String courseName, courseCode, topicName;
        String modifiedCourseName, modifiedCourseCode, modifiedTopicName;

        System.out.println("\nSelect a classroom you want to rename: ");
        do {
            viewList();
            courseName = readString("Course Name: ");
            courseCode = readString("Course Code: ");
            topicName = readString("Topic Name: ");

            Class classroomToSearch = new Class(courseName, courseCode, topicName);
            int index = singlyList.search(classroomToSearch);

            if (index != -1) {
                System.out.println("\nFound a match at position " + (index + 1) + ".");

                modifiedCourseName = readString("New Course Name: ");
                modifiedCourseCode = readString("New Course Code: ");
                modifiedTopicName = readString("New Topic Name: ");

                Class modifiedClassroom = new Class(modifiedCourseName, modifiedCourseCode, modifiedTopicName);

                singlyList.setElement(index, modifiedClassroom);
                System.out.println("Classroom has been renamed.");

            } else {
                System.out.println("\nNo match found.");
            }

            System.out.print("\nDo you want to rename another classroom? <y/n>: ");
        } while (kbd.nextLine().equalsIgnoreCase("y"));
    } // end of renameClassroom method

//----------------------------------------------------------------------------------------------------------------------

    public void selectClassroom() {
        String courseName, courseCode, topicName;

        System.out.println("\nSelect a classroom:");
        do {
            courseName = readString("Course Name: ");
            courseCode = readString("Course Code: ");
            topicName = readString("Topic Name: ");

            Class classroomToSearch = singlyList.getElement(new Class(courseName, courseCode, topicName));

            int index = singlyList.search(classroomToSearch);
            if (index != -1) {
                System.out.println("\nFound a match at position " + (index + 1) + ".");
                displayClassroomSubMenu();
            } else {
                System.out.println("\nNo match found.");
            }

            System.out.print("\nDo you want to search another classroom? <y/n>: ");
        } while (kbd.nextLine().equalsIgnoreCase("y"));
    } // end of addMaterials method

//----------------------------------------------------------------------------------------------------------------------

    public void displayClassroomSubMenu() {
        int choice = 0;
        while (choice != 3) {
            subMenu();
            choice = Integer.parseInt(readString("Please select from the options above: "));
            switch (choice) {
                case 1 -> addMaterials();
                case 2 -> deleteMaterials();
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The readString method reads a string input from the user.
     * @param promptMessage
     * @return
     */
    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return kbd.nextLine();
    } // end of readString method

//----------------------------------------------------------------------------------------------------------------------

    public void addMaterials() {

    }

//----------------------------------------------------------------------------------------------------------------------

    public void deleteMaterials() {

    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The mainMenu method displays the main menu options.
     */
    public void mainMenu() {
        System.out.println("==================================");
        System.out.println("|       CLOTHING MAIN MENU       |");
        System.out.println("| 1. Add classroom to list       |");
        System.out.println("| 2. Delete classroom from list  |");
        System.out.println("| 3. Rename classroom from list  |");
        System.out.println("| 4. View list                   |");
        System.out.println("| 5. Add materials to classroom  |");
        System.out.println("| 6. Exit program                |");
        System.out.println("==================================");
    } // end of mainMenu method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * The subMenu method displays the sub menu options.
     */
    public void subMenu() {
        System.out.println("==================================");
        System.out.println("|       CLOTHING MAIN MENU       |");
        System.out.println("| 1. Add material                |");
        System.out.println("| 2. Delete material             |");
        System.out.println("| 3. Back main menu              |");
        System.out.println("==================================");
    } // end of subMenu method

//----------------------------------------------------------------------------------------------------------------------


    /**
     * The viewList method displays the current list of classroom items.
     */
    public void viewList() {
        System.out.println("\n------------------------------------------------------");
        System.out.println("                     Current List                     ");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%n", "Course Name", "Course Code", "Topic Name");
        System.out.printf("%-20s%-20s%-20s%n", "============", "============", "============");;
        for (int index = 0; index < singlyList.getSize(); index++) {
            Class element = singlyList.getElement(index);
            System.out.printf("%-20s%-20s%-20s%n", element.getCourseName(), element.getCourseCode(), element.getTopicName());
        }
        System.out.println("------------------------------------------------------\n");
    } // end of viewList method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Inner class Classroom represents a clothing item with course name, course code, and topic name.
     */
    private static class Class {
        private String courseName;
        private String courseCode;
        private String topicName;
        private SinglyLinkedList<String> materialList = new SinglyLinkedList<>();

//----------------------------------------------------------------------------------------------------------------------

        public Class(String courseN, String courseC, String topicN) {
            courseName = courseN;
            courseCode = courseC;
            topicName = topicN;
        } // end of constructor

//----------------------------------------------------------------------------------------------------------------------

        public String getCourseName() {
            return courseName;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getTopicName() {
            return topicName;
        }

//----------------------------------------------------------------------------------------------------------------------

        @Override
        public String toString() {
            return "Course Name: " + this.getCourseName() + "\n" +
                    "Course Code: " + this.getCourseCode() + "\n" +
                    "Topic Name: " + this.getTopicName() + "\n";
        } // end of toString method

//----------------------------------------------------------------------------------------------------------------------

        /**
         * Override equals method to compare Classroom objects.
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            if (!(obj instanceof Class room))
                return false;

            return (this.getCourseName() + "," + this.getCourseCode() + "," + this.getTopicName()).equalsIgnoreCase
                    (room.getCourseName() + "," + room.getCourseCode() + "," + room.getTopicName());
        } // end of equals method

//----------------------------------------------------------------------------------------------------------------------
    } // end of Class class
//----------------------------------------------------------------------------------------------------------------------
} // end of Classroom class
//----------------------------------------------------------------------------------------------------------------------

