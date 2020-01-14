package com.github.bootstrap.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_REVIEWS")
public class Review {

    @Id
    @Column(name = "id")
    //  TODO: naming
    private Long user_id;

    @Column(name = "comment")
    private String comment;

    @OneToOne
    @MapsId
    private User user;

    public Review() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review " + "comment : " + comment;
    }
}
