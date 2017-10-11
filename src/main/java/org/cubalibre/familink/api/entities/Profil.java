package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Profil {

    private static final Logger LOG = LoggerFactory.getLogger(Profil.class.getName());

    private int id;
    private String type;
    private String color;
    public Profil() {
        LOG.info("Profil");
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

    /**
     * Constuctor vide
     * @return
     */
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
