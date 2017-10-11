package org.cubalibre.familink.api.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "sender")
    private Contact sender;

    @OneToMany
    @JoinColumn(name = "receiver")
    private Contact receiver;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "text")
    private String text;

    @Column(name="isRead")
    private boolean isRead;

    @OneToMany
    @JoinColumn(name = "group_id")
    private Group group;

    /**
     * Constructor vide
     */
    public Message() {
    }


    public int getId() {
        return id;
    }

    public Contact getSender() {
        return sender;
    }

    public Contact getReceiver() {
        return receiver;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setAsRead() {
        if (!isRead) {
            this.isRead = true;
        }
    }

    public Group getGroup() {
        return group;
    }


}
