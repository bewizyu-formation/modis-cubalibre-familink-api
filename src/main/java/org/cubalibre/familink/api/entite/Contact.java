package org.cubalibre.familink.api.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private int id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "gravatar")
    private String gravatar;

    @JsonIgnore
    @ManyToMany(mappedBy="contacts", fetch = FetchType.EAGER)
    private List<Group> groups = new ArrayList<>();

    /**
     * Contructor vide
     */
    public Contact() {
    }

    /**
     * Constructor
     *
     * @param lastName
     * @param firstName
     * @param phone
     * @param profil
     * @param address
     * @param zipcode
     * @param city
     * @param gravatar
     */
    public Contact(String lastName, String firstName, String phone, Profil profil, String address, String zipcode, String city, String gravatar) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.profil = profil;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.gravatar = gravatar;
    }

    /**
     * GETTERS & SETTERS
     *
     * @return
     */
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGravatar() {
        return gravatar;
    }

    public void setGravatar(String gravatar) {
        this.gravatar = gravatar;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

}
