package mx.edu.utez.firstapp.models.user;

import mx.edu.utez.firstapp.models.crud.DaoRepository;

public class user  {
    private Long id;
    private String name;
    private String lastname;
    private String birthday;
    private String usernarme;
    private String status;

    public user() {
    }

    public user(Long id, String name, String lastname, String birthday, String usernarme, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
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
