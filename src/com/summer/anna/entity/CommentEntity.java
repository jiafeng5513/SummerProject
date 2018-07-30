package com.summer.anna.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "Summer", catalog = "")
public class CommentEntity {
    private short commentId;
    private String commentText;

    @Id
    @Column(name = "commentID", nullable = false)
    public short getCommentId() {
        return commentId;
    }

    public void setCommentId(short commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "commentText", nullable = false, length = -1)
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (commentText != null ? !commentText.equals(that.commentText) : that.commentText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) commentId;
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        return result;
    }
}
