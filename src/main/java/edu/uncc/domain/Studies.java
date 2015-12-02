package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(StudiesPK.class)
public class Studies {
    private String bid;
    private String sid;

    @Id
    @Column(name = "BID")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Id
    @Column(name = "SID")
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

        Studies studies = (Studies) o;

        if (bid != null ? !bid.equals(studies.bid) : studies.bid != null) return false;
        if (sid != null ? !sid.equals(studies.sid) : studies.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bid != null ? bid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
