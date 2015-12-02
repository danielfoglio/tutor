package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class StudiesPK implements Serializable {
    private String bid;
    private String sid;

    @Column(name = "BID")
    @Id
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

        StudiesPK studiesPK = (StudiesPK) o;

        if (bid != null ? !bid.equals(studiesPK.bid) : studiesPK.bid != null) return false;
        if (sid != null ? !sid.equals(studiesPK.sid) : studiesPK.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bid != null ? bid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
