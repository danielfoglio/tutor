package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class TAccessPK implements Serializable {
    private String tid;
    private String discussionId;

    @Column(name = "TID")
    @Id
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

        TAccessPK tAccessPK = (TAccessPK) o;

        if (tid != null ? !tid.equals(tAccessPK.tid) : tAccessPK.tid != null) return false;
        if (discussionId != null ? !discussionId.equals(tAccessPK.discussionId) : tAccessPK.discussionId != null)
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
