//********************************************************************************************************
// CLASS: OnlineStudent (OnlineStudent.java)
//
// DESCRIPTION
// A subclass of the Student superclass. This class is used to declare and
// construct objects holding the student information (student ID, name, and
// tuition) for students who are Online Students. It is also used to calculate
// their tuition.
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
public class OnlineStudent extends Student {

    private boolean mTechFee;

    /**
     * OnlineStudent constructor. Calls the constructor from the Student
     * superclass to build an OnlineStudent object.
     */
    OnlineStudent(String pId, String pFname, String pLname) {
        super(pId, pFname, pLname);
    }

    /**
     * Calculates and sets Tuition for each Online Student.
     */
    @Override
    public void calcTuition() {
        double t;
        t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee() == true) {
            t = t + TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
    }

    /**
     * Accessor for mTechFee. Is used to pull the information as to whether or
     * not a student must pay a Technology Fee.
     */
    public boolean getTechFee() {
        return mTechFee;
    }

    /**
     * Mutator for mTechFee. Is used to change status on whether or not a
     * Technology Fee must be paid.
     */
    public void setTechFee(boolean pTechFee) {
        mTechFee = pTechFee;
    }
}
