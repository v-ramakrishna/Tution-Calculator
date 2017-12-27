//********************************************************************************************************
// CLASS: Main (Main.java)
//
// DESCRIPTION
// The Main Class of the Project2 Java Application. Reads in students from an
// input file, and calculates each student's tuition based on a number of
// factors, including Campus Status, Residency, Fees, and number of Credits.
// Writes the results to a new output file.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Summer 2016
// Project Number: 2
//
// AUTHOR
// Vijay Ramakrishna (vijay.ramakrishna@asu.edu)
//
// CO-AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// Web: http://www.devlang.com
//********************************************************************************************************

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

/**
 *
 * @author VRama
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Instantiates a Main object and calls run() on the object.
     */
    public static void main(String[] pArgs) {
        Main mainObject = new Main();
        mainObject.run();
    }

    /**
     * Calculates the tuition for each student.
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the
     * list of students as an ArrayList<Student> object.
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        File file = new File("p02-students.txt");
        Scanner in = new Scanner(file);
        int y = 0;
        while (in.hasNext()) {
            String studentType = in.next();
            if (studentType.equals("C")) {
                studentList.add(y, readOnCampusStudent(in));
            } else {
                studentList.add(y, readOnlineStudent(in));
            }
            y++;
        }
        in.close();
        return studentList;
    }

    /**
     * Reads the information for an on-campus student, ultimately to be added to
     * a list of students as an ArrayList<Student> object.
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) {
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnCampusStudent onCampusStudent = new OnCampusStudent(id, lname, fname);
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();
        if (res.equals("R")) {
            onCampusStudent.setResidency(true);
        } else {
            onCampusStudent.setResidency(false);
        }
        onCampusStudent.setProgramFee(fee);
        onCampusStudent.setCredits(credits);
        return onCampusStudent;
    }

    /**
     * Reads the information for an online student, ultimately to be added to a
     * list of students as an ArrayList<Student> object.
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnlineStudent onlineStudent = new OnlineStudent(id, lname, fname);
        String fee = pIn.next();
        int credits = pIn.nextInt();
        if (fee.equals("T")) {
            onlineStudent.setTechFee(true);
        } else {
            onlineStudent.setTechFee(false);
        }
        onlineStudent.setCredits(credits);
        return onlineStudent;
    }

    /**
     * Calls other methods to implement the program.
     */
    private void run() {
        ArrayList<Student> studentList;
        try {
            studentList = readFile();
            calcTuition(studentList);
            Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
            writeFile(studentList);
        } catch (FileNotFoundException exception) {
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);
        }
    }

    /**
     * Writes the output file to "p02-tuition.txt".
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("p02-tuition.txt"));
        for (Student student : pStudentList) {
            out.print(student.getId() + " " + student.getLastName() + " " + student.getFirstName());
            out.printf("%.2f%n", student.getTuition());
        }
        out.close();
    }
}
