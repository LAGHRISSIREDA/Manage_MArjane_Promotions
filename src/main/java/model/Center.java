package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Center implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameVille;

    private String nameCenter;

    //constructor
    public Center() {
    }

    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameVille() {
        return nameVille;
    }

    public void setNameVille(String nameVille) {
        this.nameVille = nameVille;
    }

    public String getNameCenter() {
        return nameCenter;
    }

    public void setNameCenter(String nameCenter) {
        this.nameCenter = nameCenter;
    }

    //toString function

    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", nameVille='" + nameVille + '\'' +
                ", nameCenter='" + nameCenter + '\'' +
                '}';
    }
}
