package org.cubalibre.familink.api.entite;

import javax.persistence.*;

@Entity
@Table(name = "res_pwd_token")
public class PwdToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private int id;

    @Column(name = "token")
    private String token;

    @Column(name = "is_used")
    private boolean isUsed;

    /**
     * Constuctor vide
     *
     * @return
     */
    public PwdToken() {

    }

    /**
     * Constructor
     *
     * @param id
     * @param token
     * @param isUsed
     */
    public PwdToken(Integer id, String token, boolean isUsed) {
        this.id = id;
        this.token = token;
        this.isUsed = isUsed;
    }

    public int getId() {
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
        if (!used) {
            this.isUsed = true;
        }
    }

}
