package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class SAccessPK implements Serializable {
    private String sid;
    private String discussionId;

    @Column(name = "SID")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Column(name = "discussionID")
    @Id
    public String getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(String discussionId) {
        this.discussionId = discussionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SAccessPK sAccessPK = (SAccessPK) o;

        if (sid != null ? !sid.equals(sAccessPK.sid) : sAccessPK.sid != null) return false;
        if (discussionId != null ? !discussionId.equals(sAccessPK.discussionId) : sAccessPK.discussionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (discussionId != null ? discussionId.hashCode() : 0);
        return result;
    }
}
