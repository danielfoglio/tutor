package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@Table(name = "T_Access", schema = "", catalog = "project")
@IdClass(TAccessPK.class)
public class TAccess {
    private String tid;
    private String discussionId;

    @Id
    @Column(name = "TID")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

        TAccess tAccess = (TAccess) o;

        if (tid != null ? !tid.equals(tAccess.tid) : tAccess.tid != null) return false;
        if (discussionId != null ? !discussionId.equals(tAccess.discussionId) : tAccess.discussionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (discussionId != null ? discussionId.hashCode() : 0);
        return result;
    }
}
