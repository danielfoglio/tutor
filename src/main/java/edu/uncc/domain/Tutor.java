package edu.uncc.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Tutor{
    private String tid;
    private String fname;
    private String lname;
    private String phone;
    private Float payRate;
    private String availability;
    private String tEmail;
    private String instructionMode = "Face to Face";
    private String specialization;
    private String courseTaught;

    private Collection<Registration> registrations;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "tutor")
    public Collection<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Tutor(){}

    public Tutor(TutorForm tf) {
        this.tid = tf.getLogin();
        this.fname = tf.getFname();
        this.lname = tf.getLname();
        this.phone = tf.getPhone();
        this.payRate = tf.getPayRate();
        this.availability = tf.getAvailability();
        this.tEmail = tf.gettEmail();
        this.instructionMode = tf.getInstructionMode();
        this.specialization = tf.getSpecialization();
        this.courseTaught = tf.getCourseTaught();
    }
    public TutorForm toTutorForm(){
        TutorForm t = new TutorForm();
        t.setLogin(tid);
        t.setFname(fname);
        t.setLname(lname);
        t.setPhone(phone);
        t.setPayRate(payRate);
        t.setAvailability(availability);
        t.settEmail(tEmail);
        t.setInstructionMode(instructionMode);
        t.setSpecialization(specialization);
        t.setCourseTaught(courseTaught);
        t.setRole(Role.TUTOR);
        return t;
    }

    @Id
    @Column(name = "TID")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "Fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "Lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "payRate")
    public Float getPayRate() {
        return payRate;
    }

    public void setPayRate(Float payRate) {
        this.payRate = payRate;
    }

    @Basic
    @Column(name = "availability")
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "T_email")
    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    @Basic
    @Column(name = "instruction_mode")
    public String getInstructionMode() {
        return instructionMode;
    }

    public void setInstructionMode(String instructionMode) {
        this.instructionMode = instructionMode;
    }

    @Basic
    @Column(name = "specialization")
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Basic
    @Column(name = "course_taught")
    public String getCourseTaught() {
        return courseTaught;
    }

    public void setCourseTaught(String courseTaught) {
        this.courseTaught = courseTaught;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        if (tid != null ? !tid.equals(tutor.tid) : tutor.tid != null) return false;
        if (fname != null ? !fname.equals(tutor.fname) : tutor.fname != null) return false;
        if (lname != null ? !lname.equals(tutor.lname) : tutor.lname != null) return false;
        if (phone != null ? !phone.equals(tutor.phone) : tutor.phone != null) return false;
        if (payRate != null ? !payRate.equals(tutor.payRate) : tutor.payRate != null) return false;
        if (availability != null ? !availability.equals(tutor.availability) : tutor.availability != null) return false;
        if (tEmail != null ? !tEmail.equals(tutor.tEmail) : tutor.tEmail != null) return false;
        if (instructionMode != null ? !instructionMode.equals(tutor.instructionMode) : tutor.instructionMode != null)
            return false;
        if (specialization != null ? !specialization.equals(tutor.specialization) : tutor.specialization != null)
            return false;
        if (courseTaught != null ? !courseTaught.equals(tutor.courseTaught) : tutor.courseTaught != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (payRate != null ? payRate.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (tEmail != null ? tEmail.hashCode() : 0);
        result = 31 * result + (instructionMode != null ? instructionMode.hashCode() : 0);
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        result = 31 * result + (courseTaught != null ? courseTaught.hashCode() : 0);
        return result;
    }
}
