package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(TeachesPK.class)
public class Teaches {
    private String courseId;
    private String tid;
    private String deptId;

    @Id
    @Column(name = "courseID")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "TID")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Id
    @Column(name = "DeptID")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teaches teaches = (Teaches) o;

        if (courseId != null ? !courseId.equals(teaches.courseId) : teaches.courseId != null) return false;
        if (tid != null ? !tid.equals(teaches.tid) : teaches.tid != null) return false;
        if (deptId != null ? !deptId.equals(teaches.deptId) : teaches.deptId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        return result;
    }
}
