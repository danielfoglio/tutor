package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(RegistrationPK.class)
public class Registration {
    private String tid;
    private String sid;
    private String status;

    @Id
    @Column(name = "TID")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public Registration() {}

    public Registration(Student student, Tutor tutor) {
        this.sid = student.getSid();
        this.tid = tutor.getTid();
        this.status = "pending";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
