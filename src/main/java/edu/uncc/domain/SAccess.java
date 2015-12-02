package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@Table(name = "S_Access", schema = "", catalog = "project")
@IdClass(SAccessPK.class)
public class SAccess {
    private String sid;
    private String discussionId;

    @Id
    @Column(name = "SID")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Id
    @Column(name = "discussionID")
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

        SAccess sAccess = (SAccess) o;

        if (sid != null ? !sid.equals(sAccess.sid) : sAccess.sid != null) return false;
        if (discussionId != null ? !discussionId.equals(sAccess.discussionId) : sAccess.discussionId != null)
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
