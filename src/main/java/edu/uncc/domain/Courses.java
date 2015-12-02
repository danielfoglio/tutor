package edu.uncc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Courses {
    private String courseId;
    private String courseName;

    @Id
    @Column(name = "courseID")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courses courses = (Courses) o;

        if (courseId != null ? !courseId.equals(courses.courseId) : courses.courseId != null) return false;
        if (courseName != null ? !courseName.equals(courses.courseName) : courses.courseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        return result;
    }
}
