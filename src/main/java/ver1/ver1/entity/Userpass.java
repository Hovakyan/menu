package ver1.ver1.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "userpassword")
@NoArgsConstructor

public class Userpass {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String login;

    @Column
    private  String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
