package edu.uncc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Jobs {
    private String jobId;
    private String jobdesc;
    private String qualification;

    @Id
    @Column(name = "JobID")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "Jobdesc")
    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    @Basic
    @Column(name = "Qualification")
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobs jobs = (Jobs) o;

        if (jobId != null ? !jobId.equals(jobs.jobId) : jobs.jobId != null) return false;
        if (jobdesc != null ? !jobdesc.equals(jobs.jobdesc) : jobs.jobdesc != null) return false;
        if (qualification != null ? !qualification.equals(jobs.qualification) : jobs.qualification != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobdesc != null ? jobdesc.hashCode() : 0);
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        return result;
    }
}
