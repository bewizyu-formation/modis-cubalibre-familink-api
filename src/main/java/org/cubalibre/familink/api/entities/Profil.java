package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name="profil")
public class Profil {

    private static final Logger LOG = LoggerFactory.getLogger(Profil.class.getName());

    @Id
    @Column(name="id_profil")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String type;

    @Column(name="color")
    private String color;

    /**
     * Constuctor vide
     * @return
     */
    public Profil() {
    }

    /**
     * Constructor
     * @param id
     * @param type
     * @param color
     */
    public Profil(int id, String type, String color) {
        this.id = id;
        this.type = type;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
