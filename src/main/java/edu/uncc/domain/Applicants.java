package edu.uncc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Applicants {
    private String applicantId;
    private String fname;
    private String lname;
    private String skills;
    private Long contactno;

    @Id
    @Column(name = "applicantID")
    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    @Basic
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "skills")
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Basic
    @Column(name = "contactno")
    public Long getContactno() {
        return contactno;
    }

    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Applicants that = (Applicants) o;

        if (applicantId != null ? !applicantId.equals(that.applicantId) : that.applicantId != null) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
        if (skills != null ? !skills.equals(that.skills) : that.skills != null) return false;
        if (contactno != null ? !contactno.equals(that.contactno) : that.contactno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicantId != null ? applicantId.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (contactno != null ? contactno.hashCode() : 0);
        return result;
    }
}
