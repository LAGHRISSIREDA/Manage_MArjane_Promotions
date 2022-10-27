package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "admincenter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "firstname")
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

    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminCenter)) return false;
        AdminCenter that = (AdminCenter) o;
        return id == that.id && firstname.equals(that.firstname) && lastname.equals(that.lastname) && email.equals(that.email) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password);
    }
}
