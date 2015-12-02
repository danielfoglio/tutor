package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class TeachesPK implements Serializable {
    private String courseId;
    private String tid;
    private String deptId;

    @Column(name = "courseID")
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "TID")
    @Id
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Column(name = "DeptID")
    @Id
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

        TeachesPK teachesPK = (TeachesPK) o;

        if (courseId != null ? !courseId.equals(teachesPK.courseId) : teachesPK.courseId != null) return false;
        if (tid != null ? !tid.equals(teachesPK.tid) : teachesPK.tid != null) return false;
        if (deptId != null ? !deptId.equals(teachesPK.deptId) : teachesPK.deptId != null) return false;

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
