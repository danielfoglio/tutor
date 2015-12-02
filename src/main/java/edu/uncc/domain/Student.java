package edu.uncc.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Student{
    private String sid;
    private String fname;
    private String lname;
    private String phone;
    private String degree;
    private String degreeStanding;
    private String sEmail;
    private String courseId;



    private Collection<Tutor> tutors;
    @OneToMany( cascade=CascadeType.ALL)
    @JoinTable(name="Registration",
            joinColumns={@JoinColumn(name="SID", referencedColumnName="SID")},
            inverseJoinColumns={@JoinColumn(name="TID", referencedColumnName="TID")})
    public Collection<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public Student(){}

    public Student(StudentForm sf) {
        this.sid = sf.getLogin();
        this.fname = sf.getFname();
        this.lname = sf.getLname();
        this.phone = sf.getPhone();
        this.degree = sf.getDegree();
        this.degreeStanding = sf.getDegreeStanding();
        this.sEmail = sf.getsEmail();
        this.courseId = sf.getCourseId();
    }

    public StudentForm toStudentForm(){
        StudentForm s = new StudentForm();
        s.setLogin(sid);
        s.setFname(fname);
        s.setLname(lname);
        s.setPhone(phone);
        s.setDegree(degree);
        s.setDegreeStanding(degreeStanding);
        s.setsEmail(sEmail);
        s.setCourseId(courseId);
        s.setRole(Role.USER);
        return s;
    }

    @Id
    @Column(name = "SID")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
    @Column(name = "degree")
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "degree_standing")
    public String getDegreeStanding() {
        return degreeStanding;
    }

    public void setDegreeStanding(String degreeStanding) {
        this.degreeStanding = degreeStanding;
    }

    @Basic
    @Column(name = "S_email")
    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Basic
    @Column(name = "courseID")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sid != null ? !sid.equals(student.sid) : student.sid != null) return false;
        if (fname != null ? !fname.equals(student.fname) : student.fname != null) return false;
        if (lname != null ? !lname.equals(student.lname) : student.lname != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (degree != null ? !degree.equals(student.degree) : student.degree != null) return false;
        if (degreeStanding != null ? !degreeStanding.equals(student.degreeStanding) : student.degreeStanding != null)
            return false;
        if (sEmail != null ? !sEmail.equals(student.sEmail) : student.sEmail != null) return false;
        if (courseId != null ? !courseId.equals(student.courseId) : student.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (degreeStanding != null ? degreeStanding.hashCode() : 0);
        result = 31 * result + (sEmail != null ? sEmail.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
