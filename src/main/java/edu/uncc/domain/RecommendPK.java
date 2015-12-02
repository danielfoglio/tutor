package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class RecommendPK implements Serializable {
    private String courseId;
    private String bid;

    @Column(name = "courseID")
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "BID")
    @Id
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecommendPK that = (RecommendPK) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (bid != null ? !bid.equals(that.bid) : that.bid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        return result;
    }
}
