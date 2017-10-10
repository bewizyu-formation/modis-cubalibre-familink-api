package entities;

public class ResPwdToken {
    private Integer id;
    private String token;
    private boolean isUsed;

    public ResPwdToken() {

    }

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
