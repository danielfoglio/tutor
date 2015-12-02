package edu.uncc.domain;

/**
 * @author daniel_foglio@premierinc.com
 */
public class StudentForm extends UserCreateForm{
    private String sid;
    private String fname;
    private String lname;
    private String phone;
    private String degree;
    private String degreeStanding;
    private String sEmail;
    private String courseId;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegreeStanding() {
        return degreeStanding;
    }

    public void setDegreeStanding(String degreeStanding) {
        this.degreeStanding = degreeStanding;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
