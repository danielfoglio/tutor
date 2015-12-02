package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(RecommendPK.class)
public class Recommend {
    private String courseId;
    private String bid;

    @Id
    @Column(name = "courseID")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "BID")
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

        Recommend recommend = (Recommend) o;

        if (courseId != null ? !courseId.equals(recommend.courseId) : recommend.courseId != null) return false;
        if (bid != null ? !bid.equals(recommend.bid) : recommend.bid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        return result;
    }
}
