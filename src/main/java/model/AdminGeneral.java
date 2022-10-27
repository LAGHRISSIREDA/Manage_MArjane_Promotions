package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "admingeneral")
@Data
@NoArgsConstructor
public class AdminGeneral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idGeneral;



    @Basic
    @Column(name = "firtname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;


    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    //consutructors
    public AdminGeneral(String fname,String lastname,String email,String pass){
        this.firstname = fname;
        this.lastname  = lastname;
        this.email     = email;
        this.password  = pass;
    }
    //Add jointure


    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminGeneral)) return false;
        AdminGeneral that = (AdminGeneral) o;
        return idGeneral == that.idGeneral && firstname.equals(that.firstname) && lastname.equals(that.lastname) && email.equals(that.email) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGeneral, firstname, lastname, email, password);
    }

    //getters and setters


    public int getIdGeneral() {
        return idGeneral;
    }

    public void setIdGeneral(int idGeneral) {
        this.idGeneral = idGeneral;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
