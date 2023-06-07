package mx.edu.utez.firstapp.models.user;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private String surname;
    private String birthday;
    private String username;
    private String status;

    public User() {
    }

    public User(Long id, String name, String lastname, String surname, String birthday, String username, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname=surname;
        this.birthday = birthday;
        this.username = username;
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

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
