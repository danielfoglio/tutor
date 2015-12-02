package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(ApplyPK.class)
public class Apply {
    private String applicantId;
    private String jobId;
    private String deptId;
    private String courseId;

    @Id
    @Column(name = "applicantID")
    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    @Id
    @Column(name = "JobID")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Id
    @Column(name = "DeptID")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Id
    @Column(name = "courseID")
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

        Apply apply = (Apply) o;

        if (applicantId != null ? !applicantId.equals(apply.applicantId) : apply.applicantId != null) return false;
        if (jobId != null ? !jobId.equals(apply.jobId) : apply.jobId != null) return false;
        if (deptId != null ? !deptId.equals(apply.deptId) : apply.deptId != null) return false;
        if (courseId != null ? !courseId.equals(apply.courseId) : apply.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicantId != null ? applicantId.hashCode() : 0;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
