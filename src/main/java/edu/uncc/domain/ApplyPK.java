package edu.uncc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author daniel_foglio@premierinc.com
 */
public class ApplyPK implements Serializable {
    private String applicantId;

    @Column(name = "applicantID")
    @Id
    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    private String jobId;

    @Column(name = "JobID")
    @Id
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    private String deptId;

    @Column(name = "DeptID")
    @Id
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    private String courseId;

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

        ApplyPK applyPK = (ApplyPK) o;

        if (applicantId != null ? !applicantId.equals(applyPK.applicantId) : applyPK.applicantId != null) return false;
        if (jobId != null ? !jobId.equals(applyPK.jobId) : applyPK.jobId != null) return false;
        if (deptId != null ? !deptId.equals(applyPK.deptId) : applyPK.deptId != null) return false;
        if (courseId != null ? !courseId.equals(applyPK.courseId) : applyPK.courseId != null) return false;

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
