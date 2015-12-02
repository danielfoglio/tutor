package edu.uncc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
public class Books {
    private String bid;
    private String bookname;
    private String author;

    @Id
    @Column(name = "BID")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (bid != null ? !bid.equals(books.bid) : books.bid != null) return false;
        if (bookname != null ? !bookname.equals(books.bookname) : books.bookname != null) return false;
        if (author != null ? !author.equals(books.author) : books.author != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bid != null ? bid.hashCode() : 0;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
