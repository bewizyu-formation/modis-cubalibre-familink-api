package org.cubalibre.familink.api.entite;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * Constructor
     *
     * @param id
     * @param mail
     * @param password
     * @param contact
     */
    public User(int id, String mail, String password, Contact contact) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.contact = contact;
    }

    /**
     * Contructor vide
     */
    public User() {
    }
}
