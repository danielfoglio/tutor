package edu.uncc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Department {
    private String deptId;
    private String deptName;

    @Id
    @Column(name = "DeptID")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "DeptName")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptId != null ? deptId.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }
}
