package entities;

public class Contact {
    private Integer id;
private String lastName;
private String firstName;
private String phone;
private Profil profil;
private String address;
private String zipcode;
private String city;
private String gravatar;
public Contact(){

}

    public Contact(String lastName, String firstName, String phone, Profil profil, String address, String zipcode, String city, String gravatar) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.profil = profil;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.gravatar = gravatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGravatar() {
        return gravatar;
    }

    public void setGravatar(String gravatar) {
        this.gravatar = gravatar;
    }

}
