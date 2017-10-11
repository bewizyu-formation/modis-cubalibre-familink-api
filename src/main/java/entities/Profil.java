package entities;

public class Profil {

    private int id;

    private string type;

    private string color;

    public Profil() {
    }

    /**
     * Constructor
     * @param id
     * @param type
     * @param color
     */
    public Profil(int id, string type, string color) {
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

    public string getType() {
        return type;
    }

    public void setType(string type) {
        this.type = type;
    }

    public string getColor() {
        return color;
    }

    public void setColor(string color) {
        this.color = color;
    }

}
