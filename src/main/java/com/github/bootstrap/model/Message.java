package com.github.bootstrap.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "TBL_MESSAGES")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Message() {
    }

    public Message(Long id, String userName, String description) {
        this.id = id;
        this.userName = userName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", user name=" + userName + "description=" + description + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) &&
                userName.equals(message.userName) &&
                description.equals(message.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, description);
    }
}
