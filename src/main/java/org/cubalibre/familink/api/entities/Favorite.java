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

    @Column(name = "group_id")
    private Integer idGroup;

    @Column(name = "user_id")
    private Integer idUser;

    @Column(name = "contact_id")
    private Integer idContact;

    public Favorite() {
        LOG.info("Favorite");
    }

    public Favorite(Integer idGroup, Integer idUser, Integer idContact) {
        this.idGroup = idGroup;
        this.idUser = idUser;
        this.idContact = idContact;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdContact() {
        return idContact;
    }
}
