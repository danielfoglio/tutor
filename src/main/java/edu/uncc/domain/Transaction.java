package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@IdClass(TransactionPK.class)
public class Transaction {
    private int transId;
    private String tid;
    private String sid;
    private String transMode;
    private Float amount;

    @Id
    @Column(name = "transID")
    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
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
    @Column(name = "SID")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "trans_mode")
    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    @Basic
    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transId != that.transId) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (transMode != null ? !transMode.equals(that.transMode) : that.transMode != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transId;
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (transMode != null ? transMode.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
