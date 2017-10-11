package entities;

public class Profil {

    private int id;

    private String type;

    private String color;

    /**
     * Constructor vide
     */
    public Profil() {
    }

    /**
     * Constructor
     *
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

