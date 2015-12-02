package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@Table(name = "Administrator_Validate", schema = "", catalog = "project")
public class AdministratorValidate {
    private String username;
    private String password;
    private String applicantId;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "applicantID")
    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministratorValidate that = (AdministratorValidate) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (applicantId != null ? !applicantId.equals(that.applicantId) : that.applicantId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (applicantId != null ? applicantId.hashCode() : 0);
        return result;
    }
}
