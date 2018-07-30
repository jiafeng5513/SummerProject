package com.summer.anna.entity;

import javax.persistence.*;

@Entity
@Table(name = "blog", schema = "Summer", catalog = "")
public class BlogEntity {
    private short blogId;
    private String blogText;
    private Integer likeNum;

    @Id
    @Column(name = "blogID", nullable = false)
    public short getBlogId() {
        return blogId;
    }

    public void setBlogId(short blogId) {
        this.blogId = blogId;
    }

    @Basic
    @Column(name = "blogText", nullable = true, length = -1)
    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    @Basic
    @Column(name = "likeNum", nullable = true)
    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (blogId != that.blogId) return false;
        if (blogText != null ? !blogText.equals(that.blogText) : that.blogText != null) return false;
        if (likeNum != null ? !likeNum.equals(that.likeNum) : that.likeNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) blogId;
        result = 31 * result + (blogText != null ? blogText.hashCode() : 0);
        result = 31 * result + (likeNum != null ? likeNum.hashCode() : 0);
        return result;
    }
}
