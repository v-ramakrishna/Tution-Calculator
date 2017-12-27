//********************************************************************************************************
// CLASS: OnCampusStudent (OnCampusStudent.java)
//
// DESCRIPTION
// A subclass of the Student superclass. This class is used to declare and
// construct objects holding the student information (student ID, name, and
// tuition) for students who are On Campus Students. It is also used to calculate
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
public class OnCampusStudent extends Student {

    private boolean mResident;
    private double mProgramFee;

    /**
     * OnCampusStudent constructor. Calls the constructor from the Student
     * superclass to build an OnCampusStudent object.
     */
    OnCampusStudent(String pId, String pFname, String pLname) {
        super(pId, pFname, pLname);
    }

    /**
     * Calculates and sets Tuition for each On Campus Student.
     */
    @Override
    public void calcTuition() {
        double t;
        if (getResidency() == true) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;

        }
        t = t + getProgramFee();
        if (getCredits() > TuitionConstants.MAX_CREDITS) {
            t = t + (getCredits() - TuitionConstants.MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }
        setTuition(t);
    }

    /**
     * Accessor for mProgramFee. Used to determine is the student must pay an
     * additional fee due to their program.
     */
    public double getProgramFee() {
        return mProgramFee;
    }

    /**
     * Accessor for mResident. Used to determine is the student is a resident,
     * in calculating tuition.
     */
    public boolean getResidency() {
        return mResident;
    }

    /**
     * Mutator for mProgramFee. Used to change program fees for a given student
     * if need be.
     */
    public void setProgramFee(double pProgramFee) {
        mProgramFee = pProgramFee;
    }

    /**
     * Mutator for mResident. Used to change residency for a given student if
     * need be.
     */
    public void setResidency(boolean pResident) {
        mResident = pResident;
    }

}
