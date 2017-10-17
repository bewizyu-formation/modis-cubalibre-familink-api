package org.cubalibre.familink.api.entite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "groupe")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Integer id;

    @JoinColumn(name = "owner")
    @OneToOne
    private User owner;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = true)
    private Date createDate = new Date();

    @ManyToMany(cascade= {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "group_contact",
            joinColumns = @JoinColumn (name = "group_id", referencedColumnName = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "id_contact"))
    private List<Contact> contacts = new ArrayList<>();

    /**
     * Constuctor vide
     *
     * @return
     */
    public Group() {

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

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

}
