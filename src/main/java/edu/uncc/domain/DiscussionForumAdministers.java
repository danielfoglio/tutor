package edu.uncc.domain;

import javax.persistence.*;

/**
 * @author daniel_foglio@premierinc.com
 */
@Entity
@Table(name = "DiscussionForum_Administers", schema = "", catalog = "project")
public class DiscussionForumAdministers {
    private String discussionId;
    private String chatText;
    private String username;

    @Id
    @Column(name = "discussionID")
    public String getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(String discussionId) {
        this.discussionId = discussionId;
    }

    @Basic
    @Column(name = "chat_text")
    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscussionForumAdministers that = (DiscussionForumAdministers) o;

        if (discussionId != null ? !discussionId.equals(that.discussionId) : that.discussionId != null) return false;
        if (chatText != null ? !chatText.equals(that.chatText) : that.chatText != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discussionId != null ? discussionId.hashCode() : 0;
        result = 31 * result + (chatText != null ? chatText.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
