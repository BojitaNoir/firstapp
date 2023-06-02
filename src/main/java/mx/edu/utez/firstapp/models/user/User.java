package mx.edu.utez.firstapp.models.user;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private String surname;
    private String birthday;
    private String usernarme;
    private String status;

    public User() {
    }

    public User(Long id, String name, String lastname, String surname, String birthday, String usernarme, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.usernarme=usernarme;
        this.birthday = birthday;
        this.usernarme = usernarme;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
    public String getSurname() {
        return surname;
    }


    public String getBirthday() {
        return birthday;
    }

    public String getUsernarme() {
        return usernarme;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setUsernarme(String usernarme) {
        this.usernarme = usernarme;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
