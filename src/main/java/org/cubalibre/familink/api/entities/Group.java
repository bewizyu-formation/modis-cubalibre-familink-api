package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "group")

public class Group {
    private static final Logger LOG = LoggerFactory.getLogger(Group.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Integer id;
    @JoinColumn(name = "owner")
    private User owner;
    @Column(name = "name")
    private String name;
    @Column(name = "create_date")
    private Date createDate;
    @JoinColumn(name = "contacts")
    private List<Contact> contacts;

    public Group() {
        LOG.info("Group");
    }

    public Group(Integer id, User owner, String name, Date createDate, List<Contact> contacts) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.createDate = createDate;
        this.contacts = contacts;
    }

    public Integer getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Contact> getContacts() {
        return contacts;
    }


}
