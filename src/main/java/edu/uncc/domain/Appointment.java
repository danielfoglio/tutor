package edu.uncc.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(AppointmentPK.class)
public class Appointment {
    private String tid;
    private String sid;
    private Integer duration;
    private Time startTime;
    private Date meetingDate;

    @Id
    @Column(name = "TID")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Id
    @Column(name = "SID")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "startTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "meetingDate")
    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (meetingDate != null ? !meetingDate.equals(that.meetingDate) : that.meetingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (meetingDate != null ? meetingDate.hashCode() : 0);
        return result;
    }
}
