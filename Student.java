//********************************************************************************************************
// CLASS: Student (Student.java)
//
// DESCRIPTION
// The Student class of Project 2. This class is the superclass for the
// OnCampusStudent and OnlineStudent subclasses. It provides shared variables
// and methods to the two subclasses. Its constructor is also used in
// constructing the subclasses. The students are used to fill an ArrayList,
// after being imported from their original file.
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
public abstract class Student implements Comparable<Student> {

    private int mCredits;
    private String mFname;
    private String mId;
    private String mLname;
    private double mTuition;

    /**
     * Consttructor for the Student class. Called in order to build the
     * OnCampusStudent and OnlineStudent objects.
     */
    Student(String pId, String pFname, String pLname) {
        mId = pId;
        mFname = pFname;
        mLname = pLname;

    }

    /**
     * Abstract method for calculating tuition which is overridden by the
     * corresponding method in both the OnCampusStudent and OnlineStudent
     * classes.
     */
    public abstract void calcTuition();

    /**
     * Overrides method from java.lang.Comparable in order to put students in
     * the correct order in the array list, such that they are in some order
     * (either ascending or descending) based on student ID.
     */
    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
    }

    /**
     * Accessor for mCredits. Used in determining tuition.
     */
    public int getCredits() {
        return mCredits;
    }

    /**
     * Accessor for mFname. Used in printing the output file.
     */
    public String getFirstName() {
        return mFname;
    }

    /**
     * Accessor for mId. Used in printing the output file.
     */
    public String getId() {
        return mId;
    }

    /**
     * Accessor for mLname. Used in printing the output file.
     */
    public String getLastName() {
        return mLname;
    }

    /**
     * Accessor for mTuition. Used in printing the output file.
     */
    public double getTuition() {
        return mTuition;
    }

    /**
     * Mutator for mCredits. Used to change this varuable's value for a given
     * student.
     */
    public void setCredits(int pCredits) {
        mCredits = pCredits;
    }

    /**
     * Mutator for mFname. Used to change this varuable's value for a given
     * student.
     */
    public void setFname(String pFname) {
        mFname = pFname;
    }

    /**
     * Mutator for Id. Used to change this varuable's value for a given student.
     */
    public void setId(String pId) {
        mId = pId;
    }

    /**
     * Mutator for mLname. Used to change this varuable's value for a given
     * student.
     */
    public void setLname(String pLname) {
        mLname = pLname;
    }

    /**
     * Mutator for mTuition. Used to change this varuable's value for a given
     * student.
     */
    public void setTuition(double pTuition) {
        mTuition = pTuition;
    }

}
