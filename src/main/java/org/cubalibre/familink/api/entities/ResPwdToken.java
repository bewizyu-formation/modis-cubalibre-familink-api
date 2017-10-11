package org.cubalibre.familink.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "res_pwd_token")
public class ResPwdToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "is_used")
    private boolean isUsed;

    /**
     * Constuctor vide
     * @return
     */
    public ResPwdToken() {

    }

    /**
     * Constructor
     * @param id
     * @param token
     * @param isUsed
     */
    public ResPwdToken(Integer id, String token, boolean isUsed) {
        this.id = id;
        this.token = token;
        this.isUsed = isUsed;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
