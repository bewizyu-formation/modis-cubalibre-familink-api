package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Favorite {

    private static final Logger LOG = LoggerFactory.getLogger(Favorite.class.getName());

    private Integer id_groupe;
    private Integer id_user;
    private Integer id_contact;

    public Favorite() {
        LOG.info("Favorite");
    }

    public Favorite(Integer id_groupe, Integer id_user, Integer id_contact) {
        this.id_groupe = id_groupe;
        this.id_user = id_user;
        this.id_contact = id_contact;
    }

    public Integer getId_groupe() {
        return id_groupe;
    }

    public Integer getId_user() {
        return id_user;
    }

    public Integer getId_contact() {
        return id_contact;
    }
}
