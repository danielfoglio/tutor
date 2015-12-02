package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class RegistrationPK implements Serializable {
    private String tid;
    private String sid;

    @Column(name = "TID")
    @Id
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Column(name = "SID")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationPK that = (RegistrationPK) o;

        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
