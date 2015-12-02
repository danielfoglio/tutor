package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class AttendsPK implements Serializable {
    private String sid;
    private String courseId;

    @Column(name = "SID")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Column(name = "courseID")
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendsPK attendsPK = (AttendsPK) o;

        if (sid != null ? !sid.equals(attendsPK.sid) : attendsPK.sid != null) return false;
        if (courseId != null ? !courseId.equals(attendsPK.courseId) : attendsPK.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
