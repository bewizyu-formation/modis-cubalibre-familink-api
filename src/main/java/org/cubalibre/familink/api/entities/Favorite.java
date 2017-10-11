package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite {

    private static final Logger LOG = LoggerFactory.getLogger(Favorite.class.getName());

    @Column(name = "id_group")
    private Integer id_groupe;

    @Column(name = "id_uder")
    private Integer id_user;

    @Column(name = "id_contact")
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
