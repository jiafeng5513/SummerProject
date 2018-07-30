package com.summer.anna.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "Summer", catalog = "")
public class UserEntity {
    private String userName;
    private String password;
    private String emailAdd;

    @Id
    @Column(name = "userName", nullable = false, length = 32)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "emailAdd", nullable = true, length = 64)
    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (emailAdd != null ? !emailAdd.equals(that.emailAdd) : that.emailAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emailAdd != null ? emailAdd.hashCode() : 0);
        return result;
    }
}
